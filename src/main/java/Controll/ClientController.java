package Controll;

import Domains.Client;
import Reposies.ClientRepo;
import FactoryPattern.ClientFactory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/client")
@Getter
@Setter
@NoArgsConstructor
public class ClientController implements Controller<Client>{
    //ca sa nu facem acum implementare de comenzi bagam mesaj cum ca suntem
    //inafara progrramului/se fac x/modificari la sistem si revenim in 2 saptamani

    //private static ClientController c_instance;

    @Autowired
    private ClientRepo clientRepo;

    @GetMapping
    public ArrayList<Client> getClients(){return getClientRepo().get_repo();}


    public ClientRepo getClientRepo() {
        return clientRepo;
    }

    @PostMapping
    public Client create(String name, String address) {
        Client client=ClientFactory.getInstance().make_cl(name, address);
            clientRepo.add_to_repo(client);
        return client;
    }

    @PutMapping
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

    @DeleteMapping("/{id}/client")
    public void delete(int id) {
        Client c= find_by_id(id);
        if(c!=null) {
            clientRepo.remove_from_repo(c);
        }
    }
}