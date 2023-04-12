package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {

	String[] accountNumbers = { "123", "456", "789" }; // Beispiel-Kontonummern
	int[] accountBalances = { 100, 200, 300 }; // Beispiel-Kontostände

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
				String accountNumber = br.readLine();
				int accountBalance = this.getAccountBalance(accountNumber);
				if (accountBalance != -1) {
					System.out.println("Current balance: " + accountBalance);
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					this.cashout(accountNumber, amount);
				} else {
					System.out.println("Error: Account number not found.");
				}
			} catch (Exception e) {
				break;
			}
		}
	}

	public int getAccountBalance(String accountNumber) {
		for (int i = 0; i < this.accountNumbers.length; i++) {
			if (this.accountNumbers[i].equals(accountNumber)) {
				return this.accountBalances[i];
			}
		}
		return -1; // Rückgabewert -1, wenn Kontonummer nicht gefunden wird
	}

	public void cashout(String accountNumber, int amount) {
		int accountBalance = this.getAccountBalance(accountNumber);
		if (accountBalance != -1 && amount <= accountBalance) {
			for (int i = 0; i < this.accountNumbers.length; i++) {
				if (this.accountNumbers[i].equals(accountNumber)) {
					this.accountBalances[i] = accountBalance - amount;
					System.out.println("Ok, here you go!");
					break;
				}
			}
		} else {
			System.out.println("Sorry, you don't have enough money in the bank.");
		}
	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
