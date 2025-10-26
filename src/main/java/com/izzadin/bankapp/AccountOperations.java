package main.java.com.izzadin.bankapp;

public interface AccountOperations {

    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
    String getOwnerName();
    String getAccountNumber();
    void displayInfo();

}