package idh.java;

public class Account {
	//account ID
			public int accountNumber;
			
			//account balance
			public int currentBalance;
			
			public Account(int accountNumber, int amount) {
				this.accountNumber = accountNumber;
				this.currentBalance = amount;
			}
			
			public int getAccountNumber() {
				return accountNumber;
			}
			public void setAccountNumber(int accountNumber) {
				this.accountNumber = accountNumber;
			}
			
			public int getCurrentBalance() {
				return currentBalance;
			}
			
			public void setCurrentBalance(int amount) {
				this.currentBalance = amount;
			}
			
			public void withdraw(int sum) {
				this.currentBalance = currentBalance - sum;
			}
}
