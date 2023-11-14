package Domains;
import java.util.List;
import java.util.ArrayList;

public class Feedback {
    private static List<Product> productsWithFeedbacks = new ArrayList<>();

    private Client client;
    private Product product;
    private String message;
    private boolean type; // true pentru pozitiv, false pentru negativ

    public Feedback(Client client, Product product, String message, boolean type) {
        this.client = client;
        this.product = product;
        this.message = message;
        this.type = type;

        // Adaugăm produsul în lista globală, doar dacă nu există deja
        if (!productsWithFeedbacks.contains(product)) {
            productsWithFeedbacks.add(product);
        }
    }

    //toate produsele cu feedback-uri
    public static List<Product> getProductsWithFeedbacks() {
        return productsWithFeedbacks;
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

    public boolean getType() {
        return type;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public void displayFeedback() {
        System.out.println("Client: " + client.getName());
        System.out.println("Product: " + product.getName());
        System.out.println("Message: " + message);
        System.out.println("Type: " + (type ? "Positive" : "Negative"));
    }
}

    /* sa avem o lista declarata initial cu 2 feedbackuri pozitive si unul negativ
    iar dupa ce rulam programul putem direct sa bagam in lista alte feedbackuri care
    sa poate fi vazute dupa aceea cu un display
     */
