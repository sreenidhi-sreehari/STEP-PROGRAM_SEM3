public class PersonalAccount {
    // Private attributes
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    // Static variables
    private static int totalAccounts = 0;
    private static String bankName;

    // Constructor
    public PersonalAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = 0.0;
        this.totalIncome = 0.0;
        this.totalExpenses = 0.0;
        totalAccounts++;
    }

    // Static methods
    public static void setBankName(String name) {
        bankName = name;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    private static String generateAccountNumber() {
        return "ACCT" + (totalAccounts + 1);
    }

    // Instance methods
    public void addIncome(double amount, String description) {
        if(amount > 0) {
            totalIncome += amount;
            currentBalance += amount;
            System.out.println("Income added: " + amount + " - " + description);
        }
    }

    public void addExpense(double amount, String description) {
        if(amount > 0 && amount <= currentBalance) {
            totalExpenses += amount;
            currentBalance -= amount;
            System.out.println("Expense added: " + amount + " - " + description);
        } else if(amount > currentBalance) {
            System.out.println("Insufficient balance for expense: " + description);
        }
    }

    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }

    public void displayAccountSummary() {
        System.out.println("Account Summary for " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Bank Name: " + bankName);
        System.out.println("Current Balance: " + currentBalance);
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Savings: " + calculateSavings());
        System.out.println();
    }

    // Main method to create accounts and demonstrate functionality
    public static void main(String[] args) {
        setBankName("ABC Bank");

        PersonalAccount acc1 = new PersonalAccount("John Doe");
        PersonalAccount acc2 = new PersonalAccount("Jane Smith");
        PersonalAccount acc3 = new PersonalAccount("Alice Johnson");

        acc1.addIncome(1000, "Salary");
        acc1.addExpense(200, "Groceries");

        acc2.addIncome(2000, "Freelance Work");
        acc2.addExpense(500, "Rent");
        acc2.addExpense(100, "Utilities");

        acc3.addIncome(1500, "Project Bonus");
        acc3.addExpense(300, "Car Repair");

        acc1.displayAccountSummary();
        acc2.displayAccountSummary();
        acc3.displayAccountSummary();

        System.out.println("Total accounts created: " + getTotalAccounts());
        System.out.println("All accounts share the bank name: " + bankName);
    }
}
