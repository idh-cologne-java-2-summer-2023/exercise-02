package idh.java;

import java.io.*;

public class ATM {
	
	int balance;
	/**
	 * Main command loop of the ATM.
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks 
	 * and the program exits
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.print("Enter the amount to withdraw: ");
				String input = br.readLine();
				if (input.toLowerCase().equals("exit")) {
					System.exit(0);
				}
				int amount = Integer.parseInt(input);
				cashout(amount);
			} catch (Exception e) {
				System.out.println("illegal input");
				break;
			}
		}
	}
	
	public void cashout(int amount) {
		if (amount <= balance) {
			System.out.println("Ok, here is your money, enjoy!");
			balance -= amount;
		}
		else {
			System.out.println("Sorry, not enough money in the bank");
		}
	}
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	}
}