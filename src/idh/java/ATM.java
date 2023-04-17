package idh.java;
import java.io.*;

public class ATM {
	
	private static int cashBalance = 1000; // initial cash balance
	private int accountBalance = 500; // initial user balance
	private String accountNumber; // account number for the user
	//sjsjjs
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.print("Enter your account number: ");
				accountNumber = br.readLine();
				System.out.print("Enter the amount to withdraw: ");
				String input = br.readLine();
				if (input.equals("exit")) {
					break;
				}
				int amount = Integer.parseInt(input);
				if (amount > accountBalance) {
					System.out.println("Sorry, you don't have enough money in your account.");
				} else if (amount > cashBalance) {
					System.out.println("Sorry, the ATM is out of cash.");
				} else {
					accountBalance -= amount;
					cashBalance -= amount;
					System.out.println("Ok, here is your money, spend it wisely!");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input, please enter a number.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
};
