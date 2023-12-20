package src.Controll;

import org.springframework.http.ResponseEntity;
import src.Domains.Client;
import src.Domains.Employee;
import src.Domains.Feedback;
import src.Domains.Product;
import src.FactoryPattern.FeedbackFactory;
import src.Reposies.FeedbackRepo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/feedback")
@Getter
@Setter
@NoArgsConstructor
public class FeedbackController implements Controller<Feedback> {
    @Autowired
    private FeedbackRepo feedbackRepo;

    public FeedbackRepo getFeedbackRepo() {
        return feedbackRepo;
    }

    @GetMapping
    public ArrayList<Feedback> getFeedbacks() {
        return feedbackRepo.get_repo();
    }

    @PostMapping
    public void create(@RequestBody int clientID, @RequestBody int productID, @RequestBody String message, @RequestBody boolean type) {
        ClientController cc = new ClientController();
        Client c = cc.find_by_id(clientID);
        ProductController pc = new ProductController();
        Product p = pc.find_by_id(productID);
        Feedback feedback = FeedbackFactory.getFf_instance().make_feedb(c, p, message, type);
        feedbackRepo.add_to_repo(feedback);
    }

    @GetMapping("/{id}/feedback")
    public ResponseEntity<Employee> find_by_id(@PathVariable int id) {
        for (Feedback f : feedbackRepo.get_repo()) {
            if (f.getId() == id)
                return f;
        }
        return null;
    }

    public ResponseEntity<Void> delete(@PathVariable int id) {
        Feedback f = find_by_id(id);
        if (f != null)
            feedbackRepo.remove_from_repo(f);
        return null;
    }
}