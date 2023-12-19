package Controll;

import Domains.*;
import Domains.Deliveries.Delivery;
import Domains.Deliveries.FragileStuffDelivery;
import Domains.Deliveries.SameDayDelivery;
import Domains.Deliveries.SuperSafeDelivery;
import FactoryPattern.OrderFactory;
import Reposies.OrderRepo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//TODO set delivery
//TODO CURRENT DATE AND TIME LA ORDER SI LA DELIVERY
//TODO FILTER PENTRU STATUS ORDER
@RestController
@RequestMapping("/api/order")
@Getter
@Setter
@NoArgsConstructor
public class OrderController implements Controller<Order>{

    //private static OrderController o_instance;
    ClientController cc=new ClientController();
    ProductController pc=new ProductController();

    @Autowired
    private OrderRepo orderRepo;

    @GetMapping
    public OrderRepo getOrderRepo() {
        return orderRepo;
    }

    @PostMapping
    public Order create(Client client) {
        //Order o=new Order(id,client,employee,date);
        Order o= OrderFactory.getInstance().make_ord(client);
        orderRepo.add_to_repo(o);
        return o;
    }

//TODO SCHIMBAT UPDATE, SA RAMANA CUMVA PRODUSELE SI SA SE SCHIMBE STATUSUL
    public void update(int id, Client client, Employee employee,Delivery delivery, LocalDate date, Status status) {
        Order old_ord= find_by_id(id);
        delete(id);
        Order o=new Order(id,client,employee,old_ord.getTotalPrice(),date,status,old_ord.getDelivery(),old_ord.getProducts());
        orderRepo.add_to_repo(o);
    }

    public Order find_by_id(int id){
        for(Order ord: orderRepo.get_repo())
            if(ord.getId()==id)
                return ord;
        return null;
    }

    public ArrayList<Order>find_by_client(String name){
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
    public void delete(int id) {
        Order ord= find_by_id(id);
        orderRepo.remove_from_repo(ord);
    }

    public void chooseDelivery(String this_guy,int deliv){
        Order the_order=find_last_order_unplaced(this_guy);
        Delivery delivery=null;
        switch (deliv){
            case 1:
                //fragil
                delivery=new FragileStuffDelivery(the_order.getId(),the_order.getDate());
                the_order.setDelivery(delivery);
                the_order.finishOrder();
                break;
            case 2:
                //same day
                delivery=new SameDayDelivery(the_order.getId(),the_order.getDate());
                the_order.setDelivery(delivery);
                the_order.finishOrder();
                break;
            case 3:
                //super safe
                delivery=new SuperSafeDelivery(the_order.getId(),the_order.getDate());
                the_order.setDelivery(delivery);
                the_order.finishOrder();
                break;
            default:
                //basic
                the_order.finishOrder();
                break;
        }
    }
}
