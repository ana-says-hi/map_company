package Controll;

import Domains.Order;
import Domains.Product;
import Domains.Status;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderController implements Controller{

    private String datei;
    private ArrayList<Order> stuff;

    public OrderController(String datei, ArrayList<Order> stuff) {
        this.datei ="Order.txt";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(datei);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while (true) {
            try {
                if (!((line = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stuff=convertFromString(line);
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Order> convertFromString(String string) {
        List<Order> liste = new ArrayList<>();
        if (!string.isEmpty()) {
            String[] lines = string.split("\n");
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    Order order = new Order(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[5], Status.valueOf(parts[6])); // Float.parseFloat(parts[2]), Integer.parseInt(parts[3]),Float.parseFloat(parts[4]),Integer.parseInt(parts[7]) pt deliveryyyy
                    liste.add(order);
                }
            }
        }
        return (ArrayList<Order>) liste;
    }

    public void create() {

    }


    public void update() {

    }


    @Override
    public void delete(int id) {

    }
}
