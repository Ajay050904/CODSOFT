public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); // Initialize account with a balance of $1000
        ATM atm = new ATM(account);
        atm.showMenu();
    }
}
