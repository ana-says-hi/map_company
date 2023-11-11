package Controll;

import Domains.Product;
import Domains.ProductType;
import ObserverPattern.Observable;
import ObserverPattern.Observer;
import Reposies.ProductRepo;

import java.util.ArrayList;

public class ProductController implements Controller<Product>{
    //singleton pe aici
    private static ProductController p_instance;
    private ProductRepo productRepo;

    private ProductController() {
        productRepo = new ProductRepo();
    }

    public static ProductController getInstance(){
        if(p_instance==null)
            p_instance=new ProductController();
        return p_instance;
    }

    public ArrayList<Product> getStuff()
    {
        return getProductRepo().getP_repo();
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
        for(Product prod: productRepo.getP_repo())
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
