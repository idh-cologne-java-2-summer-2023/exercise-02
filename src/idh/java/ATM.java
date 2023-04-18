package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance ;
	int fullamountonbank= 1000;
	BankCustomers customers= new BankCustomers();

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	
		/* new Integer(Integer.parseInt(s, radix))
		s - the string to be parsed.
		radix - the radix to be used in interpreting s
		an Integer object holding the value represented by the string argument in the specified radix.
		NumberFormatException - if the String does not contain a parsable int.
		*/
		
		while (true) {
			try {
				System.out.println("Enter your account number:");
				int accountnumberinput= Integer.parseInt(br.readLine());
				customers.accounts( accountnumberinput);
				customers.code();
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
				
			}
		}
	}
	
	
	

	public void cashout(int amount) {
		
		
 accountBalance= customers.cashonbank;
 
	
			
		if (amount <= accountBalance) {
			
			System.out.println("Ok, here is your money, enjoy!");
			accountBalance= accountBalance-amount;
		}
		else if (amount>fullamountonbank) {
			System.out.println("Sorry, there is not enough Money in the Bank.");
		}
		
		else if (amount>accountBalance){
			System.out.println("Sorry,you don´t have enough money on your account.");
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
