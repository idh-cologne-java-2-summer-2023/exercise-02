package idh.java;

import java.util.Random;

public class AtmUser {
	protected int accountnumber;
	protected int accountBalance;
	private static int counter = 0;
	
	public AtmUser() {
		accountnumber = ++counter;
		Random random = new Random();
		accountBalance = random.nextInt(991) + 10;
		
	}
	
	public void cashout(int amount) {
		
		if (amount <= this.accountBalance) {
			this.accountBalance = this.accountBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}

	}


}
