package the_spring_src.RequestStuff;

import the_spring_src.Domains.ProductType;

public class ProductRequest {
    private String name;
    private Float price;
    private ProductType type;
    private Integer stoc;

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public ProductType getType() {
        return type;
    }

    public Integer getStoc() {
        return stoc;
    }
}
