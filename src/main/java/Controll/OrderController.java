package Controll;

import Domains.*;
import Domains.Deliveries.Delivery;
import FactoryPattern.OrderFactory;
import Reposies.OrderRepo;

import java.sql.SQLException;
import java.time.LocalDate;

//TODO set delivery
//TODO CURRENT DATE AND TIME LA ORDER SI LA DELIVERY
//TODO FILTER PENTRU STATUS ORDER
public class OrderController implements Controller<Order>{

    private static OrderController o_instance;

    private OrderRepo orderRepo;

    private OrderController() {
        try {
            orderRepo=new OrderRepo();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static OrderController getInstance(){
        if(o_instance==null)
            o_instance=new OrderController();
        return o_instance;
    }

    public Order create(Client client) {
        //Order o=new Order(id,client,employee,date);
        Order o= OrderFactory.getInstance().make_ord(client);
        try {
            orderRepo.add_to_repo(o);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return o;
    }

//TODO SCHIMBAT UPDATE, SA RAMANA CUMVA PRODUSELE SI SA SE SCHIMBE STATUSUL
    public void update(int id, Client client, Employee employee,Delivery delivery, LocalDate date, Status status) {
        Order old_ord= find(id);
        delete(id);
        Order o=new Order(id,client,employee,old_ord.getProducts(),delivery,date,status);
        try {
            orderRepo.add_to_repo(o);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Order find(int id){
        for(Order ord: orderRepo.get_repo())
            if(ord.getId()==id)
                return ord;
        return null;
    }

    @Override
    public void delete(int id) {
        Order ord= find(id);
        try {
            orderRepo.remove_from_repo(ord);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void chooseDelivery(int deliv){
        switch (deliv){
            case 1:
           //     BasicDelivery dev= new BasicDelivery();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
        }
    }
}
