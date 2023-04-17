package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ATM {
    private List<BankAccount> accounts;
    private int cashOnHand;

    public ATM() {
        accounts = new ArrayList<>();

        accounts.add(new BankAccount(123, 1000));
        accounts.add(new BankAccount(234, 500));
        accounts.add(new BankAccount(345, 200));
        accounts.add(new BankAccount(678, 40000));
        accounts.add(new BankAccount(789, 400));
        accounts.add(new BankAccount(890, 5000));
        accounts.add(new BankAccount(901, 9000));
     

        cashOnHand = 20000;
    }

    /**
     * Main command loop of the ATM. Asks the user to enter an account number and
     * then the amount to withdraw. If the user enters an invalid input, the loop
     * breaks and the program exits.
     */
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter your account number: ");
                int accountNumber = Integer.parseInt(br.readLine());
                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());
                cashout(accountNumber, amount);
            } catch (Exception e) {
                break;
            }
        }
    }

    public void cashout(int accountNumber, int amount) {
        BankAccount account = null;
        for (BankAccount a : accounts) {
            if (a.getAccountNumber() == accountNumber) {
                account = a;
                break;
            }
        }

        if (account == null) {
            System.out.println("Invalid account number.");
            return;
        }

        if (amount > cashOnHand) {
            System.out.println("Sorry, the ATM does not have enough cash on hand.");
            return;
        }

        if (amount > account.getBalance()) {
            System.out.println("Sorry, you do not have enough funds in your account.");
            return;
        }

        account.withdraw(amount);
        cashOnHand -= amount;
        System.out.println("Ok, here you go!");
    }

    /**
     * Launches the ATM
     */
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }

   
    private static class BankAccount {
        private int accountNumber;
        private int balance;

        public BankAccount(int accountNumber, int balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public int getBalance() {
            return balance; 
        }

        public void withdraw(int amount) {
            balance -= amount;
        }
    }
}