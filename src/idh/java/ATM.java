package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ATM {
	private Map<Integer, Integer> accountBalances; 
	private int cashBalance; 

	public ATM() {
		accountBalances = new HashMap<>();
		
		accountBalances.put(1234, 1000);
		accountBalances.put(5678, 500);
		cashBalance = 1000; 
	}

	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Geben sie ihre Kontonummer ein oder 0 um abzubrechen: ");
				int accountNumber = Integer.parseInt(br.readLine());
				if (accountNumber == 0) {
					break; 
				}
				System.out.print("Wie viel möchten sie abheben: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accountNumber, amount);
			} catch (Exception e) {
				System.out.println("Ungültige eingabe versuchen sie es bitte terneut .");
			}
		}
	}

	public void cashout(int accountNumber, int amount) {
		if (accountBalances.containsKey(accountNumber)) {
			int accountBalance = accountBalances.get(accountNumber);
			if (amount <= accountBalance) {
				if (amount <= cashBalance) {
					accountBalance -= amount;
					cashBalance -= amount;
					accountBalances.put(accountNumber, accountBalance);
					System.out.println("Kontonummer: " + accountNumber);
					System.out.println("Abgehobender Betrag : " + amount);
					System.out.println("Im Konto verblibener betrag : " + accountBalance);
					System.out.println("viel spaß mit dem Geld .");
				} else {
					System.out.println("Es ist nicht genügend bargeld im Automaten vorhaned bitten versuchen sie es später nocheinmal.");
				}
			} else {
				System.out.println("Sie haben nicht genügen Geld auf ihrem Konto .");
			}
		} else {
			System.out.println("eine Ungültige Kontonummer.");
		}
	};

	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
}
