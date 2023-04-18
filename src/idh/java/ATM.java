package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	int cashAvailable = 60;
	
	int PIN1 = 123;
	int balance1 = 200;
	int amount1 = 21;
	
	int PIN2 = 234;
	int balance2  = 100;
	int amount2 = 452;

	int PIN3 = 354;
	int balance3 = 400;
	int amount3 = 56;
	
	public void insertCard (){ 
        System.out.println("Please insert your card") ;
    } 
   public void enterPIN (String PIN1 ){ 
                if (PIN1.equals("123")) {
 System.out.println("Enter the amount to withdraw");
                }
   }
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter the amount to withdraw: ");
				int amount1 = Integer.parseInt(br.readLine());
				cashout(amount1);
			} catch (Exception e) {
				break;
			}
		}
	}
	public void cashout(int amount1) {
		if (amount1 < balance1) {
			balance1 = balance1 - amount1;
			cashAvailable = cashAvailable - amount1;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}	
	}
		public void insertCard2 (){ 
	        System.out.println("Please insert your card") ;
	    } 
	   public void enterPIN2 (String PIN2 ){ 

	                if (PIN2.equals("234")) {
	 System.out.println("Enter the amount to withdraw");
	                }
	   }
		public void run2() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				try {
					System.out.print("Enter the amount to withdraw: ");
					int amount2 = Integer.parseInt(br.readLine());
					cashout(amount2);
				} catch (Exception e) {
					break;
				}
			}
		}
		public void cashout2(int amount2) {
			if (amount2 < balance2) {
				balance2 = balance2 - amount2;
				cashAvailable = cashAvailable - amount2;
				System.out.println("Ok, here is your money, enjoy!");
			} else {
				System.out.println("Sorry, not enough money in the bank.");
			}
			
		}
			public void insertCard3 (){ 
		        System.out.println("Please insert your card") ;
		    } 
		   public void enterPIN3 (String PIN3 ){ 

		                if (PIN3.equals("345")) {
		 System.out.println("Enter the amount to withdraw");
		                }
		   }
			public void run3() {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				while (true) {
					try {
						System.out.print("Enter the amount to withdraw: ");
						int amount3 = Integer.parseInt(br.readLine());
						cashout(amount3);
					} catch (Exception e) {
						break;
					}
				}
			}
			public void cashout3(int amount3) {
				if (amount3 < balance3) {
					balance1 = balance3 - amount3;
					cashAvailable = cashAvailable - amount3;
					System.out.println("Ok, here is your money, enjoy!");
				} else {
					if (amount3 > cashAvailable)
					System.out.println("Sorry, not enough money in the bank.");
				}					
	};
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
}