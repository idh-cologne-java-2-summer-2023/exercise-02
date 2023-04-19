package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int atmBalance = 200;
	User[] accounts = new User[1000];
	int[] accIDs = new int[1000];
	int accountCounter = 0;

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
//				System.out.println("Enter your account ID: ");
//				int ID = Integer.parseInt(br.readLine());
//				User temp = new User(ID);
//				if(temp.getAccID()==ID) {
//					
//				}
				System.out.println("Enter your account ID: ");
				int ID = Integer.parseInt(br.readLine());
				for (int i = 0; i < accIDs.length; i++) {
					if (ID == accIDs[i]) {
						System.out.println(accounts[i].getAccID());
						System.out.println(accounts[i].getAccBalance());
						System.out.print("Enter the amount to withdraw: ");
						int amount = Integer.parseInt(br.readLine());
						cashout(amount, accounts[i]);
						break;
					}
					if (ID != accIDs[i]) {
						accIDs[accountCounter] = ID;
						accounts[accountCounter] = new User(ID);
						System.out.println(accounts[accountCounter].getAccBalance());
						System.out.println(accounts[accountCounter].getAccID());
						System.out.print("Enter the amount to withdraw: ");
						int amount = Integer.parseInt(br.readLine());
						cashout(amount, accounts[accountCounter]);
						accountCounter++;
						break;
					}

				}
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, User acc) {

		if (amount > acc.getAccBalance()) {
			System.out.println(
					"Sorry, not enough money in your account. Your current balance is: " + acc.getAccBalance());
		}
		if (amount > atmBalance) {
			System.out.println("Sorry, not enough money in the ATM.");
		}
		if (amount <= acc.getAccBalance() && atmBalance > amount) {
			acc.setAccBalance(acc.getAccBalance() - amount);
			atmBalance -= amount;
			System.out.println("Ok, here is your money, enjoy!");
		}

	}

	public boolean checkID(int ID) {
		for (int i = 0; i < accIDs.length; i++) {
			if (ID == accIDs[i]) {
				return true;
			}
		}
		return true;
	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
