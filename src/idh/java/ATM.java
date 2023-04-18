package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ATM {
private Map<String, Integer> accountBalances;
private int availableCash;

public ATM() {
	accountBalances = new HashMap<String, Integer>();
	accountBalances.put("123", 100);
	accountBalances.put("234", 500);
	accountBalances.put("345", 50);

	availableCash = 500;
}


public void run() {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	while (true) {
		try {
			System.out.print("Enter your account number: ");
			String accountNumber = br.readLine();
			System.out.print("Enter the amount to withdraw: ");
			int amount = Integer.parseInt(br.readLine());
			cashout(accountNumber, amount);
		} catch (Exception e) {
			break;
		}
	}
}

public void cashout(String accountNumber, int amount) {
	if (accountBalances.containsKey(accountNumber)) {
		int balance = accountBalances.get(accountNumber);
		if (balance >= amount) {
			if (availableCash >= amount) {
				accountBalances.put(accountNumber, balance - amount);
				availableCash -= amount;
				System.out.println("Ok, here you go!");
			} else {
				System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
			}
		} else {
			System.out.println("Sorry, you don't have enough money in the bank.");
		}
	} else {
		System.out.println("Unknown account number.");
	}
};


public static void main(String[] args) {
	ATM atm = new ATM();
	atm.run();
};


}
