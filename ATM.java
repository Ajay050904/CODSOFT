import java.util.Scanner;

public class ATM {
    private BankAccount account;

    // constructor
    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount : $");
                    double depositeAmount = sc.nextDouble();
                    deposit(depositeAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount : $");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
        sc.close();
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    private void deposit(Double amt) {
        account.deposit(amt);
        System.out.println("Successfully deposited $" + amt);
        checkBalance();
    }

    private void withdraw(Double amt) {
        if (account.withdraw(amt)) {
            System.out.println("Successfully withdrew $" + amt);
        }
        checkBalance();
    }
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); // Initialize account with a balance of $1000
        ATM atm = new ATM(account);
        atm.showMenu();
    }
}
