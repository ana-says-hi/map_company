package the_spring_src.FactoryPattern;

import the_spring_src.Domains.Client;
import the_spring_src.Domains.Feedback;
import the_spring_src.Domains.Product;

public class FeedbackFactory {
    static FeedbackFactory ff_instance;
    private int id=10000;

    private FeedbackFactory(){}


    public static FeedbackFactory getFf_instance() {
        if(ff_instance==null)
            ff_instance=new FeedbackFactory();
        return ff_instance;
    }

    public Feedback make_feedb(Client client, Product product, String message, boolean type){
        Feedback feedback=new Feedback(id,client,product,message,type);
        id++;
        return feedback;
    }
}
