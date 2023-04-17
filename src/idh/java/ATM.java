package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class ATM {
	int atmblc = 230;
	int[] arr = {2000, 100, 2432, 323423, 1};
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter the account number 1-5: ");
				int useracc = Integer.parseInt(br.readLine());
				//check if account number is valid return balance for set account
				int idamount = usernmbr(useracc);
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				//check if account balance and atm cash balance is larger then withdraw amount
				int blcaftercashout = cashout(amount, idamount);
				//update array with new balance
				Array.set(arr, useracc-1, blcaftercashout);
			    System.out.println("new account balance: " + blcaftercashout + "\ncash left in atm: " + atmblc);
			} catch (Exception e) {
				break;
			}
		}
	}

	public int cashout(int amount, int idamount) {
		if (amount < idamount & amount < atmblc) {
		 	int aftdeductioin = idamount - amount;
		    atmblc = atmblc - amount;
			System.out.println("Ok, here is your money, enjoy!");
			return aftdeductioin;
		} else {
			if (amount<idamount) {
				System.out.println("no cash in atm try other time");
				return idamount;
			}
			else {
			System.out.println("Sorry, not enough money in the bank.");
			return idamount;
			}
		}
	}
	public int usernmbr(int usracc) {
		try {
			int wamount = arr[usracc - 1];
	        Array.set(arr, usracc - 1, wamount);
			return wamount;
		}catch(Exception e) {
			System.out.println("this account number deos not exist");
			run();
		}
		return 0;
		
	}
	
	;

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
