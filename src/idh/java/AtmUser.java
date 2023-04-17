package idh.java;

import java.util.Random;

public class AtmUser extends ATM {
	protected int accountnumber;
	protected int accountBalance;
	private static int counter = 0;
	
	public AtmUser() {
		this.accountnumber = ++counter;
		Random random = new Random();
		this.accountBalance = random.nextInt(991) + 10;
		
	}
	/**
	 * this method checks if the asked amount of money is available on a specific asked account
	 * if so it passes the amount to the method checkATMvolume of the superclass ATM
	 * there will be checked if the ATMbalance is higher than the amount
	 * @param amount
	 */
	
	public void cashout(int amount) {
		
		if (amount <= this.accountBalance) {
			this.accountBalance = this.accountBalance - amount;
			super.checkATMvolume(amount);
		} else {
			System.out.println("Sorry, you do not have enough money in the bank.");
		}

	}


}
