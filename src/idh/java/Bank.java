package idh.java;

import java.util.ArrayList;

public abstract class Bank {

	private static ArrayList<Account> accounts = new ArrayList<>();

	public static boolean validID(String id) {
		if (id.matches("[0-9]{4}")) {
			return true;
		}
		return false;
	}

	public static Account matchingID(String id) {
		for (Account a : getAccounts()) {
			if (a.getId().equals(id)) {
				return a;
			}
		}
		return null;
	}

	// getters and setters
	public static ArrayList<Account> getAccounts() {
		return accounts;
	}

//	public static void setAccounts(ArrayList<Account> accounts) {
//		Bank.accounts = accounts;
//	}
}
