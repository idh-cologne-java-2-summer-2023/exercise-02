package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int atmBalance = 1000;
	int accountCheck = 123;
	int accountBalance = 2000;

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
				//Abfrage der Kontonummer und Weitergabe der Kontonummer an die Funktion "accountCheck")
				System.out.println("Enter your account number:");
				int accountNumber = Integer.parseInt(br.readLine());
				accountCheck(accountNumber);
			} catch (Exception e) {
				break;
			}
			try {	
				//Abfrage des gewünschten Geldbetrages und Weitergabe an Funktion "cashout" (Aus alter HA)		
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void accountCheck (int accountNumber) {
		if (accountNumber == accountCheck) {
			System.out.println("Hello account " + accountNumber);
		} else {
			System.out.println("This account is unknown to us.");
		}
	};
	
	public void cashout(int amount) {
		if (amount <= accountBalance) {
			accountBalance = accountBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} 
		/*Das Nachfolgende funktioniert so nicht... 
		else if (amount <= atmBalance) {
			atmBalance = atmBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
			
		}*/ else {
			System.out.println("Sorry, not enough money in the bank.");
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
