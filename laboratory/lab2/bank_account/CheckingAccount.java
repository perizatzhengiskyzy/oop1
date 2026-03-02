package bank_account;

public class CheckingAccount extends Account {
    private static final double FREE_TRANSACTIONS = 3; // количество бесплатных транзакций
    private static final double TRANSACTION_FEE = 0.02; // плата за транзакцию ($0.02)
    
    private int transactionCount;
    
    public CheckingAccount(int accNumber) {
        super(accNumber);
        this.transactionCount = 0;
    }
    
    @Override
    public void deposit(double sum) {
        super.deposit(sum);
        transactionCount++;
    }
    
    @Override
    public void withdraw(double sum) {
        super.withdraw(sum);
        transactionCount++;
    }
    
    @Override
    public void transfer(double amount, Account other) {
        super.transfer(amount, other);
        transactionCount++; 
    }
    
    public void deductFee() {
        if (transactionCount > FREE_TRANSACTIONS) {
            double fee = (transactionCount - FREE_TRANSACTIONS) * TRANSACTION_FEE;
            super.withdraw(fee);
            System.out.println("Fee deducted: $" + String.format("%.2f", fee) + 
                             " for " + (transactionCount - FREE_TRANSACTIONS) + 
                             " extra transactions");
        }
        transactionCount = 0; 
    }
    
    public int getTransactionCount() {
        return transactionCount;
    }
    
    @Override
    public String toString() {
        return super.toString() + " [Checking Account, Transactions this period: " + 
               transactionCount + "/" + FREE_TRANSACTIONS + " free]";
    }
}