package FactoryPattern;

import Controll.ProductController;
import Domains.Product;
import Domains.ProductType;
import Reposies.ProductRepo;

public class ProductFactory {
    static ProductFactory pf_instance;
    private int id=300000;

    private ProductFactory() {}

    public static ProductFactory getInstance(){
        if(pf_instance==null)
            pf_instance=new ProductFactory();
        return pf_instance;
    }

    public Product make_prod(String name, float price, ProductType type, int stoc){
        Product prod= new Product(id, name, price, type, stoc);
        id++;
        return prod;
    }
}
