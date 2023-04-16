package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {

    Account[] user = new Account[4]; //User array
    int atmBalance = 1000; // ATM balance

    public void setUser (int id,int num, int balance ){ //Setter for User array
        user[id] = new Account();
        user[id].accNumber = num;
        user[id].accBalance = balance;
    }
    /**
     * Main command loop of the ATM Asks the user to enter a number, and passes this
     * number to the function cashout(...) which actually does the calculation and
     * produces money. If the user enters anything else than an integer number, the
     * loop breaks and the program exists
     */
    public void run() { //Input for account number and withdraw amount.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter your account number: ");
                   int tempAccountNumber = Integer.parseInt(br.readLine());
                   for (int i = 0; i < user.length; i++){
                       if (user[i].accNumber == tempAccountNumber){ //checks for account number in user array
                           System.out.print("Enter the amount to withdraw: ");
                           int amount = Integer.parseInt(br.readLine());
                           cashout(amount, i);
                       }
                   }
            } catch (Exception e) {
                break;
            }
        }
    }

    public void cashout(int amount, int i) {    //gets the amount and "i" is the user Id
        if (amount == 0){
            System.out.println("error, invalid input!");
        }
        else if (atmBalance >= amount && amount <= user[i].accBalance) {
            user[i].accBalance -= amount;
            atmBalance -= amount;
            System.out.println("Ok, here is your money, enjoy!");
        } else if (amount > user[i].accBalance){
            System.out.println("Sorry, not enough money in the bank.");
        } else {
            System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
        }

    }
    /**
     * Launches the ATM
     */
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.setUser(0,123, 2000);
        atm.setUser(1,234,200);
        atm.setUser(2,345, 120);
        atm.setUser(3,456, 20);
        atm.run();


    }

}
