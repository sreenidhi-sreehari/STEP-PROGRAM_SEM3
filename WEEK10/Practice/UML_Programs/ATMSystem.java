class BankAccount {
    private String accountNumber;
    private double balance;
    private int pin;

    public BankAccount(String accountNumber, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public boolean validatePin(int enteredPin) {
        return enteredPin == pin;
    }

    public void debit(double amount) {
        balance -= amount;
        System.out.println("₹" + amount + " withdrawn. Remaining balance: ₹" + balance);
    }
}

class ATM {
    private BankAccount linkedAccount;

    public ATM(BankAccount linkedAccount) {
        this.linkedAccount = linkedAccount;
    }

    public void withdraw(int enteredPin, double amount) {
        if (linkedAccount.validatePin(enteredPin)) {
            linkedAccount.debit(amount);
            System.out.println("Dispensing cash...");
            System.out.println("Transaction successful. Please take your cash and receipt.");
        } else {
            System.out.println("Invalid PIN. Transaction failed.");
        }
    }
}

class ATMCustomer {
    private String name;
    private ATM atm;

    public ATMCustomer(String name, ATM atm) {
        this.name = name;
        this.atm = atm;
    }

    public void performWithdrawal(int pin, double amount) {
        System.out.println(name + " is requesting withdrawal...");
        atm.withdraw(pin, amount);
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        BankAccount acct = new BankAccount("1234567890", 100000.0, 4321);
        ATM atm = new ATM(acct);
        ATMCustomer c = new ATMCustomer("Meera", atm);
        c.performWithdrawal(4321, 5000);
        c.performWithdrawal(1111, 2000);
    }
}
