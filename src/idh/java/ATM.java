package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	int hardCash = 200;
	
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
				
				System.out.println("Please enter your BankID:");
				int id = Integer.parseInt(br.readLine());
				
				if (id == User.getID()) {
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					cashout(amount);
				}
			} catch (Exception e) { 
				break;
			}
		}
	}
	
	public void cashout(int amount) {
		
		
		if (hardCash > amount) {
			hardCash -= amount;
			User.setCash(amount);
			System.out.println("You have withdrawn " + amount + "$.");
			System.out.println("Your Account balance is " + User.getCash() + "$.");
		} else if (User.getCash() < amount) {
			System.out.println("Error. Your Account balance is too low!");
		} else if (hardCash < amount) {
			System.out.println("Sorry, this Automat does have enough cash stored.");
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
