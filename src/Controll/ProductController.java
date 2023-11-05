package Controll;

import Domains.Product;
import Domains.ProductType;
import Reposies.ProductRepo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductController implements Controller{

    private ProductRepo productRepo;

    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    public void create(int id, String name, float price, ProductType type, int stoc){
        Product p = new Product(id, name, price, type, stoc);
        productRepo.add_to_repo(p);
    }

    public void update(int id, String name, float price, ProductType type, int stoc) {
        delete(id);
        create(id,name,price,type,stoc);
    }

    public Product find(int id) {
        for(Product prod: productRepo.getC_repo())
            if(prod.getId()==id)
                return prod;
        return null;
    }

    @Override
    public void delete(int id) {
        Product prod=find(id);
        productRepo.remove_from_repo(prod);
    }



//    public ProductController() throws IOException {
//        this.datei = "src/Files/Products.txt";
//        FileReader fileReader = new FileReader(datei);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            stuff=convertFromString(line);
//        }
//        bufferedReader.close();
//    }

//    public void create(int id, String name, float price, ProductType type, int stoc) throws IOException {
//        Product prod= new Product(id, name, price, type, stoc);
//        stuff.add(prod);
//        FileWriter fileWriter = new FileWriter(datei);
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        bufferedWriter.write(prod.toString());
//        bufferedWriter.close();
//    }


    public ProductRepo getProductRepo() {
        return productRepo;
    }
}
