package Reposies;

import Domains.Product;

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
//            String line = prod.getId() + "|" + prod.getName() + "|" + prod.getPortionsgroesse() + "|" + prod.getPreis() + "|" + prod.getZubereitungszeit();
//            lines.add(line);
        }
        return String.join("\n", lines);
    }

    public List<Product> convertFromString(String string) {
        List<Product> liste = new ArrayList<>();
        if (!string.isEmpty()) {
            String[] lines = string.split("\n");
            for (String line : lines) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    Product prod = new Product(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    liste.add(prod);
                }
            }
        }
        return liste;
    }
}