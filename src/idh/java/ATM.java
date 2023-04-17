package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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
				System.out.print("Enter your account number: ");
				String.accountNumber = br.readLine();
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accountNumber, amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(String accountNumber, int amount) {
		if (accountBalances.containsKey(accountNumber)) {
			int accountBalance = accountBalances.get(accountNumber);
			if (amount <= accountBalance) {
				accountBalance -= amount;
				accountBalances.put(accountNumber, accountBalance);
				System.out.println("Ok, here is your money, enjoy!");
			} else {
				System.out.println("Sorry, not enough money in the bank.");
			}
		} else {
			System.out.println("Invalid account number.");
		}
	}; 
	public void addAccount(String accountNumber, int initialBalance) {
		accountBalances.put(accountNumber, initialBalance);
	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
	
		atm.addAccount("123456", 100);
		atm.addAccount("789012", 250);
		atm.run();
	};

}
