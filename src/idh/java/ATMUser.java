package idh.java;

public class ATMUser {
	private final int userID;
	private int userBalance;

	public ATMUser(int userID) {
		this.userID = userID;
		userBalance = 500;
	}

	public int getUserBalance() {
		return userBalance;
	}

	public void setUserBalance(int userBalance) {
		this.userBalance = userBalance;
	}

	public int getUserID() {
		return userID;
	}
	
	

}
