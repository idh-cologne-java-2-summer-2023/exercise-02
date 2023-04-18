package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//test
public class ATM {
    private List<BankAccount> accounts;
    private int cashOnHand;

    public ATM() {
        accounts = new ArrayList<>();

        accounts.add(new BankAccount(465, 5000));
        accounts.add(new BankAccount(234, 585));
        accounts.add(new BankAccount(345, 58658));
        accounts.add(new BankAccount(448, 3700));
        accounts.add(new BankAccount(3679, 93));
        accounts.add(new BankAccount(770, 83));
        accounts.add(new BankAccount(973, 37));


        cashOnHand = 20000;
    }

  
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter your account number: ");
                int accountNumber = Integer.parseInt(br.readLine());
                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());
                cashout(accountNumber, amount);
            } catch (Exception e) {
                break;
            }
        }
    }

    public void cashout(int accountNumber, int amount) {
        BankAccount account = null;
        for (BankAccount a : accounts) {
            if (a.getAccountNumber() == accountNumber) {
                account = a;
                break;
            }
        }

        if (account == null) {
            System.out.println("Invalid account number.");
            return;
        }

        if (amount > cashOnHand) {
            System.out.println("Sorry, the ATM does not have enough cash on hand.");
            return;
        }

        if (amount > account.getBalance()) {
            System.out.println("Sorry, you do not have enough funds in your account.");
            return;
        }

        account.withdraw(amount);
        cashOnHand -= amount;
        System.out.println("Ok, here you go!");
    }}
