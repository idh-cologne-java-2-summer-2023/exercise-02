package idh.java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ATM {
    private HashMap<String, BankAccount> accounts;
    private int maxCash;
    private int currentCash;

    public ATM() {
        accounts = new HashMap<>();
        accounts.put("1234", new BankAccount("1234", 10000));
        accounts.put("0000", new BankAccount("0000", 1000));
        accounts.put("9999", new BankAccount("9999", 500));
        maxCash = 1000;
        currentCash = maxCash;
    }

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter your account ID: ");
                String id = br.readLine();
                if (!accounts.containsKey(id)) {
                    System.out.println("Invalid account ID.");
                    continue;
                }
                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());
                BankAccount account = accounts.get(id);
                if (amount > account.getBalance()) {
                    System.out.println("Sorry, not enough money in the account.");
                } else if (amount > currentCash) {
                    System.out.println("Sorry, not enough cash in the ATM.");
                } else {
                    account.withdraw(amount);
                    currentCash -= amount;
                    System.out.println("Ok, here is your money, enjoy!");
                }
                System.out.println("Your current balance is " + account.getBalance());
            } catch (Exception e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }

    private static class BankAccount {
        
        private int balance;

        public BankAccount(String id, int balance) {
            
            this.balance = balance;
        }


        public int getBalance() {
            return balance;
        }

        public void withdraw(int amount) {
            balance -= amount;
            
            
        }
    }
}
