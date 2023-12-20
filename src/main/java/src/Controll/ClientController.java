package src.Controll;

import org.springframework.http.ResponseEntity;
import src.Domains.Client;
import src.Domains.Product;
import src.Reposies.ClientRepo;
import src.FactoryPattern.ClientFactory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/client")
@Getter
@Setter
@NoArgsConstructor
public class ClientController implements Controller<Client> {
    //ca sa nu facem acum implementare de comenzi bagam mesaj cum ca suntem
    //inafara progrramului/se fac x/modificari la sistem si revenim in 2 saptamani

    //private static ClientController c_instance;

    @Autowired
    private ClientRepo clientRepo;

    @GetMapping
    public ArrayList<Client> getClients() {
        return getClientRepo().get_repo();
    }

    public ClientRepo getClientRepo() {
        return clientRepo;
    }

    @PostMapping
    public Client create(@RequestBody String name, @RequestBody String address) {
        Client client = ClientFactory.getInstance().make_cl(name, address);
        clientRepo.add_to_repo(client);
        return client;
    }

    @PutMapping
    public void update(@RequestBody int id, @RequestBody String name, @RequestBody String address) {
        delete(id);
        //create(name,address);
        Client client = new Client(id, name, address);
        clientRepo.add_to_repo(client);
    }


    @GetMapping("/{id}/client")
    public ResponseEntity<Product> find_by_id(@PathVariable int id) {
        for (Client c : clientRepo.get_repo()) {
            if (c.getId() == id)
                return c;
        }
        return null;
    }

    @GetMapping("/{name}/client")
    public Client find_by_name(@PathVariable String name) {
        for (Client c : clientRepo.get_repo()) {
            if (c.getName() == name)
                return c;
        }
        return null;
    }

    @DeleteMapping("/{id}/client")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Client c = find_by_id(id);
        if (c != null) {
            clientRepo.remove_from_repo(c);
        }
        return null;
    }
}