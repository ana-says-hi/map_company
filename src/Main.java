import Tests.TinyTest;
import UI.UI;

public class Main {
    public static void main(String[] args) {
        TinyTest t= new TinyTest();
        t.test_delivery();
        UI ui= new UI();
        ui.mainMenu();
    }
}