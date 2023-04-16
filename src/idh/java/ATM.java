package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int moneyATM = 1000;

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
				System.out.println("Enter your account number: ");
				int accNumber = Integer.parseInt(br.readLine());
				accountCheck(accNumber);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void accountCheck(int checkNumber) {
		if (checkNumber == 123)
			account1();
		if (checkNumber == 456)
			account2();
		if (checkNumber == 789)
			account3();
		else
			System.out.println("Sorry, this account does not exist.");
	}

	public void account1() {
		int moneyAccount = 500;

		while (true) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, moneyAccount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void account2() {
		int moneyAccount = 750;

		while (true) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, moneyAccount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void account3() {
		int moneyAccount = 900;

		while (true) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, moneyAccount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, int money) {
		if (amount <= moneyATM) {
			if (amount <= money) {
				System.out.println("Ok, here is your money, enjoy!");
				money -= amount;
				moneyATM -= amount;
			} else
				System.out.println("Sorry, there is not enough money in the bank! Go get a job...");
		} else {
			System.out.println("Sorry, there is not enough money in the ATM!");
		}
		run();
	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
};
