package Controll;

import Domains.Client;
import Domains.Feedback;
import Domains.Product;
import FactoryPattern.FeedbackFactory;
import Reposies.FeedbackRepo;

import java.util.ArrayList;
import java.util.List;

public class FeedbackController implements Controller<Feedback>{
    //ca sa nu facem acum implementare de comenzi bagam mesaj cum ca suntem
    //inafara progrramului/se fac renovari/modificari la sistem si revenim in 2 saptamani

    private static FeedbackController f_instance;

    private FeedbackRepo feedbackRepo;

    private FeedbackController() {
        feedbackRepo = new FeedbackRepo();
    }

    //public ArrayList<Client> getClients(){return getClientRepo().getC_repo();}
    private static List<Product> productsWithFeedbacks = new ArrayList<>();
    public static FeedbackController getInstance(){
        if(f_instance==null)
            f_instance=new FeedbackController();
        return f_instance;
    }

    public FeedbackRepo getFeedbackRepo() {
        return feedbackRepo;
    }

    public void create(int clientID, int productID, String message, boolean type) {
        Client c=ClientController.getInstance().find(clientID);
        Product p=ProductController.getInstance().find(productID);
        Feedback feedback= FeedbackFactory.getFf_instance().make_feedb(c, p, message, type);
        feedbackRepo.add_to_repo(feedback);
    }

    public Feedback find(int id) {
        for(Feedback f: feedbackRepo.getF_repo()) {
            if (f.getId()==id)
                return f;
        }
        return null;
    }
    //nu il apelam :)
    public void delete(int id) {
        Feedback f=find(id);
        if(f!=null)
            feedbackRepo.remove_from_repo(f);
    }
}