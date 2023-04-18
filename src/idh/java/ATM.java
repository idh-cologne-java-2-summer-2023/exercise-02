package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 100;

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount) {
		if (amount < accountBalance) {
			accountBalance = accountBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ATM {
    private int cashInMachine = 500;
    private HashMap<Integer, Integer> accountBalances = new HashMap<>();

    public ATM() {
        // Initialize some account balances for testing purposes
        accountBalances.put(123, 100);
        accountBalances.put(234, 300);
        accountBalances.put(345, 50);
    }

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
        } else if (amount > accountBalances.get(accountNumber)) {
            System.out.println("Sorry, not enough money in the bank.");
        } else if (amount > cashInMachine) {
            System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
        } else {
            accountBalances.put(accountNumber, accountBalances.get(accountNumber) - amount);
            cashInMachine -= amount;
            System.out.println("Ok, here you go!");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
