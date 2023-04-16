package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class ATM {
	
	int ATMCash = 10000;
    static int[] account = new int[100];
    
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {  // asks for both account number and amount of cash to withdraw
				System.out.print("Please enter your account number: ");
				int accNumber = Integer.parseInt(br.readLine());
				System.out.println("Your Account Balance is: " + account[accNumber] + "€");
				System.out.print("Please enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, accNumber);
				}
		catch (Exception e) {
				break;
			}
		}
}

	public void cashout(int amount, int accNumber) {
		if (amount <= account[accNumber] && amount <= ATMCash) { //checks, if both the account and ATM have enough money
			account[accNumber] = account[accNumber] - amount;
			ATMCash = ATMCash - amount;
			System.out.println("Ok, here is your money, enjoy!");
			System.out.println("You have " + account[accNumber] + "€ left in your account.");
		} 
		else if(amount > account[accNumber]) {  //when the account doesn't have enough money
			System.out.println("Sorry, there isn't enough money in your account.");
		}
		else if(ATMCash == 0) {
			System.out.println("Sorry, the ATM is empty, try another time.");
		}
		else if(amount > ATMCash) { //when the ATM doesn't have enough cash
			System.out.println("Sorry, the ATM doesn't have that much cash left.");
			System.out.println("There are only " + ATMCash + "€ left in the ATM.");
			emptyATM(accNumber);
			}
	};

	public void emptyATM(int accNumber) {
		String answ = null;
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Do you want to withdraw " + ATMCash + "€? y/n");
		try {
		 answ = b.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(answ.contains("y") == true) {
			account[accNumber] = account[accNumber] - ATMCash;
			ATMCash = 0;
			System.out.println("Here is your money, enjoy.");
		}
		else if(answ.contains("n") == true) {
			System.out.println("Ok, have a nice day.");
		}
		else {
			System.out.println("Invalid answer, try again.");
			emptyATM(accNumber);
		}
		
	}
	
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		for(int i = 0; i < account.length; i++) {
			account[i] = (int)(Math.random()*5000) + 1;
		}
		ATM atm = new ATM();
		atm.run();
	};

}
