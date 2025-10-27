class BankAccount {
    // Private instance variables
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    // Static variables
    private static int totalAccounts = 0;
    private static int accountCounter = 1;

    // Constructor
    public BankAccount(String accountHolderName, double initialDeposit) {
        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Initial deposit cannot be negative.");
        }
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    // Static method to generate unique account number
    public static String generateAccountNumber() {
        String accNum = String.format("ACC%03d", accountCounter);
        accountCounter++;
        return accNum;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited: ₹" + amount);
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawn: ₹" + amount);
    }

    // Check balance
    public double checkBalance() {
        return balance;
    }

    // Display account info
    public void displayAccountInfo() {
        System.out.println("========== Account Details ==========");
        System.out.println("Account Number     : " + accountNumber);
        System.out.println("Account Holder     : " + accountHolderName);
        System.out.println("Balance            : ₹" + balance);
        System.out.println("=====================================");
    }

    // Static method to get total accounts
    public static int getTotalAccounts() {
        return totalAccounts;
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        // Array of BankAccount objects (without collection classes)
        BankAccount[] accounts = new BankAccount[3]; // Allocate array of size 3

        // Creating accounts and storing in array
        accounts[0] = new BankAccount("Amit Sharma", 5000);
        accounts[1] = new BankAccount("Neha Singh", 10000);
        accounts[2] = new BankAccount("Ravi Verma", 7500);

        // Performing transactions on each account individually
        accounts[0].deposit(2000);
        accounts[0].withdraw(500);

        accounts[1].withdraw(8000); // Should succeed since balance is 10000
        accounts[1].withdraw(3000); // Should fail, insufficient funds after previous withdrawal

        accounts[2].deposit(1500);

        // Display account information
        for (int i = 0; i < accounts.length; i++) {
            accounts[i].displayAccountInfo();
        }

        // Show difference between static and instance variables
        System.out.println("Total Bank Accounts Created: " + BankAccount.getTotalAccounts());
        // Instance variables are specific to each object, static variables are shared across the class
    }
}
