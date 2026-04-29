package BMS;
import java.util.Date;

import java.util.Date;

public class Transaction {
    private int transactionID;
    private double amount;
    private String transactionType;
    private Date date;

    public Transaction(int id, double amount, String type) {
        this.transactionID = id;
        this.amount = amount;
        this.transactionType = type;
        this.date = new Date();
    }

    public void recordTransaction() {
        System.out.println("Transaction Recorded: " + transactionType + 
                           " | Date: " + date);
    }

    public String generateReceipt() {
        return "Transaction ID: " + transactionID + 
               ", Amount: " + amount + 
               ", Type: " + transactionType +
               ", Date: " + date;
    }
    
    public int getTransactionID() {
        return transactionID;
    }
    
    public String getTransactionType() {
        return transactionType;
    }
    
    public double getTransactionAmount() {
        return amount;
    }
}