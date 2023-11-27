package FactoryPattern;

import Domains.Client;
import Domains.Deliveries.Delivery;
import Domains.Employee;
import Domains.Order;

import java.time.LocalDate;

public class OrderFactory {
    static  OrderFactory of_instance;
    private int id=5000;

    private OrderFactory(){};

    public static OrderFactory getInstance(){
        if(of_instance==null)
            of_instance=new OrderFactory();
        return of_instance;
    }

    //basic delivery
    public Order make_ord(Client client){
        Employee employee=new Employee(1234,"Annaaa","Ania1234");
        Order order= new Order(id,client,employee,LocalDate.now());
        id++;
        return order;
    }
}
