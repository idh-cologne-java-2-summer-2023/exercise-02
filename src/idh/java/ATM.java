package idh.java;

import java.io.BufferedReader;
import java.util.Scanner;


import java.io.InputStreamReader;

public class ATM {
	
	
	int atmBalance = 50;
	int accountBalance = 100;
	int accountNumber;

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
				access(accountNumber); 
				
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount); 
				
				
				
			} catch (Exception e) {
				break;
			}
		}
	}

//method for validating an account of a user.
	public void access(int accountNumber) {
		if (accountNumber >= 3) {
			System.out.println("Welcome, customer.");
			}
}; 
	

	public void cashout(int amount) {
		if (amount < accountBalance && amount < atmBalance) {
			accountBalance = accountBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else if (amount > atmBalance){
			atmBalance = atmBalance - amount;
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
		} else if (amount > accountBalance){
			accountBalance = accountBalance - amount;
			System.out.println("Sorry, your account doesn't hold that much.");
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
