import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        if(findBranch(branchName) == null) {
            Branch newBranch = new Branch(branchName);
            branches.add(newBranch);
            System.out.println(branchName + " is successfully added.");
            return true;
        }
        System.out.println(branchName + " is already in the list of branches.");
        return false;
    }

    public boolean addCustomer(String branchName, String  customerName, double initialTransaction) {
        if(findBranch(branchName) != null) {
            if(findBranch(branchName).findCustomer(customerName) == null) {
                findBranch(branchName).newCustomer(customerName,initialTransaction);
                System.out.println(customerName + " is added to the list of customers.");
                return true;
            }
            System.out.println(customerName + " is already in the list of customers of " + branchName);
            return false;
        }
        System.out.println(branchName + " does not exist.");
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        if(findBranch(branchName) != null) {
            if(findBranch(branchName).findCustomer(customerName) != null) {
                findBranch(branchName).addCustomerTransaction(customerName, transaction);
                System.out.println("Transaction is added.");
                return true;
            }
            System.out.println(customerName + " is not found.");
            return false;
        }
        System.out.println(branchName + " does not exist.");
        return false;
    }

    public Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                System.out.println(branchName + " is in the list of branches.");
                return branch;
            }
        }
        System.out.println(branchName + " does not exist.");
        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        if(findBranch(branchName) != null) {
            System.out.println("Customer details for branch " + branchName);
            for(int i = 0; i < findBranch(branchName).getCustomers().size(); i++) {
                System.out.println("Customer: " + findBranch(branchName).getCustomers().get(i).getName());
                if(printTransactions) {
                    System.out.println("Transactions");
                    for(int j = 0; j < findBranch(branchName).getCustomers().get(i).getTransactions().size(); j++) {
                        System.out.println("[" + (j+1) + "]  Amount "
                                + findBranch(branchName).getCustomers().get(i).getTransactions().get(j));
                    }
                }
            }
            return true;
        }
        System.out.println(branchName + " does not exist.");
        return false;
    }
}
