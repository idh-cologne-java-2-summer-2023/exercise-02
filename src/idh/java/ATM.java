package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {

	int[] accounts = new int[500];
	int atmbalance = 100;
	
	
	public void accountmanager(){
		for(int i=0;i<500;i++) {
			accounts[i] = (int) (Math.random()*(1000));	
		}	
	}
	
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		accountmanager();
		while(true) {
			try {
				System.out.print("Please enter your account number:");
				int number = Integer.parseInt(br.readLine());
			if (number<=accounts.length) {
				System.out.println("Your current balance is " + accounts[number] + "€");
				System.out.print("Please enter the amount you would like to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount,number);
				}
			else {System.out.println("Sorry, we don't have an Account with this number. Please try again.");
				}
			} catch (Exception e) {
				break;
			}
		}
	}
	public void cashout(int amount,int number) {
		int accbalance = accounts[number];
		if (accbalance >= amount && atmbalance>=amount) {	
			System.out.println("Ok, here is your money, enjoy!");
			int newaccbalance = accbalance-amount;
			accbalance = newaccbalance;
			int newatmbalance = atmbalance - amount;
			atmbalance = newatmbalance;
			System.out.println("Your new balance is "+ accbalance + "€");
			accounts[number]=newaccbalance;
			
		}
		else if(atmbalance<amount){
			System.out.println("Sorry, the ATM seems to has run out of money. Please contact our Service Hotline.");
		}
		else if(accbalance<amount) {
			System.out.println("Sorry, there is not enough money in your bank account.");
		}
	};
	
	/**
	 * Launches the ATM
	 */
	
	public static void main(String[] args) {
		
		ATM atm = new ATM();
		atm.run();
	};
};


