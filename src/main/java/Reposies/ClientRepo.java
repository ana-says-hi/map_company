package Reposies;

import Domains.Client;

import java.sql.*;
import java.util.ArrayList;

public class ClientRepo implements Repo<Client> {

    private ArrayList<Client> c_repo;

    public ClientRepo() throws SQLException {
        c_repo=get_from_db();
    }

    public void add_to_repo(Client c) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
                //Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("insert into \"Client\" (id,name,address) values (?, ?, ?)")
        ) {
            statement.setInt(1, c.getId());
            statement.setString(2, c.getName());
            statement.setString(3, c.getAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Database Error");
        }
        c_repo.add(c);
        //select.execute("INSERT INTO \"Client\"(id,name,address) VALUES (\"c.id\",\"c.name\",\"c.address\") ");
    }

    public void remove_from_repo(Client c){
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("delete from \"Client\" where id=(?)")
        ){
            statement.setInt(1, c.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        //select.execute("DELETE FROM \"Client\" WHERE id=\"c.id\" ");
        c_repo.remove(c);
    }

    public ArrayList<Client> get_repo() {
        return c_repo;
    }

    @Override
    public ArrayList<Client> get_from_db() throws SQLException {
        ArrayList<Client> our_clients=new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("select * from \"Client\"")
        ){
            ResultSet selected_stuff= statement.executeQuery();
            while(selected_stuff.next()){
                int id=selected_stuff.getInt("id");
                String name=selected_stuff.getString("name");
                String address=selected_stuff.getString("address");
                Client client=new Client(id,name,address);
                our_clients.add(client);
            }
        }
        catch(SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        return our_clients;
    }

}
