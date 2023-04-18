package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int atmcash = 700;
	
	Accounts a1 = new Accounts(123, 1000);
	Accounts a2 = new Accounts(234, 400);
	Accounts a3 = new Accounts(345, 800);
	Accounts[] account = {a1,a2,a3};
	

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
				//starts the search if the account exists
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());
				int accountFound = 0;
				int accountID = 0;
				while (accountFound == 0) {
					for (int i = 0; i < account.length; i++) {
						if (account[i].getAccountNumber() == accountNumber) {
							accountFound = 1;
							accountID = i;
							}						
					}
					if ( accountFound == 0) {
						accountFound = 2;
					}
					
				}
				
				//switch to control whether money can be payed out
				switch (accountFound) {
				case 1:
					System.out.println("Account found!");
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					cashout(amount,account[accountID]);
					break;
				case 2:
					System.out.println("Account not found!");
					break;
				}				
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, Accounts account) {
		//checks if there is enough money in the ATM and the bank account
		int enoughCash = 0;
		if (amount > account.getAccountBalance()) {
			enoughCash = 1; 
			}
		if (amount > atmcash) {
			enoughCash = 2;
		}
		
		//switch which decides what to do
		switch (enoughCash) {
		case 0:
			atmcash = atmcash - amount;
			account.setAccountBalance(account.getAccountBalance() - amount);
			System.out.println("Ok, here is your money, enjoy!");
			System.out.println(amount + "€ paid out! Your new account balancec is " + account.getAccountBalance() + "€.");
			System.out.println("The ATM has only " + atmcash + "€ left!");
			break;
		case 1:
			System.out.println("Sorry, you don't have enough money in the bank.");
			System.out.println("Your balance is " + account.getAccountBalance() + "€.");
			break;
		case 2:
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
			System.out.println("There is only " + atmcash +"€ avaible from the ATM!");
			break;
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
