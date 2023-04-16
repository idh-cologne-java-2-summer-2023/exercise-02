package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class ATM {
	int atmBalance = 1000;
	LinkedList<ATMUser> knownUsers = new LinkedList<ATMUser>();


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
				int kontoId = Integer.parseInt(br.readLine());
				ATMUser kunde = null;
				ListIterator<ATMUser> iterator = knownUsers.listIterator();
				while(iterator.hasNext()) {
					ATMUser temp = iterator.next();
					if(temp.getUserID() == kontoId) {
						kunde = temp;
						break;
					}
				}
				if(kunde ==null) {
					kunde = new ATMUser(kontoId);
					knownUsers.add(kunde);
				}
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, kunde);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, ATMUser kunde) {
		if (amount <= kunde.getUserBalance() && amount <= atmBalance) {
			kunde.setUserBalance(kunde.getUserBalance() - amount);
			atmBalance = atmBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else if(amount > kunde.getUserBalance()){
			System.out.println("Sorry, you don't have enough money in the bank.");
		} else {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
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
