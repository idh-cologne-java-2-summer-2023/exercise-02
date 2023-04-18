package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ATM {
	Map<String, Integer> accountBalance = new HashMap<>();

	/**
	 * Main command loop of the ATM Asks the user to enter their account number and
	 * the amount they wish to withdraw. Passes this information to the function
	 * cashout(...) which actually does the calculation and produces money. If the
	 * user enters anything else than an integer number, the loop breaks and the
	 * program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				String accountNumber = br.readLine();
				Integer balance = accountBalance.get(accountNumber);
				if (balance == null) {
					balance = 100; // default account balance
					accountBalance.put(accountNumber, balance);
				}
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accountNumber, amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(String accountNumber, int amount) {
		Integer balance = accountBalance.get(accountNumber);
		if (balance != null && amount <= balance) {
			accountBalance.put(accountNumber, balance - amount);
			System.out.println("Ok, here is your money, you still have "+balance+" $");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}

	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	}

}

