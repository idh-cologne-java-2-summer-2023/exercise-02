package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int cashInAtm = 5000;
	static Account currentAccount;
	
	static Account a1 = new Account(1001, 500);
	static Account a2 = new Account(1002, 1000);
	static Account a3 = new Account(1003, 100);
	static Account a4 = new Account(1004, 10000);
	static Account a5 = new Account(1005, 23);
	
	static Account[] accountArray = new Account[] {a1, a2, a3, a4, a5};

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
				if 
				(checkAccountNumber(accountArray, accountNumber) == true) {
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					cashout(amount, currentAccount);
				} else {
					System.out.println("No Account found.");
				}
				;
				
				
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout (int amount, Account currentAccount) {
		if (amount <= cashInAtm) {
			if (amount <= currentAccount.accountBalance) {
				currentAccount.accountBalance = currentAccount.accountBalance - amount;
				cashInAtm = cashInAtm - amount;
				System.out.println("Ok, here you go!");
			} else {
				System.out.println("Sorry, you don't have enough money in the bank.");
			}
		} else {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore:");
		}
	}
	
	public static boolean checkAccountNumber (Account [] accountArray, int accountNumber) {
		boolean b = false;
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i].accountNumber == accountNumber) {
				b = true;
				currentAccount = accountArray[i];
				break;
			} else b = false;
		}
		return b;
	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
		
	}
	;
}
