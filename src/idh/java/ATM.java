package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int atmBalance = 100;
	int kontoBalance = 25;
	int gontoBalance = 125;
	int brontoBalance = 1752;
	String konto = "123";
	String gonto = "234";
	String bronto = "345";

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
				String account = br.readLine();
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, account);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, String account) {
			switch (account) {
			case "123": if (amount <= kontoBalance) {
				if (amount <= atmBalance) {
					kontoBalance = kontoBalance - amount;
				System.out.println("Ok, here you go!");
				}	else {
							System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
						}
			} else {
				System.out.println("Sorry, you don't have enough money in the bank.");
			}
			break;
			case "234": if (amount <= gontoBalance) {
				if (amount <= atmBalance) {
					gontoBalance = gontoBalance - amount;
				System.out.println("Ok, here you go!");
				}	else {
							System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
						}
			} else {
				System.out.println("Sorry, you don't have enough money in the bank.");
			}
			break;
			case "345": if (amount <= brontoBalance) {
				if (amount <= atmBalance) {
					brontoBalance = brontoBalance - amount;
				System.out.println("Ok, here you go!");
				}	else {
							System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
						}
			} else {
				System.out.println("Sorry, you don't have enough money in the bank.");
			}
			break;
			default: 
				System.out.println("Invalid account number");
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
