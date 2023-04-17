package idh.java;

public class AtmUser {
	protected int accountnumber;
	private static int counter = 0;
	
	public AtmUser() {
		this.accountnumber = ++counter;
		
	}

}
