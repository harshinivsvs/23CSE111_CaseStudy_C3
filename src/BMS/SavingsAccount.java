package BMS;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accNo, double bal, double rate) {
        super(accNo, bal, "Savings");
        this.interestRate = rate;
    }

    public double calculateInterest() {
        return getBalance() * interestRate;
    }
}
