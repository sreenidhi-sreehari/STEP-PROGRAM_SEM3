public class SecureBankAccount {
    private final String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;

    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;

    public SecureBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = Math.max(initialBalance, MIN_BALANCE);
        this.pin = 0;
        this.isLocked = false;
        this.failedAttempts = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        if (isLocked) {
            System.out.println("Account is locked. Cannot access balance.");
            return -1;
        }
        return balance;
    }

    public boolean isAccountLocked() {
        return isLocked;
    }

    public boolean setPin(int oldPin, int newPin) {
        if (this.pin == oldPin) {
            this.pin = newPin;
            System.out.println("PIN updated successfully.");
            return true;
        }
        System.out.println("Incorrect old PIN.");
        return false;
    }

    public boolean validatePin(int enteredPin) {
        if (isLocked) return false;
        if (this.pin == enteredPin) {
            resetFailedAttempts();
            return true;
        } else {
            incrementFailedAttempts();
            return false;
        }
    }

    public void unlockAccount(int correctPin) {
        if (this.pin == correctPin) {
            isLocked = false;
            resetFailedAttempts();
            System.out.println("Account unlocked successfully.");
        } else {
            System.out.println("Incorrect PIN. Cannot unlock.");
        }
    }

    public void deposit(double amount, int pin) {
        if (validatePin(pin)) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: " + amount);
            }
        } else {
            System.out.println("Deposit failed. Invalid PIN.");
        }
    }

    public void withdraw(double amount, int pin) {
        if (validatePin(pin)) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew: " + amount);
            } else {
                System.out.println("Insufficient funds or invalid amount.");
            }
        } else {
            System.out.println("Withdrawal failed. Invalid PIN.");
        }
    }

    public void transfer(SecureBankAccount target, double amount, int pin) {
        if (validatePin(pin)) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                target.balance += amount;
                System.out.println("Transferred " + amount + " to account " + target.getAccountNumber());
            } else {
                System.out.println("Transfer failed. Insufficient funds or invalid amount.");
            }
        } else {
            System.out.println("Transfer failed. Invalid PIN.");
        }
    }

    private void lockAccount() {
        isLocked = true;
        System.out.println("Account locked due to too many failed attempts.");
    }

    private void resetFailedAttempts() {
        failedAttempts = 0;
    }

    private void incrementFailedAttempts() {
        failedAttempts++;
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
            lockAccount();
        }
    }

    public static void main(String[] args) {
        SecureBankAccount acc1 = new SecureBankAccount("A1001", 1000);
        SecureBankAccount acc2 = new SecureBankAccount("A1002", 500);

        acc1.setPin(0, 1234);
        acc2.setPin(0, 4321);

        acc1.deposit(200, 1234);
        acc1.withdraw(100, 1234);
        acc1.transfer(acc2, 300, 1234);

        acc1.validatePin(1111);
        acc1.validatePin(2222);
        acc1.validatePin(3333);

        acc1.withdraw(100, 1234);
        acc1.unlockAccount(1234);
        acc1.withdraw(100, 1234);

        acc2.withdraw(1000, 4321);
    }
}
