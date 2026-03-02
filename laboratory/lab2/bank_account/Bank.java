package bank_account;

import java.util.Vector;

public class Bank {
    private Vector<Account> accounts;
    private int nextAccountNumber;
    
    public Bank() {
        accounts = new Vector<>();
        nextAccountNumber = 1000; 
    }
    
    // Новый счет
    public SavingsAccount openSavingsAccount(double interestRate) {
        SavingsAccount account = new SavingsAccount(nextAccountNumber++, interestRate);
        accounts.add(account);
        System.out.println("Opened new Savings Account: " + account.getAccountNumber());
        return account;
    }
    
    public CheckingAccount openCheckingAccount() {
        CheckingAccount account = new CheckingAccount(nextAccountNumber++);
        accounts.add(account);
        System.out.println("Opened new Checking Account: " + account.getAccountNumber());
        return account;
    }
    
    // Закрытие счета
    public boolean closeAccount(int accNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accNumber) {
                Account removed = accounts.remove(i);
                System.out.println("Closed account: " + removed.getAccountNumber());
                return true;
            }
        }
        System.out.println("Account " + accNumber + " not found");
        return false;
    }
    
    // Поиск счета 
    public Account findAccount(int accNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNumber) {
                return acc;
            }
        }
        return null;
    }
    
    // обработки всех счетов
    public void update() {
        System.out.println("\n=== Updating all accounts ===");
        
        for (Account acc : accounts) {
            if (acc instanceof SavingsAccount) {
                
                System.out.print("\nProcessing " + acc + " - ");
                ((SavingsAccount) acc).addInterest();
                
            } else if (acc instanceof CheckingAccount) {
                
                System.out.print("\nProcessing " + acc + " - ");
                ((CheckingAccount) acc).deductFee();
            }
        }
    }
    
   
    public void printAllAccounts() {
        System.out.println("\nAll Bank Accounts (" + accounts.size() + ") ===");
        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }
    
    // Общая сумма в банке
    public double getTotalBalance() {
        double total = 0;
        for (Account acc : accounts) {
            total += acc.getBalance();
        }
        return total;
    }
}