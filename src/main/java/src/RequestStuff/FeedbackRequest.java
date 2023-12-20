package src.RequestStuff;

import src.Domains.Client;
import src.Domains.Product;

public class FeedbackRequest {
    private int id;
    private Client client;
    private Product product;
    private String message;
    private boolean type;

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Product getProduct() {
        return product;
    }

    public String getMessage() {
        return message;
    }

    public boolean isType() {
        return type;
    }
}
