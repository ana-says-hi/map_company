package Domains;

public class Product {
    private int id;
    private String name;
    private float price;
    private ProductType type;
    private int stoc;

    public Product(int id, String name, float price, ProductType type, int stoc) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.stoc = stoc;
    }
    @Override
    public String toString() {
        return id + ',' + name + ',' + price + ',' + type + ',' + stoc;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }
}
