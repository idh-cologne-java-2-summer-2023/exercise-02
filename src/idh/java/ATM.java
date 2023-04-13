package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {

	Account user = new Account();
	Cash cashATM = new Cash();
	
	int accountBalance;
	int credit;

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) 
		{
			try 
			{	System.out.println("Enter your account number:");
				int accountN = Integer.parseInt(br.readLine());
				createAccount(accountN);
				
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) 
			{
				break;
			}
		}
	}
	
	public void createAccount (int accountN) {
		if (accountN != user.getAccount()) {
			user.setAccountN(accountN);
			user.setBalance(200);
		}
		
	}
	
	public void cashout(int amount) 
	{ 
		accountBalance = user.getBalance();
		credit = cashATM.getCredit();
		
		if (amount > credit) {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
		}
		else if (amount < accountBalance ) 
		{
			user.setBalance(accountBalance - amount);
			cashATM.setCredit(credit - amount);
			System.out.println("Ok, here you go!");
		} else 
		{
			System.out.println("Sorry, you do not enough money in the bank.");
		}

	};


	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) 
	{
		ATM atm = new ATM();
		atm.run();
	};
}
