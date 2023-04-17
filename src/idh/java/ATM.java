package idh.java;

import java.io.*;

public class ATM {
	float credits = 200000f;		//Im ATM vorhandenes Geld
	
	/**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks 
	 * and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		Accounts accs[] = new Accounts[3];
		 accs[0] = new Accounts(123);
		 accs[1] = new Accounts(234);
		 accs[2] = new Accounts(345);
		
		while(true) {
			try {
				System.out.println("Vorhandenes Bargeld: " + credits);
				System.out.print("Enter your account number: ");
				String line0 = br.readLine();
				int accNum = Integer.parseInt(line0);
				
				 				
				System.out.print("Enter the amount to withdraw: ");
				String line = br.readLine();
					if (line.equals("exit")) {
						System.out.println("Beenden!");
						System.exit(0);
					}
					else if (line.matches("[+-]?([0-9]*[.])?[0-9]+" )) {
						float amount = Float.parseFloat(line);
						cashout(amount, accNum, accs);
				    }
					else {
						System.out.println("Bitte numerischen Betrag oder exit eingeben");
					}
			} catch (Exception e) {
				break;
			}
		}
	}
	
	public void cashout(float amount, int accNum, Accounts[] accs) {
			if (credits < amount) {
				System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
			}
			else {
				for (int i = 0; i < accs.length; i++) {
					if (accs[i].accNum == accNum && accs[i].guthaben >= amount && credits >= amount) {
						accs[i].guthaben = accs[i].guthaben - amount;
						credits = credits - amount;
						System.out.println("Ok, here you go!");
						System.out.println("Restliches Guthaben von Konto: " + accs[i].accNum + " ist: " + accs[i].guthaben );
					}
					else if (accs[i].accNum == accNum && accs[i].guthaben < amount){
						System.out.println("Sorry, you don't have enough money in the bank.");
						System.out.println("Restliches Guthaben für Konto: " + accs[i].accNum + " ist: " + accs[i].guthaben );
					}
				}      
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
