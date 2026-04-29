package BMS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank("MyBank");
        Authentication auth = new Authentication();

        Customer c1 = null;

        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.print("Enter choice: ");
        int startChoice = sc.nextInt();
        sc.nextLine();

        if (startChoice == 1) {

            int id;
            while (true) {
                System.out.print("Enter ID: ");
                if (sc.hasNextInt()) {
                    id = sc.nextInt();
                    if (id > 0) break;
                } else sc.next();
                System.out.println("Invalid ID!");
            }
            sc.nextLine();

            String name;
            while (true) {
                System.out.print("Enter Name: ");
                name = sc.nextLine();
                if (name.matches("[a-zA-Z ]+")) break;
                System.out.println("Invalid name!");
            }

            String pin;
            while (true) {
                System.out.print("Enter PIN (4 digits): ");
                pin = sc.nextLine();
                if (pin.matches("\\d{4}")) break;
                System.out.println("Invalid PIN!");
            }

            String phone;
            while (true) {
                System.out.print("Enter Phone: ");
                phone = sc.nextLine();
                if (phone.matches("\\d{10}")) break;
                System.out.println("Invalid phone!");
            }

            c1 = new Customer(id, name, pin, phone);
            bank.addCustomer(c1);
            System.out.println("Registered successfully!");
        }

        System.out.println("\n--- LOGIN ---");
        System.out.print("Enter ID: ");
        int loginId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter PIN: ");
        String loginPin = sc.nextLine();

        if (!auth.verifyCredentials(loginId, loginPin)) {
            System.out.println("Invalid login!");
            return;
        }

        System.out.println("Login successful!");

        BankEmployee emp = new BankEmployee();

        System.out.println("1. Savings");
        System.out.println("2. Current");
        System.out.print("Enter choice: ");
        int typeChoice = sc.nextInt();

        if (c1 == null) {
            c1 = new Customer(loginId, "User", loginPin, "0000000000");
        }

        Account acc = emp.createAccount(bank, c1, typeChoice);

        int choice;
        do {
            System.out.println("\n1.Deposit 2.Withdraw 3.Balance 4.Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Amount: ");
                    bank.deposit(acc.getAccountNumber(), sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Amount: ");
                    bank.withdraw(acc.getAccountNumber(), sc.nextDouble());
                    break;

                case 3:
                    System.out.println("Balance: " +
                            bank.getBalance(acc.getAccountNumber()));
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}