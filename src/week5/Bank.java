package week5;

public class Bank {
	public static void main(String args[]){   	
		int numberofCustomers = 1000;
		BankAccount myAccount = new BankAccount (10000,1000);
		StockMachine[] machines = new StockMachine[numberofCustomers];
	
		for (int i = 0; i < numberofCustomers; i++) {
			machines[i] = new StockMachine(myAccount);
			machines[i].start();
		}
		
		try {
			for (int i = 0; i < numberofCustomers; i++) {
				machines[i].join();
			}
		} catch (InterruptedException e) {
			System.out.println("some thread is not finished");
		}
		
		System.out.println (myAccount);
	}
}

class StockMachine extends Thread {
	private final BankAccount account;  // state
	
	public StockMachine (BankAccount account) {
		this.account = account;
	}
	
	public void run () {
			account.invest(10);					
	}
}

class BankAccount {
	private int saving;  // state 
	private int investment;  // state
	
	public BankAccount (int saving, int investment) {
		this.saving = saving;
		this.investment = investment;
	}
	
	//post-condition: saving increased by n
	public synchronized void deposit (int n) {
		saving += n;
	}

	//post-condition: saving decreased by n, investment increased by n
	public synchronized void invest (int n) {
			saving -= n;
			investment += n;  // saving and investment are related variables
	}
	
	public String toString () {
		return "Saving: SGD " + saving + "; Investment: SGD " + investment;
	}
}
