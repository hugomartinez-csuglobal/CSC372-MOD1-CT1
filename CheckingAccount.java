/**
 * CheckingAccount.java
 * 
 * Subclass of BankAccount that adds checking-specific features.
 * 
 * This class inherits all basic banking functionality from the BankAccount superclass.
 * It adds a unique interest rate and special handling for overdraft withdrawals, 
 * where a $30 fee is charged when the account is overdrawn.
 * 
 * Key methods include:
 *  - processWithdrawal(): allows overdraft, applies $30 fee, and prints status
 *  - displayAccount(): displays all account details, including interest rate
 * 
 */
public class CheckingAccount extends BankAccount {
    private double interestRate;

    // Constructor with parameters
    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(); // calls BankAccount constructor to set balance to 0
        setFirstName(firstName);
        setLastName(lastName);
        setAccountID(accountID);
        this.interestRate = interestRate;
    }

    // Setter and getter for interestRate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    // Method to process withdrawals, including overdraft fee
    public void processWithdrawal(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (amount <= getBalance()) {
            // Normal withdrawal
            withdrawal(amount);
            System.out.printf("Withdrawal of $%.2f successful.\n", amount);
        } else {
            // Overdraft
            double total = amount + 30.0; // include overdraft fee
            withdrawal(getBalance()); // zero out balance
            System.out.printf("Overdraft! You attempted to withdraw $%.2f.\n", amount);
            System.out.println("$30 overdraft fee has been assessed.");
            System.out.printf("New balance: -$%.2f\n", total - getBalance());
        }
    }

    // Method to display all account information
    public void displayAccount() {
        System.out.println("Checking Account Details:");
        accountSummary(); // inherited from BankAccount
        System.out.printf("Interest Rate: %.2f%%\n", interestRate);
    }
}
