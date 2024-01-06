package the_spring_src.Domains;

public class ProdInOrderEntity {
    //private int id;
    private Order order;    //here we buy
    private Product product;


    public void setOrder(Order order) {
        this.order = order;
    }

    public ProdInOrderEntity(Order here_we_buy, Product product) {
        this.order=here_we_buy;
        this.product=product;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    // Getters and setters
}
