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

    private ProductRepo productRepo;
    @Autowired
    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping
    public ArrayList<Product> getStuff() throws SQLException {
        return getProductRepo().get_repo();
        //return productRepo.get_from_db();
    }

    //TODO schimmbat sa se fooseasca asta, nu getStuff
    @GetMapping
    public ProductRepo getProductRepo() {
        return productRepo;
    }

    @PostMapping
    public void create(@RequestBody String name,@RequestBody float price,@RequestBody ProductType type,@RequestBody int stoc){
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

    @GetMapping("/{id}/product")
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


    public ArrayList<Product> filterProductsByType(ProductType type) throws SQLException {
        ArrayList<Product> filteredProducts = new ArrayList<>();
        ArrayList<Product> products = getStuff();
        for (Product product : products) {
            if (product.getType() == type) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

}
