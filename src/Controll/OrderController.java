package Controll;

import Domains.*;
import Reposies.OrderRepo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderController implements Controller<Order>{

    private OrderRepo orderRepo;

    public OrderController(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }


    public void create(int id, Client client, Employee employee, LocalDate date) {
        Order o=new Order(id,client,employee,date);
        orderRepo.add_to_repo(o);
    }

//TODO SCHIMBAT UPDATE, SA RAMANA CUMVA PRODUSELE SI SA SE SCHIMBE STATUSUL
    public void update(int id,Client client, Employee employee, LocalDate date, Status status) {
        delete(id);
        Order o=new Order(id,client,employee,date,status);
        orderRepo.add_to_repo(o);
    }

    public Order find(int id){
        for(Order ord: orderRepo.getO_repo())
            if(ord.getId()==id)
                return ord;
        return null;
    }

    @Override
    public void delete(int id) {
        Order ord= find(id);
        orderRepo.remove_from_repo(ord);
    }
}
