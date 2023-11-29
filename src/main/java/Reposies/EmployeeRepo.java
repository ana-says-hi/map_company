package Reposies;

import Domains.Client;
import Domains.Employee;
import Domains.Order;
import FactoryPattern.EmployeeFactory;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeRepo implements Repository<Employee> {

    private ArrayList<Employee> e_repo;

    public EmployeeRepo(){
        e_repo=new ArrayList<>();
//        Employee e1= EmployeeFactory.getInstance().make_cl("Annaaa","Ania1234");
//        Employee e2= EmployeeFactory.getInstance().make_cl("Steff","Stef2205");
//        Employee e3= EmployeeFactory.getInstance().make_cl("Bogdie","hokedo");
//        e_repo.add(e1);
//        e_repo.add(e2);
//        e_repo.add(e3);
    }

    public void add_to_repo(Employee e) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
                //Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("insert into \"Employee\" (id,name,password) values (?, ?, ?)")
        ) {
            statement.setInt(1, e.getId());
            statement.setString(2, e.getName());
            statement.setString(3, e.getPassword());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        e_repo.add(e);
        //select.execute("INSERT INTO \"Client\"(id,name,address) VALUES (\"c.id\",\"c.name\",\"c.address\") ");
    }

    public void remove_from_repo(Employee e){
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("delete from \"Employee\" where id=(?)")
        ){
            statement.setInt(1, e.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        //select.execute("DELETE FROM \"Client\" WHERE id=\"c.id\" ");
        e_repo.remove(e);
    }


    public ArrayList<Employee> get_repo() {
        return e_repo;
    }

    @Override
    public ArrayList<Employee> get_from_db() throws SQLException {
        return null;
    }
}

//    public String covertToString(List<Employee> liste) {
//        List<String> lines = new ArrayList<>();
//        for (Employee employee : liste) {
//            lines.add(employee.toString());
//        }
//        return String.join("\n", lines);
   // }

//TODO foloseste repo.tostring nu ProdustToString

