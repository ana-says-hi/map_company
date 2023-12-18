package Controll;

import Domains.Product;
import Domains.ProductType;
import Reposies.ProductRepo;
import FactoryPattern.ProductFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.ArrayList;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@Getter
@Setter
@NoArgsConstructor
public class ProductController implements Controller<Product>{
    //private static ProductController p_instance;
    @Autowired
    private ProductRepo productRepo;

//    private ProductController(){
//        try {
//            productRepo = new ProductRepo();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public static ProductController getInstance() {
//        if(p_instance==null) {
//            p_instance = new ProductController();
//        }
//        return p_instance;
//    }
    @GetMapping
    public ArrayList<Product> getStuff()
    {
        return getProductRepo().get_repo();
    }

    @PostMapping
    public void create(String name, float price, ProductType type, int stoc){
        Product p =  ProductFactory.getInstance().make_prod(name, price, type, stoc);
        productRepo.add_to_repo(p);
    }

    @PutMapping
    public void update(int id, String name, float price, ProductType type, int stoc) {
        delete(id);
        //create(name,price,type,stoc);
        Product p = new Product(id, name, price, type, stoc);
        productRepo.add_to_repo(p);
    }

    @GetMapping
    public Product find_by_id(int id) {
        for(Product prod: productRepo.get_repo())
            if(prod.getId()==id)
                return prod;
        return null;
    }

    @Override
    @DeleteMapping("/{id}/product")
    public void delete(int id) {
        Product prod= find_by_id(id);
        productRepo.remove_from_repo(prod);
    }

    @GetMapping
    public ArrayList<Product> filterProductsByType(ProductType type) {
        ArrayList<Product> filteredProducts = new ArrayList<>();
        ArrayList<Product> products = getStuff();
        for (Product product : products) {
            if (product.getType() == type) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    @GetMapping
    public ProductRepo getProductRepo() {
        return productRepo;
    }

}
