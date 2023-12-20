package src.Controll;

import org.springframework.http.ResponseEntity;
import src.CommandProcessPattern.OrderProcessor;
import src.Domains.*;
import src.Domains.Deliveries.Delivery;
import src.Domains.Deliveries.FragileStuffDelivery;
import src.Domains.Deliveries.SameDayDelivery;
import src.Domains.Deliveries.SuperSafeDelivery;
import src.FactoryPattern.OrderFactory;
import src.Reposies.OrderRepo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

//TODO set delivery
//TODO CURRENT DATE AND TIME LA ORDER SI LA DELIVERY
//TODO FILTER PENTRU STATUS ORDER
@RestController
@RequestMapping("/api/order")
@Getter
@Setter
@NoArgsConstructor
public class OrderController implements Controller<Order>{
    OrderProcessor orderProcessor;

    ClientController cc=new ClientController();
    ProductController pc=new ProductController();


    @Autowired
    private OrderRepo orderRepo;

    public OrderRepo getOrderRepo() {
        return orderRepo;
    }

    @GetMapping
    public ArrayList<Order> getOrders(){return orderRepo.get_repo();}

    @PostMapping
    public Order create(@RequestBody Client client) {
        //Order o=new Order(id,client,employee,date);
        Order o= OrderFactory.getInstance().make_ord(client);
        orderRepo.add_to_repo(o);
        return o;
    }

    @PutMapping
    public void update(@RequestBody int id, @RequestBody Client client, @RequestBody Employee employee, @RequestBody LocalDate date, @RequestBody Status status) {
        Order old_ord= find_by_id(id);
        delete(id);
        Order o=new Order(id,client,employee,old_ord.getTotalPrice(),date,status,old_ord.getDelivery(),old_ord.getProducts());
        orderRepo.add_to_repo(o);
    }


    @GetMapping("/{id}/order")
    public ResponseEntity<Client> find_by_id(@RequestBody int id){
        for(Order ord: orderRepo.get_repo())
            if(ord.getId()==id)
                return ord;
        return null;
    }

    @GetMapping("/{name}/order")
    public ArrayList<Order>find_by_client(@RequestBody String name){
        ArrayList<Order> them_products=new ArrayList<>();
        Client our_client=cc.find_by_name(name);
        if(our_client!=null)
            for(Order ord: orderRepo.get_repo())
                if(ord.getClient()==our_client)
                    them_products.add(ord);
        return them_products;
    }

    private Order find_last_order_unplaced(String this_guy){
        ArrayList<Order> formal_buiyng_requests=find_by_client(this_guy);
        return formal_buiyng_requests.stream()
                .filter((x)->x.getStatus()==Status.PENDING)
                .max(Comparator.comparing(Order::getDate))
                .orElse(null);
    }

    public void for_client_add_product(String this_guy, ArrayList<Integer> i_wanna_buy) throws SQLException {
        if(cc.find_by_name(this_guy)!=null)
        {
            ProductController pc=new ProductController();
            Order here_we_buy=find_last_order_unplaced(this_guy);
            if(here_we_buy!=null)
                for (Integer id_prod: i_wanna_buy) {
                    Product product=pc.find_by_id(id_prod);
                    orderRepo.add_product_to_order(here_we_buy,product);
                }
        }
    }

    public void for_client_delete_product(String this_guy, ArrayList<Integer> i_wanna_buy) throws SQLException {
        Order here_we_buy=find_last_order_unplaced(this_guy);
        ProductController pc=new ProductController();
        if(here_we_buy!=null)
            for (Integer id_prod: i_wanna_buy) {
                Product product=pc.find_by_id(id_prod);
                orderRepo.delete_product_from_order(here_we_buy,product);
            }
    }

    @Override
    @DeleteMapping("/{id}/order")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Order ord= find_by_id(id);
        orderRepo.remove_from_repo(ord);
        return null;
    }

    public void chooseDelivery(String this_guy,int deliv) throws SQLException {
        Order the_order=find_last_order_unplaced(this_guy);
        Delivery delivery=null;
        switch (deliv){
            case 1:
                //fragil
                delivery=new FragileStuffDelivery(the_order.getId(),the_order.getDate());
                the_order.setDelivery(delivery);
                break;
            case 2:
                //same day
                delivery=new SameDayDelivery(the_order.getId(),the_order.getDate());
                the_order.setDelivery(delivery);
                break;
            case 3:
                //super safe
                delivery=new SuperSafeDelivery(the_order.getId(),the_order.getDate());
                the_order.setDelivery(delivery);
                break;
            default:
                //basic
                break;
        }
        orderProcessor=new OrderProcessor(the_order);
        orderProcessor.processCommand();
        //@ int id,@ Client client,@ Employee employee,@ LocalDate date,@ Status status
        //the_order.finishOrder();
    }
}
