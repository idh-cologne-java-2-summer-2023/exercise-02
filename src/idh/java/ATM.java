package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class ATM {
	int accountBalance = 100;
	Scanner sc = new Scanner(System.in);
	
	//ATM accounts
		Account[] accounts = new Account[4];
		
		public ATM() {
			//creates different accounts
			Random random = new Random();
			for (int i = 0; i < accounts.length; i++) {
				accounts[i] = new Account(i, random.nextInt(1000));
			}
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
				System.out.println("Enter your account number:");
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
		
		//check if there's cash in the ATM
		if (amount > accountBalance) {
			System.out.println("Sorry, not enough cash.");
			return;
		}
		
		//check account number
		Account account = getAccount(accountNumber);
		if (account == null) {
			System.out.println("This account doesn't exist.");
			return;
		}
		
		//check account balance
		if (account.getCurrentBalance() >= amount) {
					
					//the account is balanced, money can be removed 
					account.withdraw(amount);
					accountBalance += amount;
					System.out.println("Ok, here is your money, enjoy!");
					System.out.println("Your new balance is " + account.currentBalance);
				} 
				else {
					//show error message if there's not enough money
					System.out.println("Sorry, not enough money in the bank.");
				}
				System.out.println("");
	};
	

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
	
	protected Account getAccount(int accountNumber) {
		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber)
					return account;
		}
		return null;
	}

}
