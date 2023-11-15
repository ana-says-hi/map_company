package UI;

import Controll.ClientController;
import Controll.FeedbackController;
import Controll.OrderController;
import Controll.ProductController;
import Domains.*;
import FactoryPattern.OrderFactory;
import FactoryPattern.ProductFactory;

import java.util.Scanner;

public class UI {
    private static final String ANA_PASSWORD = "Ania1234";
    private static final String STEF_PASSWORD = "Stef2205";
    private static final String BOGDAN_PASSWORD = "hokedo"; // Parola pentru Bogdan

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println("Welcome to BioLite!");
        System.out.println("Please select your identity:");

        System.out.println("1. Customer");
        System.out.println("2. Manager");

        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();

        if (option == 1) {
            displayCustomerOptionsMenu(scanner);
        } else if (option == 2) {
            managerLogin(scanner);
        } else {
            System.out.println("Invalid option.");
        }

        scanner.close();
    }

    private static void displayCustomerOptionsMenu(Scanner scanner) {
        System.out.println("Customer Menu:");
        System.out.println("1. View Products");
        System.out.println("2. View Feedbacks");
        System.out.println("3. Place Order");
        System.out.println("4. Find out more about us");

        int customerChoice = scanner.nextInt();
        scanner.nextLine();

        switch (customerChoice) {
            case 1:
                displayProductCategoryMenu(scanner);
                break;
            case 2:
                viewFeedbacks();
                break;
            case 3:
                placeOrder(scanner);
                break;
            case 4:
                findOutMore(scanner);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void findOutMore(Scanner scanner) {


    }

    private static void displayProductCategoryMenu(Scanner scanner) {
        System.out.println("Select a Category:");
        System.out.println("1. Hair");
        System.out.println("2. Body");
        System.out.println("3. Face");
        System.out.println("4. ALL");

        int categoryChoice = scanner.nextInt();
        scanner.nextLine();

        switch (categoryChoice) {
            case 1:
                displayHairProducts();
                break;
            case 2:
                displayBodyProducts();
                break;
            case 3:
                displayFaceProducts();
                break;
            case 4:
                displayAllProducts();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void displayAllProducts(){
        System.out.println("All products:");
        for(Product product: ProductController.getInstance().getProductRepo().getP_repo())
            System.out.println(product);
    }

    private static void displayHairProducts() {
        System.out.println("Hair Products:");
        // Implementează logica pentru afișarea produselor de tip Hair
    }

    private static void displayBodyProducts() {
        System.out.println("Body Products:");
        // Implementează logica pentru afișarea produselor de tip Body
    }

    private static void displayFaceProducts() {
        System.out.println("Face Products:");
        // Implementează logica pentru afișarea produselor de tip Face
    }

    private static void viewFeedbacks() {

        System.out.println("Viewing feedbacks:");
        for(Feedback feedback: FeedbackController.getInstance().getFeedbackRepo().getF_repo())
            System.out.println(feedback);
    }

    private static void placeOrder(Scanner scanner) {
        // Implementează logica pentru plasarea unei comenzi
        System.out.println("Placing an order...");
        System.out.println("Can you help us? What is your name?\t");
        Scanner scannerN = new Scanner(System.in);
        String new_name = scannerN.nextLine();
        System.out.println("What is your address?\t");
        Scanner scannerA = new Scanner(System.in);
        String new_addr = scannerN.nextLine();
            Client cl=ClientController.getInstance().create(new_name,new_addr);
            Order order=OrderController.getInstance().create(cl);
        System.out.println("Adding products...");
        System.out.println("What would you like to buy? Enter IDs:\t");
            //citit mai multe id
        Scanner scannerIDS = new Scanner(System.in);
        String input = scannerIDS.nextLine();
        String[] valoriString = input.split(" ");
        for (String valoare : valoriString) {
            int valoareInt = Integer.parseInt(valoare);
            //addProduct si in order Controller?
            order.addProduct(ProductController.getInstance().find(valoareInt));
        }
        scannerIDS.close();
        System.out.println("The products have been added! With our basic delivery, your costs will be: "+order.getTotalPrice());
        System.out.println("Would you like to change the delivery type? [0-no, 1-yes]");
        Scanner scannerYN = new Scanner(System.in);
        int answer = scannerYN.nextInt();
        if(answer==0)
            order.finishOrder();
        if (answer==1)
        {
            //switch pt tipul de livrari
            //order.setDelivery();
        }

    }


    private static void managerLogin(Scanner scanner) {
        System.out.println("Welcome to the Manager section, please choose your identity:");
        System.out.println("1. Ana");
        System.out.println("2. Stef");
        System.out.println("3. Bogdan");

        int managerOption = scanner.nextInt();
        scanner.nextLine();

        switch (managerOption) {
            case 1:
                managerLoginWithPassword(scanner, "Ana", ANA_PASSWORD);
                break;
            case 2:
                managerLoginWithPassword(scanner, "Stef", STEF_PASSWORD);
                break;
            case 3:
                managerLoginWithPassword(scanner, "Bogdan", BOGDAN_PASSWORD);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void managerLoginWithPassword(Scanner scanner, String managerName, String correctPassword) {
        System.out.println("Welcome " + managerName + ", please enter your password:");
        String enteredPassword = scanner.next();

        if (validatePassword(enteredPassword, correctPassword)) {
            displayManagerSubMenu(scanner);
        } else {
            System.out.println("Incorrect password. Access denied.");
        }
    }

    private static void displayManagerSubMenu(Scanner scanner) {
        System.out.println("Manager Menu:");
        System.out.println("1. Orders");
        System.out.println("2. Products");

        int managerChoice = scanner.nextInt();
        scanner.nextLine();

        switch (managerChoice) {
            case 1:
                displayOrdersSubMenu(scanner);
                break;
            case 2:
                displayProductsSubMenu(scanner);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void displayOrdersSubMenu(Scanner scanner) {
        System.out.println("Orders Submenu:");
        System.out.println("1. Previous Orders");
        System.out.println("2. Current Orders");
        System.out.println("3. Canceled Orders");
        System.out.println("4. Returns");

        int ordersChoice = scanner.nextInt();
        scanner.nextLine();

        switch (ordersChoice) {
            case 1:
                displayPreviousOrders();
                break;
            case 2:
                displayCurrentOrders();
                break;
            case 3:
                displayCanceledOrders();
                break;
            case 4:
                displayReturns();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void displayPreviousOrders() {
        // Implementează logica pentru afișarea comenzilor anterioare
        System.out.println("Displaying previous orders...");
    }

    private static void displayCurrentOrders() {
        // Implementează logica pentru afișarea comenzilor curente
        System.out.println("Displaying current orders...");
    }

    private static void displayCanceledOrders() {
        // Implementează logica pentru afișarea comenzilor anulate
        System.out.println("Displaying canceled orders...");
    }

    private static void displayReturns() {
        // Implementează logica pentru afișarea returnărilor
        System.out.println("Displaying returns...");
    }

    private static void displayProductsSubMenu(Scanner scanner) {
        System.out.println("Products Submenu:");
        System.out.println("1. Add Product");
        System.out.println("2. Modify Product");
        System.out.println("3. Delete Product");
        int productsChoice = scanner.nextInt();
        scanner.nextLine();

        switch (productsChoice) {
            case 2:
                modifyProduct();
                break;
            case 3:
                deleteProduct();
                break;
            case 1:
                addProduct();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void addProduct(){
        System.out.println("Adding product...\nEnter an id:\t");
        System.out.println("new name:\t");
        Scanner scannerN = new Scanner(System.in);
        String new_name = scannerN.nextLine();
        System.out.println("new price:\t");
        Scanner scannerP = new Scanner(System.in);
        float new_price = scannerP.nextFloat();
        System.out.println("new type:\t");
        Scanner scannerT = new Scanner(System.in);
        String new_type = scannerT.nextLine();
        ProductController.getInstance().create(new_name,new_price, ProductType.valueOf(new_type),100);
    }

    private static void modifyProduct() {
        // Implementează logica pentru modificarea unui produs
        System.out.println("Modifying product...\nEnter an id:\t");
        Scanner scannerID = new Scanner(System.in);
        int id = scannerID.nextInt();
        Product prod=ProductController.getInstance().find(id);
        System.out.println("new price:\t");
        Scanner scanner = new Scanner(System.in);
        float new_price = scanner.nextFloat();
        ProductController.getInstance().update(prod.getId(), prod.getName(), new_price,prod.getType(),prod.getStoc());
    }

    private static void deleteProduct() {
        // Implementează logica pentru ștergerea unui produs
        System.out.println("Deleting product...\nEnter an id:\t");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        ProductController.getInstance().delete(id);
    }

    private static boolean validatePassword(String enteredPassword, String correctPassword) {
        return enteredPassword.equals(correctPassword);
    }
}


/*
o sa avem pentru client sectiunea de ales produse care tin de order, unde
o sa avem zona de ales produse deja existents, iar acestea odata alese o sa
se deschida un alt submeniu pentru livrare
 o sa avem nevoie sa bagam pentru delivery un meniu cu intrebare
 Doriti o livrare preferentiala? 1.da/2.nu
 1 - merge in mod automat la normal
 2 - merge la meniul asta:
      1.fragil
      2.same day
      3.ultra safe
Odata terminat procesul de ales produse+metode de livrare poti fie
    -sa vezi pretul
    -sa termini cumparaturile
  odata ce vezi pretul apara asta:
  Doresti sa plasezi comanda? 1.da/2.nu
  -da -> se trimite mai departe la controller ca e gata comanda
  -nu -> te lasa sa stergi produse sau sa mai adaugi ceva si putem folosi update de la comanda
  care include atat remove/delete cat si add products
 */

/*

 */