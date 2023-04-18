package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
    private int[] accountIDs; 
    private int[] accountBalances; 
    private int totalCashAvailable; 
    private final int MAX_CASH_AVAILABLE = 100000; 

    public ATM() {
        accountIDs = new int[] {1234, 5678, 9012};
        accountBalances = new int[] {1000, 500, 2000};
        totalCashAvailable = 5000; 
    }

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter your account ID: ");
                int accountID = Integer.parseInt(br.readLine());
                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());
                cashOut(accountID, amount);
            } catch (Exception e) {
                break;
            }
        }
    }

    public void cashOut(int accountID, int amount) {
        int index = -1;
      
        for (int i = 0; i < accountIDs.length; i++) {
            if (accountIDs[i] == accountID) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            int accountBalance = accountBalances[index];
            if (amount <= accountBalance && amount <= totalCashAvailable) {
                accountBalances[index] -= amount;
                totalCashAvailable -= amount;
                System.out.println("Ok, here is your money, enjoy!");
            } else {
                System.out.println("Sorry, not enough money in the bank or ATM.");
            }
        } else {
            System.out.println("Sorry, account not found.");
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

