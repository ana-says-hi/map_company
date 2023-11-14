package Reposies;

import Domains.Client;
import Domains.Order;
import Domains.Product;
import Domains.Status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderRepo implements Repository{

    private ArrayList<Order> o_repo=new ArrayList<>();

    public void add_to_repo(Order o){
        o_repo.add(o);
    }

    public void remove_from_repo(Order o){
        o_repo.remove(o);
    }

    public ArrayList<Order> getO_repo() {
        return o_repo;
    }

}
