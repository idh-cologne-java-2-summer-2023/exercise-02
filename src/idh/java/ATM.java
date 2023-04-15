package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int moneyInATM = 100000;
	int[] users;
	int[] usersMoney;
	int numberOfUsers;
	int bruh = 0; //wird benutzt als Variable um zwischen login() und cashout() zu kommunizieren, um welchen User es sich handelt
	
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		users = new int[10]; //Begrenzung von 10 Kunden
		usersMoney = new int[10];
		numberOfUsers = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int kontonummer = Integer.parseInt(br.readLine());
				login(kontonummer);
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void login(int kontonummer) {
		for(int i = 0; i < users.length; i++) {
			if(users[i] == 0 && kontonummer != users[i]) {  
				users[numberOfUsers] = kontonummer;
				usersMoney[numberOfUsers] = 50000;
				numberOfUsers++;
				bruh = i;
				break;
			}
			else if(kontonummer == users[i]) {
				bruh = i;
				break;
			}
		}
	}
	
	public void cashout(int amount) {
		if(moneyInATM - amount >= 0) {
			if (amount <= usersMoney[bruh]) {
				usersMoney[bruh] -= amount;
				moneyInATM -= amount;
				System.out.println("Ok, here is your money, enjoy!");
				System.out.println("There are " + usersMoney[bruh] + "€ left in your account.");
			} else {
				System.out.println("Sorry, not enough money in the bank.");
			}
		}
		else {
			System.out.println("Sorry the ATM doesn't have that much cash anymore.");
		}
		bruh = 0; //Reset, damit die Zählervariable beim nächsten User-Login wieder funktioniert
	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
