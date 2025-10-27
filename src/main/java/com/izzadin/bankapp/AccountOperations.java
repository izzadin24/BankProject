package main.java.com.izzadin.bankapp;

public interface AccountOperations {

    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
    String getOwnerName();
    String getAccountNumber();
    void displayInfo();

}

/**
 * git init
 * git add .
 * git commit -m "initial commit"
 * git remote add origin <url></url>
 * git branch -M master
 * git push -u origin master
 */