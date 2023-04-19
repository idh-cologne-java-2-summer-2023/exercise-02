package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ATM {
	

	int atmBalance = 10000;

	// Create a HashMap object called  bankAccount
    HashMap<Integer, Integer> bankAccount = new HashMap<Integer, Integer>();
    // Add keys and values (accountNumber, accountBalance)
    bankAccount.put(123, 25);
    bankAccount.put(234, 2);
    bankAccount.put(345, 100);

  

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
                if (!accountNumber.containsKey(bankAccount)) {
					System.out.println("Sorry, account not found.");
					break;
                }
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accountNumber, amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int accountNumber, int amount) {
		if (amount < accountBalance && amount < atmBalance) {
			accountBalance = accountBalance - amount;
			atmBalance = atmBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else if (amount > atmBalance) {
			atmBalance = atmBalance - amount;
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
 		} else {
			System.out.println("Sorry, not enough money in the bank.");
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
