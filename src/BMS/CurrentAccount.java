package BMS;

class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(int accNo, double bal, double limit) {
        super(accNo, bal, "Current");
        this.overdraftLimit = limit;
    }

    public boolean checkOverdraft(double amount) {
        return amount <= (getBalance() + overdraftLimit);
    }
    
    public void withdraw(double amount) {
        if (checkOverdraft(amount)) {
            double newBalance = getBalance() - amount;
            setBalance(newBalance);
            System.out.println("Withdrawal successful");
            System.out.println("Current Balance: " + getBalance());
        } else {
            System.out.println("Insufficient balance");
        }
    }
}
