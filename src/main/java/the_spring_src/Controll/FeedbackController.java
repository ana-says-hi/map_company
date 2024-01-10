package the_spring_src.Controll;

import org.springframework.http.ResponseEntity;
import the_spring_src.Domains.Client;
import the_spring_src.Domains.Feedback;
import the_spring_src.Domains.Product;
import the_spring_src.FactoryPattern.FeedbackFactory;
import the_spring_src.Reposies.ClientRepo;
import the_spring_src.Reposies.FeedbackRepo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import the_spring_src.Reposies.ProductRepo;
import the_spring_src.RequestStuff.FeedbackRequest;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedback")
@Getter
@Setter
@NoArgsConstructor
public class FeedbackController implements Controller<Feedback> {
    @Autowired
    private FeedbackRepo feedbackRepo;
    private ClientRepo clientRepo;
    private ProductRepo productRepo;

    public FeedbackRepo getFeedbackRepo() {
        return feedbackRepo;
    }

    @GetMapping
    public ArrayList<Feedback> getFeedbacks() {
        return (ArrayList<Feedback>) feedbackRepo.findAll();
    }

    @PostMapping
    public void create(@RequestBody FeedbackRequest request) {
        Integer clientID = request.getClientID();
        Integer productID = request.getProductID();
        String message = request.getMessage();
        Boolean type = request.isType();
        Client client = clientRepo.getById(clientID);
                //.orElseThrow(() -> new RuntimeException("Nu s-a gasit client cu id-ul: " + clientID));
        Product product = productRepo.getById(productID);
                //.orElseThrow(() -> new RuntimeException("Nu s-a gasit produs cu id-ul: " + productID));
        Feedback feedback = FeedbackFactory.getFf_instance().make_feedb(client, product, message, type);
        feedbackRepo.save(feedback);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> find_by_id(@PathVariable int id) {
        Optional<Feedback> optionalFeedback = feedbackRepo.findById(id);
        if (optionalFeedback.isPresent()) {
            return ResponseEntity.ok(optionalFeedback.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Feedback f = find_by_id(id).getBody();
        if (f != null) {
            // feedbackRepo.remove_from_repo(f);
            feedbackRepo.delete(f);
            return ResponseEntity.noContent().build();
        } else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public void deleteAall(){
        feedbackRepo.deleteAll();
    }
}