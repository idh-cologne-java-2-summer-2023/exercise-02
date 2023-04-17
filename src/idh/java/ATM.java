package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	public static AtmUser[] users = new AtmUser[15];
	public static int ATMbalance = 5000;
		 

	/**
	 * Main command loop of the ATM Asks the user to enter an accountnumber and an amount, and passes this
	 * number to the function checkNumber(...) If the user enters anything else than an integer number, the
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
	/**
	 * compares the entered accountnumber to the accountnumbers of the users-array
	 * if accountnumber exists in the array the method passes the amount to a method of the class AtmUsers,
	 * that checks if the asked amount is available on the specific account
	 * @param accnb
	 * @param amount
	 */
	public void checkNumber(int accnb, int amount) {
		for (int i = 0; i < users.length; i++) {
			if (users[i].accountnumber == accnb) {
				users[i].cashout(amount);
			}
		}
	}
	
	/**
	 * checks if the ATMbalance is higher than the asked amount
	 * @param amount
	 */
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
