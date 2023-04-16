package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import b.ATM;

public class ATM {
	
	int cash = 500;
	
	/**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks 
	 * and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
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
		
		if (cash > amount) {
			cash -= amount;
			System.out.println("User specified amount is withdrawn. Enjoy. " + amount + "$.");
			System.out.println("Your current cash amount is " + cash + "$.");
		} else if (cash < amount) {
			System.out.println("Sorry, you are too poor.");
		} else if (cash == amount) {
			cash -= amount;
			System.out.println("User specified amount is withdrawn. Enjoy. " + amount + "$.");
			System.out.println("Your current cash amount is " + cash + "$.");
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
