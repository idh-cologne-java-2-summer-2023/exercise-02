package idh.java;

import java.util.Random;

public class Account {
	private int accountNumber;
	private int accountBalance;

	Random rand = new Random();

	public Account(int accountNumber) {
		setAccountNumber(accountNumber);
		setAccountBalance(rand.nextInt(3600));
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int number) {
		this.accountNumber = number;
	}

}
