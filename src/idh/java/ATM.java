package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
//	verschiedene Konten werden erstellt
	private Account[] accounts = {
			new Account(123, 100),
			new Account(234, 250),
			new Account(345, 5000)
			};
//	Geld im Automaten wird festgelegt
	private int ATMBalance = 1000;

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
				System.out.println("Please enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());
				Account account = getAccount(accountNumber);
				if (account == null) {
					System.out.println("Invalid account number.");
					continue;
				}
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				if (amount > ATMBalance) {
					System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
				} else if (amount <= account.getBalance()) {
					account.withdraw(amount);
					System.out.println("Ok, here is your money! You have " + account.getBalance() + " left.");
				} else {
					System.out.println("Sorry, you don't have enough money on your account.");
				}

			} catch (Exception e) {
				break;
			}
		}
	}

	private Account getAccount(int accountNumber) {
		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return null;
	}

//	public void cashout(int amount) {
//		if (amount <= accountBalance) {
//			accountBalance = accountBalance - amount;
//			System.out.println("Ok, here is your money! You have " +accountBalance+ " left.");
//		} else {
//			System.out.println("Sorry, not enough money in the bank.");
//		}
//
//	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
