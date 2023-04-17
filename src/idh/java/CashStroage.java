package idh.java;

public class CashStroage {
	
	private int moneystorage = 1000;
	
	
	public int get() {
		
		return moneystorage;

	}
	
	public void set(int withdrawn) {
		
		this.moneystorage -= withdrawn ;

	}

}
