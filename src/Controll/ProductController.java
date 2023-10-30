package Controll;

import Domains.Product;
import Domains.ProductType;
//import Reposies.ProductRepo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductController implements Controller{
    private String datei;
    private ArrayList<Product> stuff;

    public ArrayList<Product> getStuff() {
        return stuff;
    }

    //TODO convert from string ce e in datei si mutat in lista
    public ProductController() throws IOException {
        this.datei = "src/Files/Products.txt";
        FileReader fileReader = new FileReader(datei);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stuff=convertFromString(line);
        }
        bufferedReader.close();
    }

    //TODO DC E ASTA AICI???
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
    public void create(int id, String name, float price, ProductType type, int stoc) throws IOException {
        Product prod= new Product(id, name, price, type, stoc);
        stuff.add(prod);
        FileWriter fileWriter = new FileWriter(datei);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(prod.toString());
        bufferedWriter.close();
    }


    public void update() {

    }

    public Product find(int id) {
        for(Product prod: stuff)
            if(prod.getId()==id)
                return prod;
        return null;
    }

    @Override
    public void delete(int id) {
        Product prod=find(id);
        stuff.remove(prod);
    }
}
