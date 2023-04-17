package idh.java;

import java.util.HashMap;

public class Accounts {
	static HashMap<Integer, Integer> accountStorage = new HashMap<Integer, Integer>();
	
	final protected int mastercode = 123;
	
	public void run(int mastercode) {
		if(mastercode == this.mastercode) {
			acountCreation();
		}
	}
	
	
	private void acountCreation() {
		
		accountStorage.put(123,100);
		accountStorage.put(343,1000);
		accountStorage.put(420,400200);

	}
	
	public int getAcc(int accNumb) throws Exception {
		
		if(accountStorage.containsKey(accNumb)) {
			return  (accountStorage.get(accNumb));
		} else {
			throw new Exception("you dont posses a account at this bank");
		}
	}
	
	public void setAccValue(int accNumb, int amount) {
		
		accountStorage.replace(accNumb, accountStorage.get(accNumb)-amount);
		
	}
	
	public void clearAcc(int mastercode) {
		if(mastercode == this.mastercode) {
			accountStorage.clear();
		}
	}
	
	
}
