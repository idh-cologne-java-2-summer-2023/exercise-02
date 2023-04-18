package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ATM {
	int accountBalance = 100;
	int ATMbalance= 500;

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner (System.in);
		while (true) {
			try {
				//GIVE ACCOUNT NUMBER
				System.out.println("Enter your account number:");
				String input = sc.next();
				
				
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
			
		}
	}
	
	

	public void cashout(int amount) {
 		if (amount < accountBalance && ATMbalance >= amount) {
			accountBalance = accountBalance - amount;
			ATMbalance= ATMbalance-amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else if(amount > accountBalance && ATMbalance >= amount) {
			//accountBalance = accountBalance - amount;
			ATMbalance= ATMbalance-amount;
			System.out.println("Sorry, you don't have enough money in the bank.");
		}else if (amount < accountBalance && ATMbalance < amount) {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
			
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
