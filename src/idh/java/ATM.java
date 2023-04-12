package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	Account onehoundredtwentythree = new Account(123, 200);
	Account twohoundredthirtyfour = new Account(234, 100);
	Account threehoundredfourtyfive = new Account(345, 50);
	Account[] accounts = { onehoundredtwentythree, twohoundredthirtyfour, threehoundredfourtyfive };

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
				int accountNumber = Integer.parseInt(br.readLine());
				for (int i = 0 ; i < accounts.length; i++) {
					if (accountNumber == accounts[i].getAccountNumber()) {
						System.out.print("Enter the amount to withdraw: ");
						int amount = Integer.parseInt(br.readLine());
						accounts[i].cashout(amount);
					}
				}
				// cashout(amount);
			} catch (Exception e) {
				break;
			}
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
