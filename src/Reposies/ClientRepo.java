package Reposies;

import Domains.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepo implements Repository {

    private ArrayList<Client> c_repo=new ArrayList<>();

    public void add_to_repo(Client c){
        c_repo.add(c);
    }

    public void remove_from_repo(Client c){
        c_repo.remove(c);
    }

    public ArrayList<Client> getC_repo() {
        return c_repo;
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
