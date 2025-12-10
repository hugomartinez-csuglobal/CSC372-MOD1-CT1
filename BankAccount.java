/**
 * BankAccount.java
 * 
 * Superclass representing a generic bank account.
 * 
 * This class defines the core attributes and behaviors shared by all bank accounts, 
 * including customer name, account ID, and current balance. It includes methods to:
 *  - Deposit and withdraw funds (with basic validation)
 *  - View the current balance
 *  - Display a full account summary
 * 
 * This class will be extended by the CheckingAccount subclass, which adds specific 
 * features such as interest rates and overdraft handling.
 * 
 */
public class BankAccount {
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    // Constructor: initializes balance to zero
    public BankAccount() {
        this.balance = 0.0;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAccountID() {
        return accountID;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdrawal method
    public void withdrawal(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else if (amount > balance) {
            System.out.println("Insufficient funds for this withdrawal.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Account summary
    public void accountSummary() {
        System.out.println("Account Summary:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.printf("Balance: $%.2f\n", balance);
    }
}
