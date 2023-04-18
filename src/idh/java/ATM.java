package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM {

    private int atmBalance = 100;
    //accounts data 
    private int accountNumber1 = 123;
    private int accountNumber2 = 234;
    private int accountNumber3 = 345;
    
    private int accountKey1 = 111;
    private int accountKey2 = 222;
    private int accountKey3 = 333;
    
    private int accountBalance1 = 200;
    private int accountBalance2 = 100;
    private int accountBalance3 = 300;
    
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
    
    public void run() {
        System.out.println("Hello. To exit the application type 'exit'.");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter account number: ");
                String input = br.readLine();
                if (input.equals("exit")) {
                    break;
                }
                
                int accountNumber = Integer.parseInt(input);
                
                int accountBalance = getAccountBalance(accountNumber);
             
                if (accountBalance < 0) {
                    System.out.println("You don't have any money, try later.");
                    continue;
                }
                
                System.out.print("Enter PIN code: ");
                input = br.readLine();
                int accountKey = Integer.parseInt(input);
                if (!verifyAccountKey(accountNumber, accountKey)) {
                    System.out.println("Invalid PIN code. Try again.");
                    continue;
                }
                
                System.out.println("Enter the amount to withdraw: ");
                
                String inputAmount = br.readLine();
                int amount = Integer.parseInt(inputAmount);
                if (amount > accountBalance) {
                    System.out.println("Sorry, you don't have enough money.");
                    
                } else if (amount > atmBalance) {
                    System.out.println("Sorry, the ATM doesn't have that much cash.");
                } else {
                    withdraw(amount, accountNumber);
                    System.out.println("Ok, here you go!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //takes input and gets Balance for individual account
    private int getAccountBalance(int accountNumber) {
        switch (accountNumber) {
            case 123:
                return accountBalance1;
            case 234:
                return accountBalance2;
            case 345:
                return accountBalance3;
            default:
                return -1;
        }
    }
    
    //takes input and gets individual Keys for accounts
    private boolean verifyAccountKey(int accountNumber, int accountKey) {
        switch (accountNumber) {
            case 123:
                return accountKey == accountKey1;
            case 234:
                return accountKey == accountKey2;
            case 345:
                return accountKey == accountKey3;
            default:
                return false;
        }
    }

    //Checks balance and updates it per accountNumber
    private void withdraw(int amount, int accountNumber) {
        atmBalance -= amount;
        switch (accountNumber) {
            case 123:
                accountBalance1 -= amount;
                break;
            case 234:
                accountBalance2 -= amount;
                break;
            case 345:
                accountBalance3 -= amount;
                break;
            default:
                System.out.println("Not correct! Withdrawal failed.");
                break;
        }
    }
    
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}