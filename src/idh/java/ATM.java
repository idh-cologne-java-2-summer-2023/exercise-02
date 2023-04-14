package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;

public class ATM {
	
	int accountBalance = 100;
	int ATMCash = 10000;
    static int[] account = new int[100];
    
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
				System.out.print("Please enter your account number: ");
				int accNumber = Integer.parseInt(br.readLine());
				System.out.println("Your Account Balance is : " + account[accNumber] + "€");
				System.out.print("Please enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, accNumber);
				}
		catch (Exception e) {
				break;
			}
		}
}

	public void cashout(int amount, int accNumber) {
		if (amount <= account[accNumber] && amount <= ATMCash) {
			account[accNumber] = account[accNumber] - amount;
			ATMCash = ATMCash - amount;
			System.out.println("Ok, here is your money, enjoy!");
			System.out.println("You have " + account[accNumber] + "€ left in your account.");
		} 
		else if(amount > account[accNumber]) {
			System.out.println("Sorry, not enough money in the bank.");
		}
		else if(amount > ATMCash) {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
		}
		 

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
	    
		for(int i = 0; i < account.length; i++) {
			account[i] = (int)(Math.random()*5000) + 1;
		}
		ATM atm = new ATM();
		atm.run();
	};

}
