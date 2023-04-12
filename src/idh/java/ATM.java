package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
    private int[] accountNumbers; // Array zur Speicherung von Kontonummern
    private int[] accountBalances; // Array zur Speicherung von Kontoständen
    private int cashAvailable; // Bargeldbestand des Automaten

    // Konstruktor zur Initialisierung der Arrays und des Bargeldbestands
    public ATM() {
        accountNumbers = new int[]{123, 234, 345}; // Beispiel-Kontonummern
        accountBalances = new int[]{100, 200, 50}; // Beispiel-Kontostände
        cashAvailable = 1000; // Beispiel-Bargeldbestand
    }

    /**
     * Main command loop of the ATM Asks the user to enter an account number and an
     * amount, and passes them to the function cashout(...) which actually does the
     * calculation and produces money. If the user enters anything else than an integer
     * number, the loop breaks and the program exits.
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

    /**
     * Performs the withdrawal operation for a given account number and amount. Updates
     * the account balance and the cash available in the ATM accordingly.
     */
    public void cashout(int accountNumber, int amount) {
        int accountIndex = -1;
        for (int i = 0; i < accountNumbers.length; i++) {
            if (accountNumbers[i] == accountNumber) {
                accountIndex = i;
                break;
            }
        }
        if (accountIndex != -1) {
            int accountBalance = accountBalances[accountIndex];
            if (amount <= accountBalance) {
                if (amount <= cashAvailable) {
                    accountBalance -= amount;
                    cashAvailable -= amount;
                    accountBalances[accountIndex] = accountBalance;
                    System.out.println("Ok, here you go!");
                } else {
                    System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
                }
            } else {
                System.out.println("Sorry, you don't have enough money in the bank.");
            }
        } else {
            System.out.println("Account number not found.");
        }
    }

    /**
     * Launches the ATM
     */
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
