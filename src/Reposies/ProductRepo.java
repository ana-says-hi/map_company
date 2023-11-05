package Reposies;

import Domains.Client;
import Domains.Product;
import Domains.ProductType;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements Repository {

    private ArrayList<Product> p_repo;

    public void add_to_repo(Product p){
        p_repo.add(p);
    }

    public void remove_from_repo(Product p){
        p_repo.remove(p);
    }

    public ArrayList<Product> getC_repo() {
        return p_repo;
    }

//O sa avem o metoda de filtrat produse dupa tipul lor,, la controller
    // hair, body, face
    public String convertToString(List<Product> liste) {
        List<String> lines = new ArrayList<>();
        for (Product prod : liste) {
            lines.add(prod.toString());
        }
        return String.join("\n", lines);
    }

    public ArrayList<Product> convertFromString(String string) {
        List<Product> liste = new ArrayList<>();
        if (!string.isEmpty()) {
            String[] lines = string.split("\n");
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    Product prod = new Product(Integer.parseInt(parts[0]), parts[1],
                            Float.parseFloat(parts[2]), ProductType.valueOf(parts[3]),
                            Integer.parseInt(parts[4]));
                    liste.add(prod);
                }
            }
        }
        return (ArrayList<Product>) liste;
    }
}