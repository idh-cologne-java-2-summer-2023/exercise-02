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
				System.out.print("Enter your account number: ");
				int user = Integer.parseInt(br.readLine());
				checkin(user);
			} catch (Exception e) {
				break;
			}
			
			try {
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
			try {
				System.out.print("Enter the amount to withdraw: ");
				int broke = Integer.parseInt(br.readLine());
				nomoney(broke);
			} catch (Exception e) {
				break;
			}
		}
	}
	public void checkin(int user) {
		if (user == accountBalance) {
		} 

	}
	public void cashout(int amount) {
		if (amount < accountBalance) {
			accountBalance = accountBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}

	}
	public void nomoney(int broke) {
		if (broke < accountBalance) {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
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
