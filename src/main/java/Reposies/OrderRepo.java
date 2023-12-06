package Reposies;

import Controll.ClientController;
import Controll.EmployeeController;
import Domains.*;
//import org.checkerframework.checker.units.qual.C;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderRepo implements Repository<Order>{
    private ArrayList<Order> o_repo;

    public OrderRepo() throws SQLException {
        o_repo=get_from_db();
    }

    public void add_to_repo(Order o) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin", "S3cret");
                //Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("insert into \"Order\" (id,idemployee,idclient,totalprice,date,status,delivery) values (?, ?, ?,?,?,?,?)")
        ) {
            statement.setInt(1, o.getId());
            statement.setInt(2, o.getEmployee().getId());
            statement.setInt(3, o.getClient().getId());
            statement.setFloat(4, o.getTotalPrice());
            statement.setDate(5,Date.valueOf(o.getDate()));
            statement.setString(6,o.getStatus().toString());
            statement.setString(7,"NULL");
            statement.executeUpdate();
        } catch (SQLException e) {
            try {
                throw e;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            //throw new RuntimeException("Database Error");
        }
        o_repo.add(o);
        //select.execute("INSERT INTO \"Client\"(id,name,address) VALUES (\"c.id\",\"c.name\",\"c.address\") ");
    }

    public void remove_from_repo(Order o) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("delete from \"Order\" where id=(?)")
        ){
            statement.setInt(1, o.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        //select.execute("DELETE FROM \"Client\" WHERE id=\"c.id\" ");
        o_repo.remove(o);

    }


    public void add_product_to_order(Order o, Product p){
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin", "S3cret");
                PreparedStatement statement = connection.prepareStatement("INSERT INTO \"Order_Product\"(idfactura,idproduct,cantitate) VALUES (?,?,1)")
        ) {
            statement.setInt(1, o.getId());
            statement.setInt(2, p.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            try {
                throw e;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        o.addProduct(p);
    }

    public void delete_product_from_order(Order o, Product p) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("DELETE FROM \"Order_Product\" WHERE idfactura=(?) and idproduct=(?)")
        ){
            statement.setInt(1, o.getId());
            statement.setInt(2, p.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        o.deleteProduct(p);
        //select.execute("DELETE FROM \"Order_Product\" WHERE idfactura=\"o.id\" and idproduct=\"p.id\" ");
    }

    public ArrayList<Order> get_repo() {
        return o_repo;
    }


    @Override
    public ArrayList<Order> get_from_db() {
        ArrayList<Order> our_orders=new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("select * from \"Order\"")
        ){
            ResultSet selected_stuff= statement.executeQuery();
            while(selected_stuff.next()){
                int id=selected_stuff.getInt("id");
                int idemployee=selected_stuff.getInt("idemployee");
                int idclient=selected_stuff.getInt("idclient");
                float totalprie=selected_stuff.getFloat("totalprice");
                String status=selected_stuff.getString("status");
                LocalDate date= selected_stuff.getDate("date").toLocalDate();
                Employee employee=EmployeeController.getInstance().find_by_id(idemployee);
                Client client= ClientController.getInstance().find_by_id(idclient);
                Order order=new Order(id,client,employee,totalprie,date, Status.valueOf(status));
                our_orders.add(order);
            }
        }
        catch(SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        return our_orders;
    }

}
