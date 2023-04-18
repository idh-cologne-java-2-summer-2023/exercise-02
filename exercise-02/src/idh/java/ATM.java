package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ATM {
	
	HashMap<String, Integer> accounts = new HashMap<String, Integer>();	
	private static final String String = null;
	int atm_balance = 845;

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 * @throws IOException 
	 */
	public void run() throws IOException {
        
		// Accountnummern & Guthaben
		accounts.put("123", 500);
        accounts.put("456", 7);
        accounts.put("789", 3200);

        // Anmeldung
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String username = account();
			
			try {
				// Geldausgabe
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, username);
			} catch (Exception e) {
				break;
			}
		}
	}
	
	
	public String account() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter your account number");
		String account = br.readLine();
		return account;
	}

	
	
	
	public void cashout(int amount, String username) {
		if (amount <= accounts.get(username) && amount <= atm_balance){
			accounts.put(username, accounts.get(username) - amount);
			atm_balance -= amount;
			System.out.println("Make it rain!");
		} else if(amount >= accounts.get(username)) {
			System.out.println("Sorry Bro, u too broke!");
		} else {
			System.out.println("Sorry Bro, ATM too broke!");
		}

	};

	/**
	 * Launches the ATM
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ATM atm = new ATM();
		atm.run();
	};

}
