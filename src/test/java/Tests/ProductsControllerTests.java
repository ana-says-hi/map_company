package Tests;

import Controll.ProductController;
import Domains.Product;
import Domains.ProductType;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.testng.AssertJUnit;

//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertNull;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class ProductsControllerTests {

    @Test
    public void testAddProduct() {
        //ProductController productController = ProductController.getInstance();
        ProductController pc=new ProductController();
        int initialSize = pc.getStuff().size();
        pc.create("TestProduct", 10.5f, ProductType.hair, 5);
        assertEquals(initialSize + 1, pc.getStuff().size());
        Product lastProduct = pc.getStuff().get(pc.getStuff().size() - 1);
        assertEquals("TestProduct", lastProduct.getName());
        assertEquals(10.5f, lastProduct.getPrice(), 0.01);
        assertEquals(ProductType.hair, lastProduct.getType());
    }

    @Test
    void testUpdateProduct() {
        //ProductController productController = ProductController.getInstance();
        ProductController productController=new ProductController();
        productController.create("TestProduct", 10.5f, ProductType.hair, 5);
        Product lastProduct = productController.getStuff().get(productController.getStuff().size() - 1);
        productController.update(lastProduct.getId(), "UpdatedProduct", 15.0f, ProductType.hair, 10);
        Product updatedProduct = productController.find_by_id(lastProduct.getId());
        assertEquals("UpdatedProduct", updatedProduct.getName());
        assertEquals(15.0f, updatedProduct.getPrice(), 0.01);
        assertEquals(ProductType.hair, updatedProduct.getType());
    }

    @Test
    void testDeleteProduct() {
        ProductController productController=new ProductController();
        productController.create("TestProduct", 10.5f, ProductType.hair, 5);
        Product lastProduct = productController.getStuff().get(productController.getStuff().size() - 1);
        productController.delete(lastProduct.getId());
        Product deletedProduct = productController.find_by_id(lastProduct.getId());
        AssertJUnit.assertNull(deletedProduct);
    }
}