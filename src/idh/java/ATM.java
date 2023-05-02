package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;




public class ATM {
	private Map<Integer, Integer> accountBalances; // Map speichert Kontonummer und Konstostand
	private int cashAvailable; // wie viel geld der Automat noch hat

	public ATM() {
		accountBalances = new HashMap<>();
		cashAvailable = 3000; // Automat hat am Anfang 3000€
	}


	
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());  //accountnumber=Kontonummer
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());  //amount= wie viel ausgezahlt wird
				cashout(accountNumber, amount);
			} catch (Exception e) {
				break;
			}
		}
	}
	
	
	

	public void cashout(int accountNumber, int amount) {
		if (accountBalances.containsKey(accountNumber)) { // Kontonummer gültig?
			int accountBalance = accountBalances.get(accountNumber); // Kontostand des Benutzers abrufen
			
		if (amount <= accountBalance && amount <= cashAvailable) {//genug Geld auf dem Konto und im Automaten?
			accountBalance = accountBalance - amount; // Kontostand aktualisieren
			cashAvailable = cashAvailable - amount; // Bargeldbestand des Automaten aktualisieren wie viel bleibt übrig
			accountBalances.put(accountNumber, accountBalance); // Kontostand speichern, damit der gleich sagen kann wie viel
			System.out.println("Ok, here is your money! Voila" + amount + "! enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}
		}else {
			System.out.println("Transaction failed. Invalid account number.");
		}
		}
	
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
