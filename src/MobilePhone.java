import java.util.ArrayList;

public class MobilePhone {
    private final ArrayList<Contact> myContacts;

    public MobilePhone() {
        this.myContacts = new ArrayList<>();
    }

    public void addNewContact(Contact contact) {
        if(findContact(contact) < 0) {
            myContacts.add(contact);
            System.out.println(contact.getName() + " is successfully added to the list of contacts.");
            return;
        }
        System.out.println(contact.getName() + " is already in the list of contacts.");
    }

    public void updateContact(Contact oldContact, Contact newContact) {
        if(findContact(oldContact) < 0) {
            System.out.println(oldContact.getName() + " is not found in the list of contacts.");
            return;
        } else if(findContact(newContact) >= 0) {
            System.out.println(newContact.getName() + " is already in the list of contacts.");
            return;
        }
        myContacts.set(findContact(oldContact), newContact);
        System.out.println(oldContact.getName() + " is replaced with " + newContact.getName() + ".");
    }

    public void removeContact(Contact contact) {
        if(findContact(contact) < 0) {
            System.out.println(contact.getName() + " is not found in the list of contacts.");
            return;
        }
        myContacts.remove(contact);
        System.out.println(contact.getName() + " is successfully deleted from the list of contacts.");
    }

    private int findContact(Contact contact) {
        if(findContact(contact.getName()) >= 0) {
            return findContact(contact.getName());
        }
        return -1;
    }

    private int findContact(String name) {
        for(int i = 0; i < myContacts.size(); i++) {
            if(myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        if(findContact(name) < 0) {
            //System.out.println(name + " is not found is the list of contacts.");
            return null;
        }
        return myContacts.get(findContact(name));
    }

    public void printContacts() {
        System.out.println("Contact List: ");
        for(int i = 0; i < myContacts.size(); i++) {
            System.out.println((i + 1) + ". " +
                    myContacts.get(i).getName() + " -> " +
                    myContacts.get(i).getPhoneNumber());
        }
    }
}
