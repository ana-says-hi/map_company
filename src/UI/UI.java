package UI;

import java.util.Scanner;

public class UI {
    private static final String ANA_PASSWORD = "Ania1234";
    private static final String STEF_PASSWORD = "Stef2205";
    private static final String BOGDAN_PASSWORD = "hokedo"; // Parola pentru Bogdan

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
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
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void displayProductCategoryMenu(Scanner scanner) {
        System.out.println("Select a Category:");
        System.out.println("1. Hair");
        System.out.println("2. Body");
        System.out.println("3. Face");

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
            default:
                System.out.println("Invalid option.");
        }
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
        // Implementează logica pentru afișarea feedback-urilor
        System.out.println("Viewing feedbacks...");
    }

    private static void placeOrder(Scanner scanner) {
        // Implementează logica pentru plasarea unei comenzi
        System.out.println("Placing an order...");
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
        System.out.println("1. Modify Product");
        System.out.println("2. Delete Product");

        int productsChoice = scanner.nextInt();
        scanner.nextLine();

        switch (productsChoice) {
            case 1:
                modifyProduct();
                break;
            case 2:
                deleteProduct();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void modifyProduct() {
        // Implementează logica pentru modificarea unui produs
        System.out.println("Modifying product...");
    }

    private static void deleteProduct() {
        // Implementează logica pentru ștergerea unui produs
        System.out.println("Deleting product...");
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