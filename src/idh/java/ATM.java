package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ATM {
	
	static Accounts account = new Accounts();
	CashStroage atmBalace = new CashStroage();

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
				System.out.print("Enter the account number: ");
				int accNumber = Integer.parseInt(br.readLine());
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount,accNumber);
			} catch (Exception e) {
				break;
			}
			
		}
	}

	public void cashout(int amount, int accNumber) throws Exception {
		
		if (atmBalace.get() > amount) {
		
			if (amount < account.getAcc(accNumber)) {
				account.setAccValue(accNumber, amount);
				
				System.out.println("Your new balance is: " + account.getAcc(accNumber));
				System.out.println("Ok, here is your money, enjoy!");
				
			} else {
				System.out.println("Sorry, not enough money in the bank.");
			}
			
		} else {
			
			System.err.println("Sorry, not enough money in the machine.");
			
		}
	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		account.run(123);
		ATM atm = new ATM();
		atm.run();
	};

}
