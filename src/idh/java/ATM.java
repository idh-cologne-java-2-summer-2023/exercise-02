package idh.java;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM {
	// unfinished

	// ATM and User info
	int balanceATM = 700;
	public int accountBalance; // TO DO: arrange userbalance Array with int accountBalance?

	// used arrays to store user infos for later use
	Holder user1 = new Holder("Max Mustermann", "1300", 300);
	Holder user2 = new Holder("Maxime Menno", "1301", 400);
	Holder user3 = new Holder("Arne Schlucker", "1302", 2);
	// unsure how to solve problems with static non-static fields.. + couldn't
	// implement Accounts for task c) 2
	String[] holdernames = { user1.getHolderName(), user2.getHolderName(), user3.getHolderName() };
	String[] usersids = { user1.getUserid(), user2.getUserid(), user3.getUserid() };
	int[] userbalance = { user1.getAccountBalance(), user2.getAccountBalance(), user3.getAccountBalance() };

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */

	// switch to check ID or restart
	public void checkID() {
		System.out.println("Enter ID: ");
		try (Scanner in = new Scanner(System.in)) {
			String ID = in.nextLine();

			switch (ID) {
			case "1300":
				System.out.println("Account of: Max Mustermann"); // holdernames[0]
				System.out.println("Balance: " + userbalance[0]);
				break;
			case "1301":
				System.out.println("Account of: Maxime Menno"); // holdernames[1]
				System.out.println("Balance: " + userbalance[1]);
				break;
			case "1302":
				System.out.println("Account of: Arne Schlucker"); // holdernames[2]
				System.out.println("Balance: " + userbalance[2]);
				break;
			default:
				System.out.println("Not found. Restart and try again.");
				checkID();
				break;
			}
		}
	}

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

//	TO DO:
//	boolean needed to check if cashout managable with Holder as well as ATM balance
//	public boolean cashcheck() {
//	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {

		ATM atm = new ATM();

		atm.checkID();
		atm.run();
	};

}
