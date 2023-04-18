package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import idh.java.Benutzerkonten;


//Bin mir leider nicht sicher wie der Fehler zu fixen ist. Ich glaube ich ahbe einen Fehler in der anlegung der Klasse Benutzerkonten
//Komme jedoch in kürze der Zeit nicht auf eine Lösung :(


public class ATM {
	int Inhalt = 20000;

	
	Benutzerkonten[] Kunde = new Benutzerkonten[3];

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
				
				System.out.print("Enter your Accountnumber: ");
				int Kontonummer = Integer.parseInt(br.readLine());
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				
				cashout(amount, Kontonummer);
			} catch (Exception e) {
				System.out.print("Test11");
				break;
			}
		}
	}

	public void cashout(int amount, int Kontonummer) {
		int x = -1;
		System.out.print("Test2");
		System.out.print(Kunde[0].getKontonummer()); //Wieso wird das nicht aufgerufen???? //Edit: liegt glaube ich an der Klassenstruktur? 
		System.out.print("Test2");
		for(int i = 0; i<=3; i++) {
			if( Kunde[i].getKontonummer() == Kontonummer) {
				x = i;
				System.out.print("Test2");
			}
		}
		if (x == -1) {
			System.out.println("This Account doesnt exist");
			return;
		}
		if (amount > Inhalt) {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
			return;
		}
		
		if (amount < Kunde[x].getGuthaben()) {
			Kunde[x].abheben(amount);
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		
		Benutzerkonten[] Kunde = new Benutzerkonten[3];
		Kunde[0] = new Benutzerkonten(123, 500);
		Kunde[1] = new Benutzerkonten(234, 800);
		Kunde[2] = new Benutzerkonten(345, 2000);
		
		ATM atm = new ATM();
		atm.run();
	};

}
