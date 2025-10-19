package main.java.com.yourname.bankapp;

import java.util.InputMismatchException;
import java.util.Scanner;

class BankAccount {
    String accountNumber;
    String ownerName;
    double balance;
    Scanner scanner;

    // Konstruktor dengan parameter Scanner biar pakai 1 scanner dari main
    public BankAccount(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayInfo() {
        System.out.println();
        System.out.println("Nomor Rekening: " + this.accountNumber);
        System.out.println("Nama Pemilik: " + this.ownerName);
        System.out.println("Saldo: Rp" + this.balance);
        System.out.println();
    }

    public void depositMoney() {
        while (true) {
            try {
                System.out.print("Jumlah yang ingin disetor untuk " + ownerName + ": Rp");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // bersihkan newline
                if (amount <= 0) {
                    System.out.println("Tidak boleh negatif atau nol!");
                    continue;
                }
                balance += amount;
                System.out.println(ownerName + " menyetor Rp" + amount + ". Saldo sekarang: Rp" + balance);
                System.out.println();
                break;

            } catch (InputMismatchException e) {
                System.out.println("Harus berupa angka!");
                scanner.nextLine(); // reset input error
            }
        }
    }

    public void withdrawMoney() {
        System.out.print("Masukkan jumlah yang ingin ditarik untuk " + ownerName + ": Rp");
        try {
            double amount = scanner.nextDouble();
            scanner.nextLine(); // bersihkan newline
            if (amount <= 0) {
                System.out.println("Jumlah tidak boleh nol atau negatif!");
                return;
            }
            if (balance >= amount) {
                balance -= amount;
                System.out.println(ownerName + " menarik Rp" + amount + ". (Berhasil) Saldo sekarang: Rp" + balance);
            } else {
                System.out.println(ownerName + " menarik Rp" + amount + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + balance);
            }
        } catch (InputMismatchException e) {
            System.out.println("Input salah! Harus angka.");
            scanner.nextLine();
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sandi = "4567";
        boolean login = false;

        // LOGIN SEKALI AJA
        for (int i = 0; i < 4; i++) {
            System.out.print("Masukkan sandi: ");
            String input = scanner.nextLine().trim();

            if (input.equals(sandi)) {
                login = true;
                break;
            } else {
                System.out.println("Sandi salah!");
            }
        }

        if (!login) {
            System.out.println("Terlalu banyak kegagalan. coba lagi nanti");
            System.exit(0);
        }

        // Buat akun setelah berhasil login
        BankAccount account1 = new BankAccount(scanner);
        BankAccount account2 = new BankAccount(scanner);

        // Set data akun
        account1.accountNumber = "202410370110325";
        account1.ownerName = "Nabiila Izzati";
        account1.balance = 500000.0;

        account2.accountNumber = "202410370110038";
        account2.ownerName = "Amalia";
        account2.balance = 1000000.0;

        // Tampilkan info awal
        account1.displayInfo();
        account2.displayInfo();

        // Setor
        account1.depositMoney();
        account2.depositMoney();

        // Tarik
        account1.withdrawMoney();
        account2.withdrawMoney();

        // Tampilkan info akhir
        account1.displayInfo();
        account2.displayInfo();

        scanner.close(); // jangan lupa tutup scanner
    }
}
