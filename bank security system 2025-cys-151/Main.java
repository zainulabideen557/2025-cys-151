public class Main {
    public static void main(String[] args) {
        // Ek naya account banate hain
        BankAccount myAccount = new BankAccount("PK-12345", 5000);

        System.out.println("Initial Balance: " + myAccount.getBalance());

        // Deposit testing (Valid data - Sahi amount)
        myAccount.deposit(2000);
        System.out.println("Updated Balance: " + myAccount.getBalance());

        // Deposit testing (Invalid data - Security test)
        System.out.println("\n--- Security Test: Trying to deposit negative amount ---");
        myAccount.deposit(-1000); // Yeh error dega aur balance change nahi hoga

        System.out.println("Final Balance: " + myAccount.getBalance());
    }
}

// Secure Bank Account Class using Encapsulation
class BankAccount {
    // 1. Data Hiding: Variables ko private rakha
    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        if(initialBalance > 0) {
            this.balance = initialBalance;
        }
    }

    // 2. Controlled Access: Sirf balance dekhne ki ijazat hai
    public double getBalance() {
        return this.balance;
    }

    // 3. Security Guard (Setter): Negative value ko block karta hai
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Error: Invalid deposit amount! Transaction Blocked.");
        }
    }
}