package UI;

import java.util.Scanner;

public class UI {
    private static final String ANA_PASSWORD = "Ania1234";
    private static final String STEF_PASSWORD = "Stef2205";
    private static final String BOGDAN_PASSWORD = "hokedo"; // Parola pentru Bogdan

    public static void main_menu()
    {
        System.out.println("Welcome to BioLite!");
        System.out.println("Please select your identity:");

        System.out.println("1. Customer");
        System.out.println("2. Manager");

        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();

        if (option == 1)
        {
            displayCustomerMenu(scanner);
        }
        else if (option == 2)
        {
            managerLogin(scanner);
        }
        else
        {
            System.out.println("Invalid option.");
        }

        scanner.close();
    }

    private static void displayCustomerMenu(Scanner scanner)
    {
        System.out.println("Customer Menu:");
        System.out.println("1. Hair");
        System.out.println("2. Body");
        System.out.println("3. Face");

        int customerChoice = scanner.nextInt();
        scanner.nextLine();

        switch (customerChoice)
        {
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
/*
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


    private static void displayHairProducts()
    {
        System.out.println("Hair Products:");
        System.out.println("1. Shampoo");
        System.out.println("2. Conditioner");
        System.out.println("3. Hair Mask");
        System.out.println("4. Towel");
        System.out.println("5. Oil");
        System.out.println("6. LeaveIn");

    }

    private static void displayBodyProducts()
    {
        System.out.println("Body Products:");
        System.out.println("1. Shower Gel");
        System.out.println("2. Sponge");
        System.out.println("3. Body Spray");
        System.out.println("4. Body Cream");
    }

/*    private static void displayMenProducts()
    {
        System.out.println("Only Men can understand:");
        System.out.println("1. Shower Gel");
        System.out.println("2. Sponge");
        System.out.println("3. Spray for your car");
        System.out.println("4. Fairy");
    }*/

    private static void displayFaceProducts()
    {
        System.out.println("Face Products:");
        System.out.println("1. Makeup Remover");
        System.out.println("2. Face Wash Gel");
        System.out.println("3. Salicylic Acid");
    }

    private static void managerLogin(Scanner scanner)
    {
        System.out.println("Welcome to the Manager section, please choose your identity:");
        System.out.println("1. Ana");
        System.out.println("2. Stef");
        System.out.println("3. Bogdan");

        int managerOption = scanner.nextInt();
        scanner.nextLine();

        switch (managerOption)
        {
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

    private static void managerLoginWithPassword(Scanner scanner, String managerName, String correctPassword)
    {
        System.out.println("Welcome " + managerName + ", please enter your password:");
        String enteredPassword = scanner.next();

        if (validatePassword(enteredPassword, correctPassword))
        {
            displayManagerSubMenu(scanner);
        }
        else
        {
            System.out.println("Incorrect password. Access denied.");
        }
    }

    private static void displayManagerSubMenu(Scanner scanner)
    {
        System.out.println("Manager Menu:");
        System.out.println("1. Orders");
        System.out.println("2. Products");

        int managerChoice = scanner.nextInt();
        scanner.nextLine();

        switch (managerChoice)
        {
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

    private static void displayOrdersSubMenu(Scanner scanner)
    {
        System.out.println("Orders Submenu:");
        System.out.println("1. Previous Orders");
        System.out.println("2. Current Orders");
        System.out.println("3. Canceled Orders");
        System.out.println("4. Returns");
    }

    private static void displayProductsSubMenu(Scanner scanner)
    {
        System.out.println("Products Submenu:");
        System.out.println("1. Modify Product");
        System.out.println("2. Delete Product");
    }

    private static boolean validatePassword(String enteredPassword, String correctPassword)
    {
        return enteredPassword.equals(correctPassword);
    }
}
