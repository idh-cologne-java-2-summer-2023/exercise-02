package idh.java;

import java.util.Random;

public class Account extends Bank {

	private String id = "";
	private int balance = 500;

	public Account() {
		setId("");
		Bank.getAccounts().add(this);
	}

	public Account(String id) {
		setId(id);
		Bank.getAccounts().add(this);
	}
	// getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (id.equals("")) {
			Random rnd = new Random();
			while (id.length() < 5) {
				int digit = rnd.nextInt(0, 10);
				id += Integer.toString(digit);
			}
		} else if (validID(id)) {
			this.id = id;
		} else {
			System.out.println("ID was automatically generated because of invalid ID input..");
			setId("");
		}
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
