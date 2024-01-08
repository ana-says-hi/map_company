package the_spring_src.Domains;

public class ProdInOrderEntity {
    //private int id;
    private int order;    //here we buy
    private Product product;


    public void setOrder(int order) {
        this.order = order;
    }

    public ProdInOrderEntity(int here_we_buy, Product product) {
        this.order=here_we_buy;
        this.product=product;
    }

    public int getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    // Getters and setters
}
