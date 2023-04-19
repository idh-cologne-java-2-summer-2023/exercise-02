package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 100;

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

				System.out.println("Enter your account ID:");
				int accountInput = Integer.parseInt(br.readLine());
				int accountID1 = 243;
				int accountID2 = 156;
				if (accountInput == accountID1){
					int amount = 200;
				}
				else if(accountInput == accountID2){
					 int amount = 150;

				}
				else{
					System.out.println("No account by that number");
				}
					
				
			 	System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
				}
			} catch (Exception e) {
				break;
			}
		}
		}
	

	
	

	
	public void cashout(int amount) {
		if (amount < accountBalance) {
			accountBalance = accountBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
