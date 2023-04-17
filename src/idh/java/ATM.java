package b;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ATM {
	List<Bankaccount> bankaccounts = new ArrayList<>();
	amountATM atmFortune = new amountATM(1000);
	public class amountATM {
		double cashATM = 0;
		public amountATM(double cashATM) {
			this.cashATM = cashATM;
		}

		public double getCashATM() {
			return cashATM;
		}

		public void setCashATM(double cashATM) {
            this.cashATM = cashATM;
        }
	}

	public class Bankaccount {
		double balance = 0;
		public Bankaccount(double balance, Account account) {
			this.balance = balance;
			this.account = account;
		}

		Account account;

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
            this.balance = balance;
        }
	}

	// double hundert = 100; // TODO: zum Objekt machen

	public class Account {

		int id;

		public Account(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}
	}

	public void runID() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your bank's ID: ");
				String input = reader.readLine();
				int id = Integer.parseInt(input); //int ID = das was eingegeben wurde in int
				if (input.matches("\\d+")) {

					Bankaccount currentBankaccount = null;

					boolean accountExists = false;
					for (Bankaccount bankaccount : bankaccounts) {
						if (bankaccount.account.id == id) {
							accountExists = true;
							currentBankaccount = bankaccount;
							break;
						}
					}
					if (!accountExists) {
						Account account = new Account(id);
						Bankaccount bankaccount = new Bankaccount(100, account); //hier muss Bankaccount ( getID(), 100) stehen und Bankaccount muss mit Account zu einer einzigen Methode zusammengeführt werden
						bankaccounts.add(bankaccount);
						currentBankaccount = bankaccount;
					}

					System.out.println("Your bank's ID is: " + currentBankaccount.account.getId() + " and your balance is "
							+ currentBankaccount.getBalance() + "€");
					withdraw(currentBankaccount, atmFortune);
				}
			} catch (Exception e) {
				System.out.println("This ID doesn't exist.");
				break;
			}
		}

	}

	public void withdraw(Bankaccount bankaccount, amountATM atmFortune) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter the amount to withdraw: ");
				double amount = Double.parseDouble(br.readLine()); // das gleiche nur mit double, um Kommazahlen darzustellen
				cashout(amount, bankaccount, atmFortune); //kommt cashATM hier rein?
				runID();
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(double amount, Bankaccount bankaccount, amountATM atmFortune) {
		String amountString = Double.toString(amount);
		double moneymoney = bankaccount.getBalance();
		double cashMoney = atmFortune.getCashATM();
		if (moneymoney - amount >= 0 && cashMoney - amount >= 0 && amountString.matches("^\\d+(\\.\\d{1,2})?$")) {

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
			moneymoney = moneymoney - amount;
			cashMoney = cashMoney - amount;
			System.out.println("You withdrawed " + amount + ". Your account balance is now " + moneymoney + "€");
			bankaccount.setBalance(moneymoney);
			atmFortune.setCashATM(cashMoney);
			System.out.println("The ATMs cash stash is " + cashMoney + "€");
		} else {
			System.err.println("This action does not work. Your account balance is " + moneymoney + "€. The ATMs money stock is at " + cashMoney + "€."); // sollte dieser Teil in die Exception?
		}
	}

	// Launches the ATM
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.runID();
		// atm.run();
	}
}