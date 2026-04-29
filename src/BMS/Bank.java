package BMS;

import java.util.*;
import java.io.*;

public class Bank {
    private String bankName;
    private List<Account> accounts = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    public Bank(String name) {
        this.bankName = name;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        saveCustomerToFile(customer);
        System.out.println("Saving customer to file...");
    }

    public Account createAccount(Customer customer, String type) {
        Account acc;
        if (type.equals("Savings")) {
            acc = new SavingsAccount(accounts.size()+1, 0, 0.05);
            //here 0.05 means 5% interest rate
        } else {
            acc = new CurrentAccount(accounts.size()+1, 0, 1000);
            //here 1000 represents overdraft limit
        }
        accounts.add(acc);
        return acc;
    }

    public Account findAccount(int accNo) {
        for (Account a : accounts) {
            if (a.getAccountNumber() == accNo)
                return a;
        }
        return null;
    }

    public void deposit(int accNo, double amount) {
        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.deposit(amount);
            recordTransaction(new Transaction(transactions.size()+1, amount, "Deposit"));
        }
    }

    public void withdraw(int accNo, double amount) {
        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.withdraw(amount);
            recordTransaction(new Transaction(transactions.size()+1, amount, "Withdraw"));
        }
    }

    public double getBalance(int accNo) {
        Account acc = findAccount(accNo);

        if (acc != null) {
            return acc.getBalance();
        } else {
            return 0;
        }
    }
    
    public void recordTransaction(Transaction t) {
        transactions.add(t);
        t.recordTransaction();
        saveTransactionToFile(t);
        System.out.println("Saving transaction to file...");
    }

    public Customer getCustomerDetails(int id) {
        for (Customer c : customers) {
            if (c.getCustomerID() == id)
                return c;
        }
        return null;
    }

private void saveCustomerToFile(Customer c) {
    try {
        FileWriter fw = new FileWriter("customers.txt", true);
        fw.write(c.getCustomerID() + "," +
                 c.getCustomerName() + "," +
                 c.getCustomerPin() + "," +   
                 c.getCustomerPhoneNumber() + "\n");
        fw.close();
    } catch (IOException e) {
        System.out.println("Error saving customer data!");
    }
}

private void saveTransactionToFile(Transaction t) {
    try {
        FileWriter fw = new FileWriter("transactions.txt", true);
        fw.write(t.getTransactionID() + "," +
                 t.getTransactionAmount() + "," +
                 t.getTransactionType() + "\n");
        fw.close();
    } catch (IOException e) {
        System.out.println("Error saving transaction!");
    }
	}
}
