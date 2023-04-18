package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int atmBalance = 5000;

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
				int number = Integer.parseInt(br.readLine());
				Account account = new Account(number);
				System.out.println("Welcome " + account.getAccountNumber() + ". You've got "
						+ account.getAccountBalance() + " money units in your account.");
				System.out.println("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, account);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, Account account) {
		if (atmBalance < amount) {
			System.out.println(
					"This ATM hasn't enough money left for your extravagant lifestyle. Please come back later or use your preferred search engine to find the next ATM.");
			return;
		}
		if (amount <= account.getAccountBalance()) {
			atmBalance -= amount;
			account.setAccountBalance(account.getAccountBalance() - amount);
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
