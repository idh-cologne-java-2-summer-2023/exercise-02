package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	public static AtmUser[] users = new AtmUser[15];
	public static int ATMbalance = 5000;
		 

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
				System.out.println("Enter your account number");
				int accnb = Integer.parseInt(br.readLine());
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				checkNumber(accnb, amount);
				// cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	}
	
	public void checkNumber(int accnb, int amount) {
		for (int i = 0; i < users.length; i++) {
			if (users[i].accountnumber == accnb) {
				users[i].cashout(amount);
			}
		}
	}
	
	public void checkATMvolume(int amount) {
		if (amount <= ATMbalance) {
			ATMbalance = ATMbalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		}
		else
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
	}
	
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		for (int i = 0; i < users.length; i++)
			users[i] = new AtmUser();
		// for (int i = 0; i < users.length; i++)
		//	System.out.println(users[i].accountnumber);
		
		ATM atm = new ATM();
		atm.run();
		
	};

}
