package Reposies;

import Domains.Order;

import java.util.ArrayList;

public class OrderRepo implements Repository<Order>{

    private ArrayList<Order> o_repo=new ArrayList<>();

    public void add_to_repo(Order o){
        o_repo.add(o);
    }

    public void remove_from_repo(Order o){
        o_repo.remove(o);
    }

    public ArrayList<Order> get_repo() {
        return o_repo;
    }

}
