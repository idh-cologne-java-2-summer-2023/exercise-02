package idh.java;
//Tina Tomic 
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 100;
	int ID1 = 1;
	int ID2 = 2;
	int amount1 = 55;
	int amount2 = 78;

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
				System.out.println("Enter your ID:");
				int ID = Integer.parseInt(br.readLine());
				if (checkID(ID)) {
		
			try {
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, ID);
			} catch (Exception e) {
				break;
			}
		}
	}
catch (Exception e) {
	break;
}
		}
	}
	public boolean checkID(int ID) {
		if (ID == ID1 | ID == ID2) {
			return true;
		}
		else {
			System.out.println("Wrong ID");
			
			return false;
		}
	}
	public void cashout(int amount, int ID) {
		if (amount <= accountBalance) {
			if (ID == ID1) {
				cashoutindividual(amount, amount1);
			}
			else {
				cashoutindividual(amount, amount2);
			}
		}
		else {
			System.out.println("The ATM does not have enough cash anymore!");
		}
	}
	
	public void cashoutindividual(int amount, int balanceind) {
		if (amount < balanceind) {
			accountBalance = accountBalance - amount;
			balanceind = balanceind - amount;
			System.out.println("OK, here you go!");
			
		}
		else {
			System.out.println("You do not have enough money in the bank");
		}
		
		}
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
		
		
	}
			