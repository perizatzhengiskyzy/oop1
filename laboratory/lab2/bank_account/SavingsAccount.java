package bank_account;

public class SavingsAccount extends Account {
    private double interestRate;
    
    public SavingsAccount(int accNumber, double interestRate) {
        super(accNumber);
        this.interestRate = interestRate;
    }
    
    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest added: $" + String.format("%.2f", interest));
    }
    
    public double getInterestRate() {
        return interestRate;
    }
    
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    
    @Override
    public String toString() {
        return super.toString() + " [Savings Account, Interest Rate: " + interestRate + "%]";
    }
}