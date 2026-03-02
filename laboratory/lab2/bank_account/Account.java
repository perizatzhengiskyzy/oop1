package bank_account;

public class Account {
    private double balance;
    private int accNumber;
    
    public Account(int a) {
        balance = 0.0;
        accNumber = a;
    }
    
    public void deposit(double sum) {
        if (sum > 0) {
            balance += sum;
            System.out.println("Deposited $" + sum + " to account " + accNumber);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    public void withdraw(double sum) {
        if (sum > 0 && sum <= balance) {
            balance -= sum;
            System.out.println("Withdrew $" + sum + " from account " + accNumber);
        } else {
            System.out.println("Insufficient funds or invalid amount");
        }
    }
    
    public double getBalance() {
        return balance;
    }
    
    public int getAccountNumber() {
        return accNumber;
    }
    
    public void transfer(double amount, Account other) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            other.deposit(amount);
            System.out.println("Transferred $" + amount + " from account " + 
                             accNumber + " to account " + other.getAccountNumber());
        } else {
            System.out.println("Transfer failed: insufficient funds");
        }
    }
    
    @Override
    public String toString() {
        return "Account " + accNumber + ": balance = $" + String.format("%.2f", balance);
    }
    
    public final void print() {
        System.out.println(toString());
    }
}