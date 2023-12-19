import Domains.ContractCourier;
import Domains.ContractEmployee;
//import Tests.ContractCourierTest;
import Tests.*;
//import Tests.TinyTest;
//import UI.UI;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Main {
    public static void main(String[] args) {
        runTests();
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