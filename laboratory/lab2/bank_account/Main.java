package bank_account;

public class Main {
    public static void main(String[] args) {
        // Создаем банк
        Bank bank = new Bank();
        
    
        
        // Открываем счета
        System.out.println("Opening Accounts");
        SavingsAccount savings1 = bank.openSavingsAccount(5.0); // 5% годовых
        SavingsAccount savings2 = bank.openSavingsAccount(3.5);
        CheckingAccount checking1 = bank.openCheckingAccount();
        CheckingAccount checking2 = bank.openCheckingAccount();
        
        // Выполняем операции
        System.out.println("\nPerforming Transactions");
        
        // Savings account операции
        savings1.deposit(1000);
        savings2.deposit(500);
        
        // Checking account операции (будет превышение бесплатных транзакций)
        checking1.deposit(2000);
        checking1.withdraw(100);
        checking1.deposit(300);
        checking1.withdraw(50);
        checking1.deposit(100); // 5-я транзакция
        
        checking2.deposit(1500);
        checking2.withdraw(200);
        checking2.transfer(100, savings1); // это 3-я транзакция
        
        // Выводим все счета до обновления
        bank.printAllAccounts();
        
        // Вызываем update для начисления процентов и вычета комиссий
        bank.update();
        
        // Выводим все счета после обновления
        bank.printAllAccounts();
        
        // Тестируем перевод между счетами
        System.out.println("\n--- Testing Transfer ---");
        savings1.transfer(200, checking1);
        
        // Показываем итоговое состояние
        System.out.println("\n--- Final State ---");
        bank.printAllAccounts();
        
        // Общая сумма в банке
        System.out.println("\nTotal money in bank: $" + 
                          String.format("%.2f", bank.getTotalBalance()));
        
        // Тестируем закрытие счета
        System.out.println("\n--- Testing Account Closure ---");
        bank.closeAccount(savings2.getAccountNumber());
        bank.printAllAccounts();
        
        // Тестируем поиск счета
        System.out.println("\n--- Testing Find Account ---");
        Account found = bank.findAccount(checking1.getAccountNumber());
        if (found != null) {
            System.out.println("Found: " + found);
        }
    }
}