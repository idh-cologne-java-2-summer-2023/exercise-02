package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int atmBalance = 1500; // gibt an wieviel Geld im Automaten ist
	
	//"balance..." = Kontostand der jeweiligen Konten:
	int balance123 = 1000; 
	int balance234 = 400;
	int balance345 = 600;

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
				
				System.out.print("Enter your account number: "); // Eingabe Kontonummer bzw. account
				int account = Integer.parseInt(br.readLine());
				
				if (account == 123 || account == 234 || account == 345) { // Geld wird nur an vorhandene Konten ausgezahlt (account)
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, account);
				} else System.err.println("This account is not registered in this system. Try another.");
				
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, int account) { // Funktion berücksichtigt auch den account
		
		if (amount > atmBalance) { // es wird zuerst geprüft ob der Atomat zu wenig Geld hat
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
		}
		else if (account == 123 && amount <= balance123) {
			balance123 = balance123 - amount;
			atmBalance = atmBalance - amount; // ausgezahltes Geld wird auch vom gesamten Geld abgezogen
			System.out.println("Ok, here is your money, enjoy!");
		} else if (account == 123 && amount > balance123){
			System.out.println("Sorry, you don't have enough money in the bank.");
		} 
		
		else if (account == 234 && amount <= balance234) {
			balance234 = balance234 - amount;
			atmBalance = atmBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else if (account == 234 && amount > balance234){
			System.out.println("Sorry, you don't have enough money in the bank.");
		}
		
		else if (account == 345 && amount <= balance345) {
			balance345 = balance345 - amount;
			atmBalance = atmBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else if (account == 345 && amount > balance345){
			System.out.println("Sorry, you don't have enough money in the bank.");
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
