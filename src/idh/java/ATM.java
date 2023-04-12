package b;

import java.io.*;

public class ATM {

	/**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function
	 * cashout(...)
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks
	 * and the program exists
	 */

	double Kontostand = 100;

	public void Kontonummer() {
		int number = 0;

	}

	Kontonummer kontonummer = new Kontonummer();

	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your bank ID: ");

				System.out.print("Enter the amount to withdraw: ");
				double amount = Double.parseDouble(br.readLine()); // das gleiche nur mit double, um Kommazahlen
																	// darzustellen
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(double amount) {
		String amountString = Double.toString(amount);
		if (Kontostand - amount >= 0 && amountString.matches("^\\d+(\\.\\d{1,2})?$")) {

			/*
			 * \d+ -> Übereinstimmung mit einer oder mehrerer Ziffern, in dem Fall Positive
			 * Dezimalzahl
			 * (\.\d{1,2})? -> Optionale Gruppe. Zahl kann einen Punkt mit 1 oder 2
			 * Nachkommastellen haben.
			 * ? -> Optionale Gruppe.
			 * $ -> beendet
			 */

			// TODO: Math.abs(amount - Math.floor(amount)) > 0.01 || amount == (int)amount)
			// {

			// amount = Math.abs(amount); // sorgt dafür, dass der ausgegebene Betrag immer
			// positiv ist, ist aber anscheinend überflüssig, wegen des "d+" von oben aus
			// der if-Bedingung
			Kontostand = Kontostand - amount;
			System.out.println("You withdrawed " + amount + ". Your account balance is now " + Kontostand + "€");
		} else
			System.out.println("This action does not work. Your account balance is " + Kontostand + "€"); // sollte
																											// dieser
																											// Teil in
																											// die
																											// Exception?

	}

	// Launches the ATM
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	}
}
