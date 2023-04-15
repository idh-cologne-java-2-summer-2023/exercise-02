package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	int[] users = {1, 2, 3};
	int accountNumber;
	int balance;
	
	int ATMbalance;
	
	
	public ATM() {
		int accountNumber = this.accountNumber;
		int usersBalance = balance;
	}

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exits
	 * @param  
	 */
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				accountNumber = Integer.parseInt(br.readLine());
				
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				int balance = Integer.parseInt(br.readLine());
				cashout(amount, balance);
			} catch (Exception e) {
				break; 
			} 
		} 
	}
	
	public boolean login(int accountNumber, int accountBalance) {
		for (int i = 0; i < users.length; i++) { 
			if (accountNumber == this.accountNumber) {
				return true;
			}
		} return false;		
	}		
		
 
	public boolean cashout(int amount, int balance) {
		for (int i = 0; i < users.length; i++) { 
			if (balance == this.balance) {
				return true;
			} 
		}
		if (amount <= balance) {
			balance -= amount;
			System.out.println("Here is your money, enjoy! Current amount in the bank: " + balance);
		} else if (amount == 0) {
			System.out.println("Error: cannot withdraw the amount 0 from bank account. Please enter a new amount.");
		} else {
			System.out.println("Sorry, not enough money in the bank. Current amount in the bank: " + balance);
		}
		
	return false;
	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
