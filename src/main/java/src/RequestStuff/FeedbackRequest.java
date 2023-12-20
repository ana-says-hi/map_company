package src.RequestStuff;

public class FeedbackRequest {
    int clientID;
    int productID;
    String message;
    boolean type;

    public int getClientID() {
        return clientID;
    }

    public int getProductID() {
        return productID;
    }

    public String getMessage() {
        return message;
    }

    public boolean isType() {
        return type;
    }
}
