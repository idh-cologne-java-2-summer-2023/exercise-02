package idh.java;

/**
 * Account
 */
public class Account {

	private int accountBalance;
	private int accountNumber;

	Account(int accountNumber, int accountBalance) {
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void cashout(int amount) {
		if (amount < accountBalance) {
			accountBalance = accountBalance - amount;
			System.out.println("Ok, here you go!");
		} else {
			System.out.println("Sorry, you don't have enough money in the bank.");
		}
	};
}
