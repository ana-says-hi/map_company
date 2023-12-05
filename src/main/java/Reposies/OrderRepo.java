package Reposies;

import Controll.ClientController;
import Controll.EmployeeController;
import Domains.Client;
import Domains.Employee;
import Domains.Order;
import Domains.Product;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderRepo implements Repository<Order>{
    private ArrayList<Order> o_repo;

    public OrderRepo() throws SQLException {
        o_repo=get_from_db();
    }


    public void add_to_repo(Order o) throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
        Statement select=connection.createStatement();
        o_repo.add(o);
        select.execute("INSERT INTO \"Order\"(id,name,address) VALUES (\"o.idfactura\",\"o.idproduct\",\"o.cantitate\") ");
    }


    public void remove_from_repo(Order o) throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
        Statement select=connection.createStatement();
        select.execute("DELETE FROM \"Order\" WHERE id=\"o.id\" ");
        o_repo.remove(o);
    }

    public void add_product_to_order(Order o, Product p) throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
        Statement select=connection.createStatement();
        o.addProduct(p);
        select.execute("INSERT INTO \"Order_Product\"(idfactura,idproduct,cantitate) VALUES (\"o.getId\",\"p.getId()\",1) ");
    }

    public void delete_product_from_order(Order o, Product p) throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
        Statement select=connection.createStatement();
        o.deleteProduct(p);
        select.execute("DELETE FROM \"Order_Product\" WHERE idfactura=\"o.id\" and idproduct=\"p.id\" ");
    }

    public ArrayList<Order> get_repo() {
        return o_repo;
    }


    @Override
    public ArrayList<Order> get_from_db() throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
        Statement select=connection.createStatement();
        ArrayList<Order> our_orders=new ArrayList<>();
        ResultSet selcted_stuff= select.executeQuery("SELECT * FROM \"Order\"");
        while(selcted_stuff.next()){
            int id=selcted_stuff.getInt("idfactura");
            int idEmployee=selcted_stuff.getInt("idemployee");
            int idClient=selcted_stuff.getInt("idclient");
            LocalDate date=selcted_stuff.getDate("date").toLocalDate();
            Client client= ClientController.getInstance().find_by_id(idClient);
            Employee employee= EmployeeController.getInstance().find_by_id(id);
            Order order=new Order(id,client,employee,date);
            our_orders.add(order);
        }
        return our_orders;
    }

}
