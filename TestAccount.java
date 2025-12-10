/**
 * TestAccount.java
 * 
 * This class serves as the test driver for the BankAccount and CheckingAccount classes.
 * It creates a CheckingAccount object and demonstrates key functionality:
 *  - Depositing funds
 *  - Withdrawing within balance
 *  - Overdrawing and applying overdraft fee
 *  - Displaying account details
 * 
 */
public class TestAccount {
    public static void main(String[] args) {
        // Create a new CheckingAccount object
        CheckingAccount myAccount = new CheckingAccount("Hugo", "Martinez", 12345, 1.5);

        System.out.println("\n--- Test 1: Display Empty Account ---");
        myAccount.displayAccount();

        System.out.println("\n--- Test 2: Deposit $500 ---");
        myAccount.deposit(500);
        myAccount.displayAccount();

        System.out.println("\n--- Test 3: Withdraw $200 (within balance) ---");
        myAccount.processWithdrawal(200);
        myAccount.displayAccount();

        System.out.println("\n--- Test 4: Attempt to Withdraw $400 (overdraft) ---");
        myAccount.processWithdrawal(400);
        myAccount.displayAccount();

        System.out.println("\n--- Test 5: Deposit $300 After Overdraft ---");
        myAccount.deposit(300);
        myAccount.displayAccount();

        System.out.println("\n--- Test 6: Attempt to Deposit a Negative Amount ---");
        myAccount.deposit(-100);
        myAccount.displayAccount();

        System.out.println("\n--- Test 7: Attempt to Withdraw a Negative Amount ---");
        myAccount.processWithdrawal(-50);
        myAccount.displayAccount();
    }
}
