package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 100;
	int ID1 = 1;
	int ID2 = 2;
	int amount1 = 60;
	int amount2 = 67;

	/**
	 * Main command loop of the ATM Asks the user to enter an ID and checks if the ID entered is one of the numbers stored. number, and passes this
	 * Then the user is asked for an amount and the number is forwarded to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your ID: ");
				int ID = Integer.parseInt(br.readLine());
				if (checkID(ID)) {
				try {
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
					cashout(amount, ID);
				} catch (Exception e) {
					break;
 				}
				}
			} catch (Exception e) {
				break;
			}
		}
	}

	/**This function takes an integer and checks if this is equal to either ID1 oder ID2. It returns a boolean*/
	public boolean checkID(int ID) {
			if (ID == ID1|ID == ID2)
				return true;
			
			else
			{System.out.println("Wrong ID");
				return false;
			}
		}
	
	/**The function takes an integer amount and checks if this is smaller than the accountBalance, which is the total
	 * the ATM stores. If true the amount is used for the cashoutindividual function and the integer ID is used to
	 * determine which balance should be used for the cashoutoindividual function.*/
	public void cashout(int amount, int ID) {
		if (amount <= accountBalance) {
			if (ID == ID1) {
				cashoutindividual(amount, amount1);
			}
			else {
				cashoutindividual(amount, amount2);
			}
		}
		else {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
		}
	}
	
	
	public void cashoutindividual(int amount, int balanceind) {
		if (amount < balanceind) {
			accountBalance = accountBalance - amount;
			balanceind = balanceind - amount;
			System.out.println("Ok, here you go!");
		} else {
			System.out.println("Sorry, you don´t have enough money in the bank.");
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
