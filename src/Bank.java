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
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String  customerName, double initialTransaction) {
        if(findBranch(branchName) != null) {
            return findBranch(branchName).newCustomer(customerName, initialTransaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        if(findBranch(branchName) != null) {
            return findBranch(branchName).addCustomerTransaction(customerName, transaction);
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        if(findBranch(branchName) != null) {
            System.out.println("Customer details for branch " + branchName);
            for(int i = 0; i < findBranch(branchName).getCustomers().size(); i++) {
                System.out.println("Customer: " + findBranch(branchName).getCustomers().get(i).getName() +
                        "[" + (i+1) + "]");
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
        return false;
    }
}
