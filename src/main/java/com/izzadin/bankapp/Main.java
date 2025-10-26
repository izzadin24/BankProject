package main.java.com.izzadin.bankapp;

import java.util.Scanner;

class BankAccount implements AccountOperations {

    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public void displayInfo() {
        System.out.println("\n--- Info Akun ---");
        System.out.println("Nomor Rekening: " + this.accountNumber);
        System.out.println("Nama Pemilik: " + this.ownerName);
        System.out.println("Saldo: Rp" + this.balance);
        System.out.println("-----------------");
    }

    public void deposit(double amount) {
        if (amount > 0) {
            // Perbaikan #3: Akses langsung lebih ringkas di dalam kelas sendiri
            this.balance += amount;
            System.out.println("Setoran Rp" + amount + " berhasil. Saldo baru: Rp" + this.balance);
        } else {
            System.out.println("Jumlah setoran harus lebih dari nol.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Jumlah penarikan harus lebih dari nol.");
            return;
        }

        if (isSufficientBalance(amount)) {
            // Perbaikan #3: Akses langsung lebih ringkas
            this.balance -= amount;
            System.out.println("Penarikan Rp" + amount + " berhasil. Saldo baru: Rp" + this.balance);
        } else {
            System.out.println("Gagal! Saldo tidak mencukupi.");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    private boolean isSufficientBalance(double amount) {
        return this.balance >= amount;
    }


}





public class Main {
    public static final String CORRECT_PASSWORD = "4567";
    public static final int MAX_LOGIN_ATTEMPTS = 4;

    // Perbaikan #1: Signature metode disederhanakan, tidak perlu parameter 'sandi' dan 'login'
    private static boolean handleLogin(Scanner scanner) {
        for (int i = 0; i < MAX_LOGIN_ATTEMPTS; i++) {
            System.out.print("Masukkan sandi: ");
            String input = scanner.nextLine().trim();
            // Langsung akses konstanta
            if (input.equals(CORRECT_PASSWORD)) {
                System.out.println("Login berhasil!");
                return true; // Langsung return, lebih jelas
            } else {
                System.out.println("Sandi salah!");
            }
        }
        return false; // Return false jika loop selesai (gagal)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Perbaikan 2: Panggilan ke handleLogin lebihj simpel
        boolean isLoggedIn = handleLogin(scanner);

        if (!isLoggedIn) {
            System.out.println("Terlalu banyak kegagalan. Coba lagi nanti.");
            scanner.close();
            System.exit(0);
        }

        BankAccount account1 = new BankAccount("202410370110325", "Nabiila Izzati", 500000.0);
        BankAccount account2 = new BankAccount("202410370110038", "Amalia", 1000000.0);

        account1.displayInfo();
        account2.displayInfo();

        System.out.print("\nMasukkan jumlah setoran untuk " + account1.getOwnerName() + ": Rp");
        double depositAmount1 = scanner.nextDouble();
        account1.deposit(depositAmount1);

        System.out.print("Masukkan jumlah penarikan untuk " + account2.getOwnerName() + ": Rp");
        double withdrawAmount2 = scanner.nextDouble();
        account2.withdraw(withdrawAmount2);

        account1.displayInfo();
        account2.displayInfo();

        scanner.close();
    }
}