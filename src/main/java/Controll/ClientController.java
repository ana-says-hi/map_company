package Controll;

import Domains.Client;
import Reposies.ClientRepo;
import FactoryPattern.ClientFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClientController implements Controller<Client>{
    //ca sa nu facem acum implementare de comenzi bagam mesaj cum ca suntem
    //inafara progrramului/se fac x/modificari la sistem si revenim in 2 saptamani

    private static ClientController c_instance;

    private ClientRepo clientRepo;

    private ClientController() {
        try {
            clientRepo = new ClientRepo();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Client> getClients(){return getClientRepo().get_repo();}

    public static ClientController getInstance(){
        if(c_instance==null)
            c_instance=new ClientController();
        return c_instance;
    }

    public ClientRepo getClientRepo() {
        return clientRepo;
    }


    public Client create(String name, String address) {
        Client client=ClientFactory.getInstance().make_cl(name, address);
            clientRepo.add_to_repo(client);
        return client;
    }

    public void update(int id, String name, String address) {
        delete(id);
        //create(name,address);
        Client client= new Client(id,name,address);
            clientRepo.add_to_repo(client);
    }


    public Client find_by_id(int id) {
        for(Client c: clientRepo.get_repo()) {
            if (c.getId()==id)
                return c;
        }
        return null;
    }

    public Client find_by_name(String name){
        for(Client c: clientRepo.get_repo()) {
            if (c.getName()==name)
                return c;
        }
        return null;
    }

    public void delete(int id) {
        Client c= find_by_id(id);
        if(c!=null) {
            clientRepo.remove_from_repo(c);
        }
    }
}