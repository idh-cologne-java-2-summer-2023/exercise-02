package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*Aktueller Stand. Die Idee Objekte zu verwenden ist mir erst sehr spät gekommen. 
 * Aktuell funktioniert es einmal, allerdings habe ich die AccountBalances hartgecodet. Dadurch resetten sie sich jedes mal auf 100 bzw. 200.
 * Dies ließe sich mit Hilfe von den unten erstellen Account-Objekten lösen.  
 */
public class ATM {

	public int accountNumber;
	public int accountBalance;

	public int getAccountBalance() {
		return accountBalance;
	}
	
	public int setAccountBalance() {
	
		 this.accountBalance= this.accountBalance - amount;
		 return this.accountBalance;
	}
	
	private int amount;

	public int getAmount() {
	    return amount;
	}

	//oder die Bankaccounts als Objekte anlegen und dann den startwert anlegen
	
	int atmBalance = 250; 
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	
	/*
	 * Ursprüngliche Funktion run wurde in giveMoney umgebaut. Run ist nun der Startpunkt und fragt nach der Kontonummer
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	
		while (true) {
		try {
		System.out.print("Pleaser enter your Account Number: ");
	int accountNumber = Integer.parseInt(br.readLine());
	getAccountNumber(accountNumber);
	
	} catch (Exception e) {
		break;
	}
		}
	}
	
	//Auswertung der eingegebenen Kontonummer
	public int getAccountNumber(int accountNumber) {
		//System.out.println("You are now logged in with account number " + accountNumber + ".");
		
	if (accountNumber == 1) {
		
		accountBalance = 100;
		System.out.println("Your current balance for Account Number " + accountNumber +  " is " + accountBalance + ".");
		accountNumber = 1;
		withdrawMoney(accountNumber);
		return accountNumber;
		
	}
	else if (accountNumber == 2) {
		accountBalance = 200;
		System.out.println("Your current balance for Account Number " + accountNumber +  " is " + accountBalance + ".");
		accountNumber = 2;
		withdrawMoney(accountNumber);
		return accountNumber;
	}
	else if (accountNumber != 1 || accountNumber != 2) 
		System.out.println("This account Number does not exist.");
		return accountNumber = 0;
	}

	public int withdrawMoney(int choosenAccount) {
		//choosenAccount = accountNumber;
BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
System.out.print("Enter the amount to withdraw: ");
		
		while (true) {
			try {
			int amount = Integer.parseInt(br2.readLine());
				cashout(amount);
				return amount;
				
			} catch (Exception e) {
				System.out.println("Wrong input! System shutdown");
				System.exit(0);
			}
			}
		}

	public int cashout(int amount) {
		if (this.accountBalance >= amount) {
		
			this.accountBalance -= amount;
			System.out.println("Your new balance is " + this.accountBalance + ".");
			System.out.println("Ok, here is your money, enjoy!");
			
			ATMchecker(amount);

			return accountBalance;
			
		} else if(this.accountBalance < amount){
			System.out.println("You have not enough money!");
			return accountBalance;

		}else 
		
			System.out.println("Sorry, not enough money in the bank.");
	
			return this.accountBalance;
		}
			

		
	
	public void ATMchecker (int amount) {
		atmBalance = atmBalance - amount; //Zieht das Geld auch vom ATMBalance ab
		System.out.println("ATM-Balance = " + atmBalance);

		
	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
		
		Account Acc1 = new Account(1, 100);
		Account Acc2 = new Account(2, 200);
	}

}