package Controll;

import Domains.Client;
import Domains.Product;
import Reposies.ClientRepo;

import java.util.ArrayList;

public class ClientController implements Controller{
    //ca sa nu facem acum implementare de comenzi bagam mesaj cum ca suntem
    //inafara progrramului/se fac renovari/modificari la sistem si revenim in 2 saptamani

    ClientRepo clientRepo;

    public ClientController(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public void create(int id, String name, String address) {
        Client client=new Client(id,name,address);
        clientRepo.add_to_repo(client);
    }


    public void update(int id, String name, String address) {
        delete(id);
        create(id,name,address);
    }


    public Client find(int id) {
        for(Client c: clientRepo.getC_repo()) {
            if (c.getId()==id)
                return c;
        }
        return null;
    }

    public void delete(int id) {
        Client c=find(id);
        if(c!=null)
            clientRepo.remove_from_repo(c);
    }
}