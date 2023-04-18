package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ATM {
    private Map<Integer, Integer> accountBalances = new HashMap<>();
    private int cashBalance = 1000;

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
        if (!accountBalances.containsKey(accountNumber)) {
            System.out.println("Sorry, account not found.");
        } else if (amount > cashBalance) {
            System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
        } else if (amount > accountBalances.get(accountNumber)) {
            System.out.println("Sorry, you don't have enough money in the bank.");
        } else {
            int newAccountBalance = accountBalances.get(accountNumber) - amount;
            accountBalances.put(accountNumber, newAccountBalance);
            cashBalance -= amount;
            System.out.println("Ok, here you go!");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.accountBalances.put(123, 500);
        atm.accountBalances.put(234, 100);
        atm.accountBalances.put(345, 200);
        atm.run();
    }
}
