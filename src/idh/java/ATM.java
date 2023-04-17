package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 100;
	 private Account[] accounts;
	    private int cashInATM;

	    public ATM(Account[] accounts, int cashInATM) {
	        this.accounts = accounts;
	        this.cashInATM = cashInATM;
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
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());
				Account account = findAccount(accountNumber);
				if (account == null) {
					System.out.println("Invalid account number.");
					continue;
				}
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	}
	
	private Account findAccount(int accountNumber) {
		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return null;
	}

	public void cashout(Account account, int amount) {
		if (amount < account.getAccountBalance()) {
			if (amount < cashInATM) {
				account.setAccountBalance(account.getAccountBalance() - amount);
				cashInATM -= amount;
				System.out.println("Okay.");
			} else {
				System.out.println("Sorry, not enough money in the bank.");
			}
		} else {
			System.out.println("Sorry, you don't have enough money.");
		}

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM (accounts);
		atm.run();
	};
	Account[] accounts = new Account[] {};
	
	class Account {
	    private int accountNumber;
	    private int accountBalance;

	    public Account(int accountNumber, int accountBalance) {
	        this.accountNumber = accountNumber;
	        this.accountBalance = accountBalance;
	    }

	    public int getAccountNumber() {
	        return accountNumber;
	    }

	    public int getAccountBalance() {
	        return accountBalance;
	    }

	    public void setAccountBalance(int accountBalance) {
	        this.accountBalance = accountBalance;
	    }

	}
}
