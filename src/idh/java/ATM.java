package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ATM {
	// AccountBalance von jeder ID
	static int accountBalance1 = 100;
	static int accountBalance2 = 7100;
	static int accountBalance3 = 90;
	
    //ATM balance 
	static int ATMbalance = 5000;
	
    // Account Id
	String accountnr1 = "9543";
	String accountnr2 = "6432";
	String accountnr3 = "8172";
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	
	//Überprüfung der I
	public void begin() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your account Id: ");
		
		 while (true) {

	            String input = sc.next();

	            if (input.equals(accountnr1) || input.equals(accountnr2) || input.equals(accountnr3)) {
	                ATM atm = new ATM();
					atm.run();
	            } else if (input.equals("exit")) {
	                sc.close();
	                System.exit(0);
	            } else {
	                System.out.println("Access is denied");

	            }
	        }
	    }



		
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	// neuer Betrag auf dem ATM und auf den Konten
	public void cashout(int amount) {
		int totalAccountBalance = accountBalance1 + accountBalance2 + accountBalance3;
        if (amount <= totalAccountBalance && amount <= ATMbalance) {
        	
        	// Das Geld wird von jedem Konto abgezogen
        	 if (amount <= accountBalance1) {
                 accountBalance1 = accountBalance1 - amount;
             } else if (amount <= accountBalance1 + accountBalance2) {
                 accountBalance2 = accountBalance2 - amount + accountBalance1;
                 accountBalance1 = 0;
             } else {
                 accountBalance3 = accountBalance3 - amount + accountBalance1 + accountBalance2;
                 accountBalance1 = 0;
                 accountBalance2 = 0;
             }
	
        }
		
     // Automatenbestand aktualisieren
      if( ATMbalance >= amount) {
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.begin();
	};

}
