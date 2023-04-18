package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int atmBalance = 700;
	int accounts[][] = new int[3][2]; //neues Array für alle Accounts. Erste Spalte sind die Kontonummern, zweite die Kontostände
	
	public void createAccounts() {
		accounts[0][0] = 123;
		accounts[1][0] = 456;
		accounts[2][0] = 789;

		accounts[0][1] = 100;
		accounts[1][1] = 500;
		accounts[2][1] = 900;
	}


	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exits
	 */
	public void run() {
		createAccounts();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				boolean accountExists = false;
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());
				for(int i=0; i<accounts.length; i++) {
					if(accountNumber == accounts[i][0]) {
						accountExists = true;
						System.out.print("Enter the amount to withdraw: ");
						int amount = Integer.parseInt(br.readLine());
						cashout(i, amount);
					}
				}
				if(accountExists == false) System.out.println("Not a existing account number, please try again!");
				
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int accountIndice, int amount) {
		
		if (amount > atmBalance) {
			System.out.println("Sorry, not enough money in the ATM.");
		}
		else if (amount < accounts[accountIndice][1]){
			accounts[accountIndice][1] = accounts[accountIndice][1] - amount;
			atmBalance = atmBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		}
		else System.out.println("Sorry, not enough money in your bank account.");

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}