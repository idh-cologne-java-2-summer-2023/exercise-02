package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import idh.java.User;

public class ATM {
	int atmbalance = 2000;
	User u1 = new User(123, 1000);
	User u2 = new User(234, 1200);
    User[] userarray ={u1, u2};
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
				int kontonummer = Integer.parseInt(br.readLine());
				for(int i = 0; i < userarray.length; i++) {
					if(userarray[i].getKontonummer() == kontonummer) {
					System.out.println("Logged in!");
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					cashout(amount, userarray[i]);
					}
				}
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, User user) {
		if (amount <= user.getGeld()) {
			if(amount <= atmbalance) {
			user.setGeld(user.getGeld() - amount);
			atmbalance = atmbalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
			System.err.println("Dir bleiben " + user.getGeld());
			}else {
				System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
			}
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
