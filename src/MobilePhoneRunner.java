import java.util.Scanner;

public class MobilePhoneRunner {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MobilePhone mobilePhone = new MobilePhone();
    public static void main(String[] args) {
        startPhone();
        int actionPosition = 0;
        boolean quit = false;
        while (!quit) {
            boolean flag = true;
            while (flag) {
                System.out.println("Choose an action to perform by typing an integer between 0 and 6: \n");
                if(scanner.hasNextInt()) {
                    actionPosition = scanner.nextInt();
                    if(actionPosition >= 0 && actionPosition <= 6) {
                        flag = false;
                    }
                }
                scanner.nextLine();
            }
            switch (actionPosition) {
                case 0 -> printActions();
                case 1 -> printContacts();
                case 2 -> addNewContact();
                case 3 -> updateContact();
                case 4 -> removeContact();
                case 5 -> queryContact();
                case 6 -> quit = true;
            }
        }
    }

    private static void startPhone() {
        System.out.println("Phone is starting...\n");
        printActions();
    }

    private static void printActions() {
        System.out.println("""
                Actions to perform:
                
                0  - show available actions
                1  - show all existing contacts
                2  - add new contact
                3  - update existing with the new one
                4  - delete existing contact
                5  - find phone number of existing contact
                6  - close the phone
                
                """);
    }

    private static void printContacts() {
        mobilePhone.printContacts();
    }

    private static void addNewContact() {
        System.out.println("Enter name of the contact:\n");
        String name = scanner.nextLine();
        System.out.println("Enter phone number of the contact:\n");
        String phoneNumber = scanner.nextLine();
        Contact newContact = new Contact(name, phoneNumber);
        mobilePhone.addNewContact(newContact);
    }

    private static void updateContact() {
        System.out.println("Enter contact name you want to replace:\n");
        String oldName = scanner.nextLine();
        System.out.println("Enter new contact name:\n");
        String newName = scanner.nextLine();
        System.out.println("Enter new phone number:\n");
        String newPhoneNumber = scanner.nextLine();
        Contact newContact = new Contact(newName, newPhoneNumber);
        mobilePhone.updateContact(mobilePhone.queryContact(oldName), newContact);
    }

    private static void removeContact() {
        System.out.println("Enter contact name you want to delete:\n");
        String name = scanner.nextLine();
        mobilePhone.removeContact(mobilePhone.queryContact(name));
    }

    private static void queryContact() {
        System.out.println("Enter contact name:\n");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.queryContact(name);
        System.out.println("Phone number of " + name + " is " + contact.getPhoneNumber());
    }

}
