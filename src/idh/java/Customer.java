package idh.java;

public class Customer {
	
	private int bankAccount;
	private int balance;
	
	public Customer(int bankAccount, int balance) {
		this.bankAccount = bankAccount;
		this.balance = balance;		
		System.out.println("Congratulations. Your account was created.");
	};
	
	public Customer() {
		
	};
	
	public int getBalance() {
		return this.balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getBankAccount() {
		return this.bankAccount;
	}
	
	public void setBankAccount(int bankAccount) {
		this.bankAccount = bankAccount;
	}

}
