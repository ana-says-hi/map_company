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

    private ArrayList<Order> o_repo;

    public void add_to_repo(Order o){
        o_repo.add(o);
    }

    public void remove_from_repo(Order o){
        o_repo.remove(o);
    }

    public ArrayList<Order> getO_repo() {
        return o_repo;
    }


//    public List<Order> convertFromString(String string) {
//        List<Order> liste = new ArrayList<>();
//        if (!string.isEmpty()) {
//            String[] lines = string.split("\n");
//            for (String line : lines) {
//                String[] parts = line.split(",");
//                if (parts.length == 7) {
//                    Order order = new Order(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[5], Status.valueOf(parts[6])); // Float.parseFloat(parts[2]), Integer.parseInt(parts[3]),Float.parseFloat(parts[4]),Integer.parseInt(parts[7]) pt deliveryyyy
//                    liste.add(order);
//                }
//            }
//        }
//        return liste;
//    }
}
