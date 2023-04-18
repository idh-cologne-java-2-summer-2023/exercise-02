package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM extends Bank {

	private int availableMoney = 10000;

	public static void main(String[] args) {
		Account a1 = new Account("1234");
		Account a2 = new Account("4321");
		Account a3 = new Account("1111");
		Account a4 = new Account("4444");
		a1.setBalance(1500);
		a2.setBalance(10000);

		ATM atm = new ATM();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		atm.run(br);
	}

	public void run(BufferedReader br) {
		try {
			System.out.print("Enter the bank account's ID: ");
			String input_id = br.readLine();
			if (input_id.toLowerCase().equals("exit")) {
				System.out.println("Goodbye!");
				System.exit(0);
			}
			if (matchingID(input_id) == null) {
				System.out.println("wrong ID..");
				this.run(br);
			}
			run2(input_id, br);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private void run2(String input_id, BufferedReader br) {
		while (true) {
			try {
				Account currentAccount = matchingID(input_id);
				System.out.println("Your current balance is: " + currentAccount.getBalance() + "$");
				System.out.print("Enter the amount to withdraw: ");
				String input_amount = br.readLine();
				
				if (input_amount.toLowerCase().equals("exit")) {
					System.out.println("Goodbye!");
					System.exit(0);
				}
				while (!input_amount.matches("[0-9]+")) {
					System.out.println("wrong input..");
					this.run2(input_id, br);
				}
				int amount = Integer.parseInt(input_amount);
				if (amount <= this.availableMoney) {
					if (amount <= currentAccount.getBalance()) {
						currentAccount.setBalance(currentAccount.getBalance() - amount);
						this.availableMoney -= amount;
						System.out.println("Ok, here is your money, enjoy the " + amount + "$!");
						System.out.println("Your new balance is: " + currentAccount.getBalance() + "$");
						this.run(br);
					} else {
						System.out.println("Sorry, not enough money in your bank account.");
						this.run2(input_id, br);
					}
				} else {
					System.out.println("Sorry, not enough money in this ATM.\nCurrently there is only "
							+ this.getAvailableMoney() + "$ available in this ATM.");
					this.run2(input_id, br);
				}
			} catch (Exception e) {
				System.out.println("Something went wrong..");
				System.exit(0);
			}
		}

	}

	// getters and setters
	public int getAvailableMoney() {
		return availableMoney;
	}

	public void setAvailableMoney(int availableMoney) {
		this.availableMoney = availableMoney;
	}

}