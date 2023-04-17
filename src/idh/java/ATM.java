package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int atmBalance = 1000;
	int[] accountBalances = {100,200,300};
	int i;
	
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
				int number = Integer.parseInt(br.readLine());
				if (number == 123){
					i=1;}
				if (number == 234){
					i=2;}
				if (number == 345){
					i=3;}
				if(i!=0) {
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
		if(amount > atmBalance) {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
			i=0;
		}
		else if (amount < accountBalances[i]) {
			accountBalances[i] = accountBalances[i] - amount;
			atmBalance -= amount;
			System.out.println("Ok, here is your money, enjoy!");
			i=0;
		} else {
			System.out.println("Sorry, not enough money in the bank.");
			i=0;
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
