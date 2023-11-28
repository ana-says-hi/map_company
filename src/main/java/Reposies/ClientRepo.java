package Reposies;

import Domains.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepo implements Repository<Client> {

    private ArrayList<Client> c_repo;
    Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
    Statement select=connection.createStatement();

    public ClientRepo() throws SQLException {
        c_repo=get_from_db();
    }

    public void add_to_repo(Client c) throws SQLException {
        c_repo.add(c);
        select.execute("INSERT INTO \"Client\"(id,name,address) VALUES (\"c.id\",\"c.name\",\"c.address\") ");
    }

    public void remove_from_repo(Client c) throws SQLException {
        select.execute("DELETE FROM \"Client\" WHERE id=\"c.id\" ");
        c_repo.remove(c);
    }

    public ArrayList<Client> get_repo() {
        return c_repo;
    }

    @Override
    public ArrayList<Client> get_from_db() throws SQLException {
        ArrayList<Client> our_clients=new ArrayList<>();
        ResultSet selcted_stuff= select.executeQuery("SELECT * FROM \"Client\"");
        while(selcted_stuff.next()){
            int id=selcted_stuff.getInt("id");
            String name=selcted_stuff.getString("name");
            String address=selcted_stuff.getString("address");
            Client client=new Client(id,name,address);
            our_clients.add(client);
        }
        return our_clients;
    }

    public String covertToString(List<Client> liste) {
        List<String> lines = new ArrayList<>();
        for (Client client : liste) {
            lines.add(client.toString());
        }
        return String.join("\n", lines);
    }


    public List<Client> convertFromString(String string) {
        List<Client> liste = new ArrayList<>();
        if (!string.isEmpty()) {
            String[] lines = string.split("\n");
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Client client = new Client(Integer.parseInt(parts[0]), parts[1], parts[2]);
                    liste.add(client);
                }
            }
        }
        return liste;
    }
}
