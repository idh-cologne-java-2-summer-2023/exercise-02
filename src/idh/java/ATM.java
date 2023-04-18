package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance1 = 5000;
	int accountBalance2 = 500;
	int accountBalance3 = 800;
	int accountBalance4 = 900;
	int accountBalance5 = 5000;
	
	int atmBalance = 50000;

	//For some reason, the program doesn't seem to work after my changes for task 1 and I don't know how to fix it.
	//Task two works though, so the money seems to be subtracted from the atm balance but not the actual accounts.
	
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
				System.out.print("Enter your bank ID: ");
				int id = Integer.parseInt(br.readLine());
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, id);
			} catch (Exception e) {
				break;
			}
		}
	}
	
	public void cashout(int amount, int id) {
		if (atmBalance >= amount) {
			atmBalance = atmBalance - amount;
		switch(id) {
		case '1':
		   if (amount <= accountBalance1) {
				accountBalance1 = accountBalance1 - amount;
				System.out.println("Ok, here is your money, enjoy!");
			} else {
				System.out.println("Sorry, not enough money in the bank.");
			}
		   break;
		case '2':
			   if (amount <= accountBalance2) {
					accountBalance2 = accountBalance2 - amount;
					System.out.println("Ok, here is your money, enjoy!");
				} else {
					System.out.println("Sorry, not enough money in the bank.");
				}
			   break;
		case '3':
			   if (amount <= accountBalance3) {
					accountBalance3 = accountBalance3 - amount;
					System.out.println("Ok, here is your money, enjoy!");
				} else {
					System.out.println("Sorry, not enough money in the bank.");
				}
			   break;
		case '4':
			   if (amount <= accountBalance4) {
					accountBalance4 = accountBalance4 - amount;
					System.out.println("Ok, here is your money, enjoy!");
				} else {
					System.out.println("Sorry, not enough money in the bank.");
				}
			   break;
		case '5':
			   if (amount <= accountBalance5) {
					accountBalance5 = accountBalance5 - amount;
					System.out.println("Ok, here is your money, enjoy!");
				} else {
					System.out.println("Sorry, not enough money in the bank.");
				}
			   break;
		}
		}
		else {
			System.out.println("Sorry, the ATM doesn't have enough money.");
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

