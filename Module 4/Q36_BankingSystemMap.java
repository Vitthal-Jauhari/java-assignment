// Q36: Simple banking system using Map to store customer IDs and account balances.

import java.util.HashMap;
import java.util.Map;

class BankSystem {
    private final Map<String, Double> accounts = new HashMap<>();

    public void createAccount(String customerId, double initialDeposit) {
        if (accounts.containsKey(customerId)) {
            System.out.println("Error: Account '" + customerId + "' already exists.");
            return;
        }
        if (initialDeposit < 0) {
            System.out.println("Error: Initial deposit cannot be negative.");
            return;
        }
        accounts.put(customerId, initialDeposit);
        System.out.printf("Created account %s with balance $%.2f%n", customerId, initialDeposit);
    }

    public void deposit(String customerId, double amount) {
        if (!accounts.containsKey(customerId)) {
            System.out.println("Error: Account '" + customerId + "' does not exist.");
            return;
        }
        if (amount <= 0) {
            System.out.println("Error: Deposit amount must be positive.");
            return;
        }
        double newBalance = accounts.get(customerId) + amount;
        accounts.put(customerId, newBalance);
        System.out.printf("Deposited $%.2f to %s. New Balance: $%.2f%n", amount, customerId, newBalance);
    }

    public void withdraw(String customerId, double amount) {
        if (!accounts.containsKey(customerId)) {
            System.out.println("Error: Account '" + customerId + "' does not exist.");
            return;
        }
        double currentBalance = accounts.get(customerId);
        if (amount <= 0 || amount > currentBalance) {
            System.out.printf("Error: Insufficient funds or invalid amount $%.2f for %s (Current Balance: $%.2f)%n",
                    amount, customerId, currentBalance);
            return;
        }
        double newBalance = currentBalance - amount;
        accounts.put(customerId, newBalance);
        System.out.printf("Withdrew $%.2f from %s. New Balance: $%.2f%n", amount, customerId, newBalance);
    }

    public void displayAllAccounts() {
        System.out.println("\n--- Bank Accounts Summary ---");
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            System.out.printf("Customer ID: %-10s | Balance: $%.2f%n", entry.getKey(), entry.getValue());
        }
        System.out.println("-----------------------------\n");
    }
}

public class Q36_BankingSystemMap {
    public static void main(String[] args) {
        BankSystem bank = new BankSystem();

        bank.createAccount("CUST-101", 500.00);
        bank.createAccount("CUST-102", 1250.75);
        bank.createAccount("CUST-103", 250.00);

        bank.displayAllAccounts();

        bank.deposit("CUST-101", 200.00);
        bank.withdraw("CUST-103", 100.00);
        bank.withdraw("CUST-102", 2000.00); // Insufficient funds

        bank.displayAllAccounts();
    }
}
