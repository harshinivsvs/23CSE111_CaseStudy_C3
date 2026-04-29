package BMS;

public class Customer {
    private int customerID;
    private String name;
    private String pin;
    private String phoneNumber;

    public Customer(int id, String name, String pin, String phone) {
        this.customerID = id;
        this.name = name;
        this.pin = pin;
        this.phoneNumber = phone;
    }

    public boolean login(String userID, String password) {
        return this.name.equals(userID) && this.pin.equals(pin);
    }

    public void logout() {
        System.out.println("Logged out successfully");
    }

    public int getCustomerID() {
        return customerID;
    }
    
    public String getCustomerName() {
        return name;
    }
    
    public String getCustomerPhoneNumber() {
        return phoneNumber;
    }
    
    public String getCustomerPin() {
        return pin;
    }
}