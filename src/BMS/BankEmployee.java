package BMS;

public class BankEmployee {
    private int employeeID;
    private String name;
    private String role;

    public Account createAccount(Bank bank, Customer customer, int typeChoice) {

        if (typeChoice == 1) {
            return bank.createAccount(customer, "Savings");
        } else if (typeChoice == 2) {
            return bank.createAccount(customer, "Current");
        } else {
            System.out.println("Invalid type! Defaulting to Savings.");
            return bank.createAccount(customer, "Savings");
        }
    }

    public void updateAccount(Account account) {
        System.out.println("Account updated");
    }

    public Customer viewCustomerDetails(Bank bank, int customerID) {
        return bank.getCustomerDetails(customerID);
    }
}