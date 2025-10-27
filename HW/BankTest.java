abstract class BankAccount {
    double balance;
    BankAccount(double balance) {
        this.balance = balance;
    }
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
    abstract void calculateInterest();
}

class SavingsAccount extends BankAccount {
    SavingsAccount(double balance) {
        super(balance);
    }
    void calculateInterest() {
        double interest = balance * 0.05;
        System.out.println("Savings Interest: " + interest);
    }
}

class CurrentAccount extends BankAccount {
    CurrentAccount(double balance) {
        super(balance);
    }
    void calculateInterest() {
        double interest = balance * 0.02;
        System.out.println("Current Account Interest: " + interest);
    }
}

public class BankTest {
    public static void main(String[] args) {
        SavingsAccount s = new SavingsAccount(10000);
        s.deposit(2000);
        s.calculateInterest();

        CurrentAccount c = new CurrentAccount(15000);
        c.deposit(3000);
        c.calculateInterest();
    }
}
