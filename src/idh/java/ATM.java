package idh.java;

import java.io.*;

public class ATM {
	float credits = 200f;
	
	/**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks 
	 * and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			try {
				System.out.print("Enter the amount to withdraw: ");
				String line = br.readLine();
					if (line.equals("exit")) {
						System.out.println("Beenden!");
						System.exit(0);
					}
					else if (line.matches("[+-]?([0-9]*[.])?[0-9]+" )) {
						float amount = Float.parseFloat(line);
						cashout(amount);
				    }
					else {
						System.out.println("Bitte numerischen Betrag oder exit eingeben");
					}
			} catch (Exception e) {
				break;
			}
		}
	}
	
	public void cashout(float amount) {
		if (credits >= amount && amount > 0) {
			credits = credits - amount;
			System.out.println("Ausgabe von: " + amount + " credits. \nNeuer Kontostand: " + credits + " credits");
		} 
		else {
			System.out.println("Unzureichende Credits/Eingabe eines Negativen Wertes");	
	    }
			
	}
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
};
