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

    //fiecare cu conexiunea  lui ca sa nu se blocheze
//    Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
//    Statement select=connection.createStatement();

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

    public void add_to_repo(Product p) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "admin","S3cret");
                //Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("insert into Client (id,name,price,stoc,type) values (?, ?, ?)")
        ) {
            statement.setInt(1, p.getId());
            statement.setString(2, p.getName());
            statement.setInt(3, (int) p.getPrice());
            statement.setInt(4,p.getStoc());
            statement.setString(5, String.valueOf(p.getType()));
           // statement.setString(3, p.getAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Database Error");
        }
        p_repo.add(p);
        //select.execute("INSERT INTO \"Client\"(id,name,address) VALUES (\"c.id\",\"c.name\",\"c.address\") ");
    }

    public void remove_from_repo(Product p){
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "admin","S3cret");
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("delete from Product where id=(?)")
        ){
            statement.setInt(1, p.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        //select.execute("DELETE FROM \"Client\" WHERE id=\"c.id\" ");
        p_repo.remove(p);
    }

    @Override
    public ArrayList<Product> get_repo() {
        return p_repo;
    }


/*
    public void add_to_repo(Product p) throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
        Statement select=connection.createStatement();
        p_repo.add(p);
        select.execute("INSERT INTO \"Product\"(id,name,price,stoc) VALUES (\"p.id\",\"p.name\",\"p.price\",\"p.stoc\") ");
    }
*/


//    public void remove_from_repo(Product p) throws SQLException {
//        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
//        Statement select=connection.createStatement();
//        select.execute("DELETE FROM \"Product\" WHERE id=\"p.id\" ");
//        p_repo.remove(p);
//    }


 /*   public void add_to_repo(Product p){
        p_repo.add(p);
    }*/

//    public void remove_from_repo(Product p){
//        p_repo.remove(p);
//    }
//TODO BUILD CONFIG, trb pus driverul acolo cumva nush cum, dar trb
    public ArrayList<Product> get_from_db() {
        ArrayList<Product> our_products=new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "admin","S3cret"); ///AICI CRAPA
                PreparedStatement statement = connection.prepareStatement("select * from Product")
        ){
            ResultSet selected_stuff= statement.executeQuery();
            while(selected_stuff.next()){
                int id=selected_stuff.getInt("id");
                String name=selected_stuff.getString("name");
                float price=selected_stuff.getInt("price");
                int stoc=selected_stuff.getInt("stoc");
                String type=selected_stuff.getString("type");
                Product product=new Product(id,name,price,ProductType.valueOf(type),stoc);
                our_products.add(product);
            }

        }
        catch(SQLException ex) {
            throw new RuntimeException("Database Error");
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