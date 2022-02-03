public class BankAccount {
    private int accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount() {
        this(56789, 2.50, "Default name",
                "Default address", "default phone");
    }
    public BankAccount(int accountNumber, double balance,
                       String customerName, String email,
                       String phoneNumber) {
        System.out.println("BankAccount constructor with parameters is called");
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(double fundsToDeposit) {
        balance += fundsToDeposit;
        System.out.println("Deposit is successfully done. " +
                "Your balance: " + getBalance());
    }

    public void withdrawalFunds(double fundsToWithdraw) {
        if(fundsToWithdraw > getBalance()) {
            System.out.println("Withdrawal is not possible. " +
                    "Insufficient funds.");
        } else {
            balance -= fundsToWithdraw;
            System.out.println("Withdrawal is successfully done. " +
                    "Your balance: " + getBalance());
        }
    }
}
