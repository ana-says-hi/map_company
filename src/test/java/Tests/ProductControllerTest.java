package Tests;

import org.junit.jupiter.api.Test;
import the_spring_src.Domains.Product;
import the_spring_src.Domains.ProductType;
import the_spring_src.Reposies.ProductRepo;
import the_spring_src.RequestStuff.ProductRequest;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class ProductControllerTest {


    private ProductRepo productRepo;

    @Test
    public void testCreate() {
        ProductRequest request = new ProductRequest();
        request.setName("TestProduct");
        request.setPrice(19.99f);
        request.setType("body");
        request.setStoc(10);

        Product createdProduct = new Product(
                request.getName(),
                request.getPrice(),
                ProductType.valueOf(String.valueOf(request.getType())),
                request.getStoc()
        );

        productRepo.save(createdProduct);
        List<Product> productList = productRepo.findAll();
        boolean productFound = productList.contains(createdProduct);
        assertTrue(productFound, "Produsul neadaugat. :(");
    }
    public void testDelete() {
        ProductRequest request = new ProductRequest();
        request.setName("TestProduct");
        request.setPrice(19.99f);
        request.setType("body");
        request.setStoc(10);

        Product createdProduct = new Product(
                request.getName(),
                request.getPrice(),
                ProductType.valueOf(String.valueOf(request.getType())),
                request.getStoc()
        );


        List<Product> productListBeforeDelete = productRepo.findAll();
        int productId = createdProduct.getId();
        productRepo.delete(createdProduct);
        List<Product> productListAfterDelete = productRepo.findAll();
        assertFalse(productListAfterDelete.contains(createdProduct));
    }
}
