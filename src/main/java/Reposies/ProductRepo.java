package Reposies;

import Domains.Client;
import Domains.Product;
import Domains.ProductType;
import FactoryPattern.ProductFactory;
import com.sun.jdi.Value;

import java.sql.*;
import java.util.ArrayList;

import static Domains.ProductType.hair;

public class ProductRepo implements Repository <Product>{

    private ArrayList<Product> p_repo;

    Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
    Statement select=connection.createStatement();

    public ProductRepo() throws SQLException {
        p_repo=get_from_db();
//        Product p1= ProductFactory.getInstance().make_prod("BioLite Curly Hair Mask",78,hair,5019);
//        Product p2= ProductFactory.getInstance().make_prod("BioLite Curly Hair Shampoo",78,hair,20);
//        Product p3= ProductFactory.getInstance().make_prod("BioLite Curly Hair Conditioner",65,hair,5021);
//        Product p4= ProductFactory.getInstance().make_prod("BioLite Soft Bath Towel",95,hair,502);
//        Product p5= ProductFactory.getInstance().make_prod("BioLite Organic Argan Oil",50,hair,50);
//        p_repo.add(p1);
//        p_repo.add(p2);
//        p_repo.add(p3);
//        p_repo.add(p4);
//        p_repo.add(p5);
    }
    public void add_to_repo(Product p) throws SQLException {
        p_repo.add(p);
        select.execute("INSERT INTO \"Product\"(id,name,price,stoc) VALUES (\"p.id\",\"p.name\",\"p.price\",\"p.stoc\") ");
    }


    public void remove_from_repo(Product p) throws SQLException {
        select.execute("DELETE FROM \"Product\" WHERE id=\"p.id\" ");
        p_repo.remove(p);
    }


 /*   public void add_to_repo(Product p){
        p_repo.add(p);
    }*/

//    public void remove_from_repo(Product p){
//        p_repo.remove(p);
//    }

    public ArrayList<Product> get_repo() {
        return p_repo;
    }

    public ArrayList<Product> get_from_db() throws SQLException {
        ArrayList<Product> our_products=new ArrayList<>();
        ResultSet selcted_stuff= select.executeQuery("SELECT * FROM \"Product\"");
        while(selcted_stuff.next()){
            int id=selcted_stuff.getInt("id");
            String name=selcted_stuff.getString("name");
            String type=selcted_stuff.getString("type");
            float price=selcted_stuff.getInt("price");
            int stoc=selcted_stuff.getInt("stoc");
            Product product=new Product(id,name,price, ProductType.valueOf(type),stoc);
            our_products.add(product);
        }
        return our_products;
    }

    public ArrayList<Product> filterProductsByType(ProductType type) {
        ArrayList<Product> filteredProducts = new ArrayList<>();
        for (Product product : p_repo) {
            if (product.getType() == type) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

//O sa avem o metoda de filtrat produse dupa tipul lor,, la controller
    // hair, body, face
//    public String convertToString(List<Product> liste) {
//        List<String> lines = new ArrayList<>();
//        for (Product prod : liste) {
//            lines.add(prod.toString());
//        }
//        return String.join("\n", lines);
//    }
//
//    public ArrayList<Product> convertFromString(String string) {
//        List<Product> liste = new ArrayList<>();
//        if (!string.isEmpty()) {
//            String[] lines = string.split("\n");
//            for (String line : lines) {
//                String[] parts = line.split(",");
//                if (parts.length == 5) {
//                    Product prod = new Product(Integer.parseInt(parts[0]), parts[1],
//                            Float.parseFloat(parts[2]), ProductType.valueOf(parts[3]),
//                            Integer.parseInt(parts[4]));
//                    liste.add(prod);
//                }
//            }
//        }
//        return (ArrayList<Product>) liste;
//    }
}