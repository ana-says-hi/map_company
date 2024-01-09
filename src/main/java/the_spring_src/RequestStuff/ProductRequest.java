package the_spring_src.RequestStuff;

import the_spring_src.Domains.ProductType;

public class ProductRequest {
    private String name;
    private Float price;
//    private ProductType type;
    private String type;
    private Integer stoc;

    public String getName() {
        return this.name;
    }

    public Float getPrice() {
        return price;
    }

    public ProductType getType() {
        return ProductType.valueOf(type);
    }

    public Integer getStoc() {
        return stoc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStoc(Integer stoc) {
        this.stoc = stoc;
    }
}

