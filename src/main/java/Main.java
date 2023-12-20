//import Tests.ContractCourierTest;
import Tests.*;
import src.Controll.ProductController;
import src.Domains.ProductType;
//import Tests.TinyTest;
//import UI.UI;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Main {
    public static void main(String[] args) {
        runTests();
        ProductController pc=new ProductController();
        //pc.create("Balsam", 12.3F, ProductType.hair,78);
//        UI ui = new UI();
//        ui.mainMenu();
        System.out.println("merge");
    }
//ala bun
    private static void runTests() {
        TinyTest tinyTest = new TinyTest();
        tinyTest.test_delivery();
        tinyTest.test_repo_conn();
//        ProductsControllerTests pct = new ProductsControllerTests();
//        pct.testAddProduct();
//        ContractEmployeeTest contractEmployeeTest = new ContractEmployeeTest();
//        contractEmployeeTest.test_calculateSeniority();
//        contractEmployeeTest.test_updateSeniority();
    }
}