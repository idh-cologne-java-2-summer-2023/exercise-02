/* FrancyB7 */


package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ATM {
	private Map<Integer, Integer> accountBalances = new HashMap<>();
	private int cashBalance = 1000;
	
	public ATM() {
		accountBalances.put(1, 500);
		accountBalances.put(2, 1000);
		accountBalances.put(3,200);
		
	}
	

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
				System.out.println("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accountNumber, amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int accountNumber, int amount) {
		if (!accountBalances.containsKey(accountNumber)) {
			System.out.println("Unknown account number.");
			return;
		}
		
		int accountBalance = accountBalances.get(accountNumber);
		
		if (amount > accountBalance) {
			System.out.println("Sorry, not enough money in the bank.");
			return;
		} 
		
		if (amount > cashBalance){
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
			return;
		}
		
		accountBalances.put(accountNumber, accountBalance - amount);
		cashBalance -= amount;
		System.out.println("Ok, here you go!");	

	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
