package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int atmBalance = 200;
	Customer[] custList = new Customer[10];
	int usedCustomerIndex;
	int currentBalance;

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
				int accNum = Integer.parseInt(br.readLine());
				
//				check for AccNum
				if(accNumCheck(accNum) == false){
				
					System.out.println("Enter your balance: ");
					int accountBalance = Integer.parseInt(br.readLine());
					custList[usedCustomerIndex] = new Customer(accNum, accountBalance);
					currentBalance = custList[usedCustomerIndex].getBalance();
				}
				
				System.out.println("Balance: " + currentBalance);
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount) {
		if (amount < currentBalance && amount < atmBalance) {
			currentBalance = currentBalance - amount;
			atmBalance = atmBalance - amount;
			custList[usedCustomerIndex].setBalance(currentBalance);
			
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}

	};
	
	/**
	 * Checks if AccNum is already in system.
	 */
	public boolean accNumCheck(int accNum) {
		boolean b = false;
		for(int i = 0; i < custList.length; i++) {
			if(custList[i] == null) {
				usedCustomerIndex = i;
				return b;
				}
			else {
				if(custList[i].getBankAccount() == accNum) {
				b = true;
				currentBalance = custList[i].getBalance();
				usedCustomerIndex = i;
				}
			}
		}return b;
	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
