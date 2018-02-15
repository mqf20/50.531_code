package week4;


import java.util.*;

public class NoncompliantLCK07 {
    private static final int NUM_THREADS = 20;
    private static final int NUM_ACCOUNTS = 5;

    public static void main(String[] args) {
        final BankAccount2[] accounts = new BankAccount2[NUM_ACCOUNTS];

        for (int i = 0; i < accounts.length; i++)
            accounts[i] = new BankAccount2();

        for (int i = 0; i < NUM_THREADS; i++)
            new TransferThread(accounts).start();
    }    
}

class TransferThread extends Thread {
    private static final int NUM_ITERATIONS = 100;
    private BankAccount2[] accounts;
    
    public TransferThread (BankAccount2[] accounts) {
    	this.accounts = accounts;
    }
    
    public void run() {
    	final Random rnd = new Random();
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            int fromAcct = rnd.nextInt(accounts.length);
            int toAcct = rnd.nextInt(accounts.length);
            int amount = rnd.nextInt(1000);
            transferMoney(accounts[fromAcct], accounts[toAcct], amount);
        }
    }
    
    public void transferMoney (BankAccount2 from, BankAccount2 to, int amount) {
        synchronized (from) {
        	synchronized (to) {
        		if (from.getBalance() < amount) {
        			System.out.println("Insufficient Fund");
        		}
        		else {
        			from.debit(amount);
        			to.credit(amount);
        		}
        	}
        }
    }
}