package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	int accountBalance = 100;

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exits
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
		if (amount <= accountBalance) {
			accountBalance -= amount;
			System.out.println("Here is your money, enjoy! Current amount in the bank: " + accountBalance);
		} else if (amount == 0) {
			System.out.println("Error: cannot withdraw the amount 0 from bank account. Please enter a new amount.");
		} else {
			System.out.println("Sorry, not enough money in the bank. Current amount in the bank: " + accountBalance);
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
