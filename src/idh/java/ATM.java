package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ATM {
	/*
	 *1 - das geld im automaten festgelegt
	 *2 - personen eins bis drei erstellt,
	 *mit dem jeweiligen guthaben auf dem konto 
	 *3 - pin erstellt dür die mesnchen
	 *ddie personen sollen jetzt den konten zugewiesen werden
	 */
	 
	static int ATMBalance = 1000;
	static int person1 = 400;
	static int person2 = 500;
	static int person3 = 100;
	String PinAccess1 = "1111";
	String PinAccess2 = "2222";
	String PinAccess3 = "3333"; 
	
	

	
	/*
	 * PIN FÜR ACCESS (GELD)
	 */
	
	public void askPin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Pin: ");
		while (true) {
			String input = sc.next();
			if (input.equals(PinAccess1) || input.equals(PinAccess2) || input.equals(PinAccess3)) {
				ATM.run();
			} else if (input.equals("exit")) {
				sc.close();
				System.exit(0);
			} else {
				System.out.println("Incorrect Pin, access denied");
			}
		}
	}
	
	
	/*public void askPin(String Pin) {
		PinAccess1 = "";
		if (Pin = PinAccess1) {System.out.println("Welcome person1!");
		if (Pin = PinAccess2) System.out.println("Welcome person2!");
		if (Pin = PinAccess2) System.out.println("Welcome person3!");		
		} else {
			System.out.println("Incorrect Pin");
		}
	}
	Hat nicht funktioniert und
	 war teil eines codes den ich oben umgeändert habe 
	*/
	
	/*
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	
	 public static void run() {
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
	 /* 
	  * Geld abzug von Konten und dem Total des automaten 
	  */

public static void cashout(int amount) {
	// Total
	int TotalATM = person1 + person2 + person3;
	if (amount <= TotalATM && amount <= ATMBalance) {
		//Konten
		if (amount <= person1) {
			person1 = person1 - amount;
			} else if (amount <= person1 + person2) {
				person2 = person2 - amount + person1;
			} else {
				person3 = person3 - amount + person1 + person2;
				person2 = 0;
				person1 = 0;
			}
		ATMBalance -= amount;
		System.out.print("Oke, here you go! \n");
		System.out.print("New ATM Balance: " + ATMBalance + "\n");
		} else {
			System.out.println("Sorry, you don't have enough money in the bank.");
		}
	
}
	/* if (amount < person3) {
		person3 = person3 - amount;
		System.out.println("here you go, enjoy!");
	} else {
		System.out.println("not enough balance in your account, sorry!");
	}

}; 
	
	 public void person1(int amount) {
		if (amount < person1) {
			person1 = person1 - amount;
			System.out.println("here you go, enjoy!");
		} else {
			System.out.println("Not enough balance in your account, sorry!");
		}
		
	};
	
	public void person2(int amount) {
		if (amount < person2) {
			person2 = person2 - amount;
			System.out.println("here you go, enjoy!");
		} else {
			System.out.println("Not enough balance in your account, sorry!");
		}
		
	};
	*/
	
//hallo


	/**
	 * Launches the ATM
	 */
	
	 public static void main(String[] args) {
		ATM atm = new ATM();
		atm.askPin();
	};
}