package Reposies;

import Domains.Product;
import Domains.ProductType;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements Repository {
//    public ProductRepo(String datei) {
//        super(datei);
//    }

    public String convertToString(List<Product> liste) {
        List<String> lines = new ArrayList<>();
        for (Product prod : liste) {
            lines.add(prod.toString());
        }
        return String.join("\n", lines);
    }

    public List<Product> convertFromString(String string) {
        List<Product> liste = new ArrayList<>();
        if (!string.isEmpty()) {
            String[] lines = string.split("\n");
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    Product prod = new Product(Integer.parseInt(parts[0]), parts[1], Float.parseFloat(parts[2]), ProductType.valueOf(parts[3]),Integer.parseInt(parts[4]));
                    liste.add(prod);
                }
            }
        }
        return liste;
    }
}