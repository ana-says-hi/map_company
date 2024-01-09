package the_spring_src.Controll;

import org.springframework.http.ResponseEntity;
import the_spring_src.Domains.Client;
import the_spring_src.Reposies.ClientRepo;
import the_spring_src.FactoryPattern.ClientFactory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import the_spring_src.RequestStuff.ClientRequest;

import java.util.List;
import java.util.Optional;

@RestController
//@org.springframework.stereotype.Controller
@RequestMapping("/api/client")
@Getter
@Setter
//@NoArgsConstructor
public class ClientController implements Controller<Client> {
    //ca sa nu facem acum implementare de comenzi bagam mesaj cum ca suntem
    //inafara progrramului/se fac x/modificari la sistem si revenim in 2 saptamani

    //private static ClientController c_instance;

    @Autowired
    private ClientRepo clientRepo;

    public ClientController() {
    }

    @GetMapping
    public ResponseEntity<List<Client>> getClients() {
        List<Client> clients = getClientRepo().findAll();
        if (!clients.isEmpty()) {
            return ResponseEntity.ok(clients);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    public ClientRepo getClientRepo() {
        return clientRepo;
    }


    @PostMapping
    public void create(@RequestBody ClientRequest request) {
        String name = request.getName();
        String address = request.getAddress();

        Client client = ClientFactory.getInstance().make_cl(name, address);
        clientRepo.save(client);
        //clientRepo.add_to_repo(client);
        //return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody ClientRequest request) {
        Optional<Client> optionalClient = clientRepo.findById(id);

        if (optionalClient.isPresent()) {
            Client existingClient = optionalClient.get();

            clientRepo.delete(existingClient);

            existingClient.setName(request.getName());
            existingClient.setAddress(request.getAddress());

            clientRepo.save(existingClient);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> find_by_id(@PathVariable int id) {
        Optional<Client> optionalClient = clientRepo.findById(id);
        if (optionalClient.isPresent()) {
            return (ResponseEntity<Client>) ResponseEntity.ok();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //@GetMapping("/{name}")
    public Client find_by_name(@PathVariable String name) {
        for (Client c : clientRepo.findAll()) {
            if (c.getName() == name)
                return c;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Optional<Client> optionalClient = clientRepo.findById(id);

        if (optionalClient.isPresent()) {
            clientRepo.deleteById(id);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public void deleteAall(){
        clientRepo.deleteAll();
    }


}