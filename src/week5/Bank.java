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
	private final BankAccount account;
	
	public StockMachine (BankAccount account) {
		this.account = account;
	}
	
	public void run () {
			account.invest(10);					
	}
}

class BankAccount {
	private int saving; 
	private int investment;
	
	public BankAccount (int saving, int investment) {
		this.saving = saving;
		this.investment = investment;
	}
	
	public void deposit (int n) {
		saving += n;
	}

	public void invest (int n) {
			saving -= n;
			investment += n;
	}
	
	public String toString () {
		return "Saving: SGD " + saving + "; Investment: SGD " + investment;
	}
}
