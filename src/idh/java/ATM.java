package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ATM {
    // AccountBalance von jeder ID
    static int accountBalance1 = 100;
    static int accountBalance2 = 7100;
    static int accountBalance3 = 90;

    //ATM balance 
    static int ATMbalance = 4000; // Anfangsbestand des Automaten

    // Account Id
    String accId1 = "9128";
    String accId2 = "8232";
    String accId3 = "2180";

    /**
     * Main command loop of the ATM Asks the user to enter a number, and passes this
     * number to the function cashout(...) which actually does the calculation and
     * produces money. If the user enters anything else than an integer number, the
     * loop breaks and the program exists
     */

    // Scanner, um die Id zu überprüfen
    public void begin() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your Account Id: ");

        while (true) {

            String input = sc.next();

            if (input.equals(accId1) || input.equals(accId2) || input.equals(accId3)) {
                ATM.run();
            } else if (input.equals("exit")) {
                sc.close();
                System.exit(0);
            } else {
                System.out.println("Access is denied");

            }
        }
    }

    public static void run() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());
                cashout(amount);
            } catch (Exception e) {
                break;
            }
        }
    }

    //Aktualisierung des Betrags auf dem ATM und auf den Konten 
    public static void cashout(int amount) {
        int totalAccountBalance = accountBalance1 + accountBalance2 + accountBalance3;
        if (amount <= totalAccountBalance && amount <= ATMbalance) {
            // Geld von den jeweiligen Konten abziehen
            if (amount <= accountBalance1) {
                accountBalance1 = accountBalance1 - amount;
            } else if (amount <= accountBalance1 + accountBalance2) {
                accountBalance2 = accountBalance2 - amount + accountBalance1;
                accountBalance1 = 0;
            } else {
                accountBalance3 = accountBalance3 - amount + accountBalance1 + accountBalance2;
                accountBalance1 = 0;
                accountBalance2 = 0;
            }
            // Automatenbestand aktualisieren
            ATMbalance -= amount;
            System.out.println("Ok, here is your money, enjoy!");
        } else {
            System.out.println("Sorry, not enough money in the ATM.");
        }

    };

    /**
     * Launches the ATM
     */
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.begin();
    };

}