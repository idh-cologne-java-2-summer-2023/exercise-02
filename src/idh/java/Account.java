package idh.java;

public class Account {

	int accountBalance = 150;
	int accountN;
	
	public void setAccountN(int newAccount) {
		accountN = newAccount;
	}
	
	public int getAccount() {
		return accountN;
	}
	
	public void setBalance(int userBalance) {
		 accountBalance = userBalance; 
	 }
		
	public int getBalance() {
		return accountBalance;
	}
}
