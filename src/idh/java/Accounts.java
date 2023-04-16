package idh.java;

public class Accounts {
	
	private int accountNumber;
	private int accountBalance;
	
	public Accounts (int accountNumber,int accountBalance) {
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	
}
