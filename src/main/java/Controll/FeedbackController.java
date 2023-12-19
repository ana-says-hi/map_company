package Controll;

import Domains.Client;
import Domains.Feedback;
import Domains.Product;
import FactoryPattern.FeedbackFactory;
import Reposies.FeedbackRepo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@Getter
@Setter
@NoArgsConstructor
public class FeedbackController implements Controller<Feedback>{
    //ca sa nu facem acum implementare de comenzi bagam mesaj cum ca suntem
    //inafara progrramului/se fac renovari/modificari la sistem si revenim in 2 saptamani

    @Autowired
    private FeedbackRepo feedbackRepo;

    @GetMapping
    public FeedbackRepo getFeedbackRepo() {
        return feedbackRepo;
    }

    @PostMapping
    public void create(int clientID, int productID, String message, boolean type) {
        ClientController cc=new ClientController();
        Client c=cc.find_by_id(clientID);
        ProductController pc=new ProductController();
        Product p=pc.find_by_id(productID);
        Feedback feedback= FeedbackFactory.getFf_instance().make_feedb(c, p, message, type);
        feedbackRepo.add_to_repo(feedback);
    }

    public Feedback find_by_id(int id) {
        for(Feedback f: feedbackRepo.get_repo()) {
            if (f.getId()==id)
                return f;
        }
        return null;
    }
    //nu il apelam :)
    public void delete(int id) {
        Feedback f= find_by_id(id);
        if(f!=null)
            feedbackRepo.remove_from_repo(f);
    }
}