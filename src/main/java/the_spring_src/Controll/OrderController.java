package the_spring_src.Controll;

import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import the_spring_src.CommandProcessPattern.OrderProcessor;
import the_spring_src.Domains.*;
import the_spring_src.Domains.Deliveries.Delivery;
import the_spring_src.Domains.Deliveries.FragileStuffDelivery;
import the_spring_src.Domains.Deliveries.SameDayDelivery;
import the_spring_src.Domains.Deliveries.SuperSafeDelivery;
import the_spring_src.FactoryPattern.OrderFactory;
import the_spring_src.Reposies.OrderRepo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import the_spring_src.Reposies.ProdInOrderRepo;
import the_spring_src.RequestStuff.OrderRequest;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Getter
@Setter
public class OrderController implements Controller<Order> {
    OrderProcessor orderProcessor;

    @Autowired
    private OrderRepo orderRepo;
    private ProdInOrderRepo prodInOrderRepo;

    public OrderController() {
    }

    public OrderRepo getOrderRepo() {
        return orderRepo;
    }

    @GetMapping("/order")
    public ResponseEntity<List<Order>> getOrders(){
        List<Order> orders = orderRepo.findAll();
        if (!orders.isEmpty()) {
            return ResponseEntity.ok(orders);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/order")
    public void create(@RequestBody OrderRequest client) {
        ClientController cc = new ClientController();
        Client client1= cc.find_by_id(client.getClient()).getBody();
        Order o = OrderFactory.getInstance().make_ord(client1);
        orderRepo.save(o);
    }

    @PutMapping("/order/{id}")
    public void update(@PathVariable int id, @RequestBody Client client, @RequestBody Employee employee, @RequestBody LocalDate date, @RequestBody Status status) {
        Order old_ord = find_by_id(id).getBody();
        delete(id);
        Order o = new Order(id, client, employee, old_ord.getTotalPrice(), date, status, old_ord.getDelivery(), old_ord.getProducts());
        orderRepo.save(o);
    }


    @GetMapping("/order/{id}")
    public ResponseEntity<Order> find_by_id(@PathVariable int id) {
        Optional<Order> optionalOrder = orderRepo.findById(id);
        if (optionalOrder.isPresent()) {
            return ResponseEntity.ok(optionalOrder.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //@GetMapping("/{name}/order")
    public ArrayList<Order> find_by_client(@RequestBody String name) {
        ClientController cc = new ClientController();

        ArrayList<Order> them_products = new ArrayList<>();
        Client our_client = cc.find_by_name(name);
        if (our_client != null)
            for (Order ord : orderRepo.findAll())
                if (ord.getClient() == our_client)
                    them_products.add(ord);
        return them_products;
    }

    private Order find_last_order_unplaced(String this_guy) {
        ArrayList<Order> formal_buiyng_requests = find_by_client(this_guy);
        return formal_buiyng_requests.stream()
                .filter((x) -> x.getStatus() == Status.PENDING)
                .max(Comparator.comparing(Order::getDate))
                .orElse(null);
    }

    //TODO SMTH WITH THIS
    public void for_client_add_product(String this_guy, ArrayList<Integer> i_wanna_buy) throws SQLException {
        ClientController cc = new ClientController();
        if (cc.find_by_name(this_guy) != null) {
            ProductController pc = new ProductController();
            Order here_we_buy = find_last_order_unplaced(this_guy);
            if (here_we_buy != null)
                for (Integer id_prod : i_wanna_buy) {
                    Product product = pc.find_by_id(id_prod).getBody();
                    prodInOrderRepo.save(new ProdInOrderEntity(here_we_buy.getId(), product));
                    here_we_buy.addProduct(product);
                }
        }
    }

    //TODO SMTH WITH THIS
    public void for_client_delete_product(String this_guy, ArrayList<Integer> i_wanna_buy) throws SQLException {
        Order here_we_buy = find_last_order_unplaced(this_guy);
        ProductController pc = new ProductController();
        if (here_we_buy != null)
            for (Integer id_prod : i_wanna_buy) {
                Product product = pc.find_by_id(id_prod).getBody();
                prodInOrderRepo.delete(new ProdInOrderEntity(here_we_buy.getId(), product));
                here_we_buy.deleteProduct(product);
            }
    }

    @Override
    @DeleteMapping("/order/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Order ord = find_by_id(id).getBody();
        if (ord != null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void chooseDelivery(String this_guy, int deliv) throws SQLException {
        Order the_order = find_last_order_unplaced(this_guy);
        Delivery delivery = null;
        switch (deliv) {
            case 1:
                //fragil
                delivery = new FragileStuffDelivery(the_order.getId(), the_order.getDate());
                the_order.setDelivery(delivery);
                break;
            case 2:
                //same day
                delivery = new SameDayDelivery(the_order.getId(), the_order.getDate());
                the_order.setDelivery(delivery);
                break;
            case 3:
                //super safe
                delivery = new SuperSafeDelivery(the_order.getId(), the_order.getDate());
                the_order.setDelivery(delivery);
                break;
            default:
                //basic
                break;
        }
        orderProcessor = new OrderProcessor(the_order, orderRepo);
        orderProcessor.processCommand();
        //@ int id,@ Client client,@ Employee employee,@ LocalDate date,@ Status status
        //the_order.finishOrder();
    }

    @DeleteMapping("/order")
    public void deleteAall() {
        orderRepo.deleteAll();
    }
}
