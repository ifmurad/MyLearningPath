import java.util.Scanner;

public class GroceryListRunner {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GroceryList groceryList = new GroceryList();
    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            boolean flag = true;
            while (flag) {
                if(scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    flag = false;
                } else {
                    System.out.print("You have to enter an integer between 0 and 6. ");
                    System.out.println("Enter your choice: ");
                }
                if(choice >= 7) {
                    System.out.print("You have to enter an integer between 0 and 6. ");
                }
                scanner.nextLine();
            }

            switch (choice) {
                case 0 -> printInstructions();
                case 1 -> groceryList.printGroceryList();
                case 2 -> addItem();
                case 3 -> modifyItem();
                case 4 -> removeItem();
                case 5 -> searchForItem();
                case 6 -> quit = true;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addItem() {
        System.out.println("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine().toLowerCase());
    }

    public static void modifyItem() {
        int itemNo = readValidItemNo();
        System.out.println("Enter replacement item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo-1, newItem);
    }

    public static void removeItem() {
        int itemNo = readValidItemNo();
        groceryList.removeGroceryItem(itemNo-1);
    }

    public static void searchForItem() {
        System.out.println("Item to search for: ");
        String searchItem = scanner.nextLine().toLowerCase();
        if(groceryList.findItem(searchItem) != null) {
            System.out.println("Found " + searchItem + " in our grocery list");
        } else {
            System.out.println(searchItem + " is not is the shopping list");
        }
    }

    public static int readValidItemNo() {
        boolean flag = true;
        int itemNo = 0;
        while(flag) {
            System.out.println("Enter item number: ");
            if(scanner.hasNextInt()) {
                itemNo = scanner.nextInt();
                if(itemNo <= groceryList.numberOfItems() && itemNo > 0) {
                    flag = false;
                } else {
                    System.out.print("Invalid item number. ");
                }
            } else {
                System.out.print("Invalid item number. ");
            }
            scanner.nextLine();
        }
        return itemNo;
    }
}
