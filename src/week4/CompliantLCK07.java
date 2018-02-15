package week4;
public class CompliantLCK07 {
	private static final Object tieLock = new Object ();
	
	private void transfer (BankAccount2 fromAccount, BankAccount2 toAccount, int amount) throws Exception {
		if (fromAccount.getBalance() < amount) {
			throw new Exception();
		}
		else {
			fromAccount.debit(amount);
			toAccount.credit(amount);
		}
	}
	
	public void transferMoney (BankAccount2 fromAccount, BankAccount2 toAccount, int amount) throws Exception {		
		int fromHash = System.identityHashCode(fromAccount);
		int toHash = System.identityHashCode(toAccount);
		
		if (fromHash < toHash) {
			synchronized (fromAccount) {
				synchronized (toAccount) {
					transfer(fromAccount, toAccount, amount);
				}
			}
		}
		else if (fromHash > toHash) {
			synchronized (toAccount) {
				synchronized (fromAccount) {
					transfer(fromAccount, toAccount, amount);
				}
			}			
		}
		else {
			synchronized (tieLock) {
				synchronized (fromAccount) {
					synchronized (toAccount) {
						transfer(fromAccount, toAccount, amount);
					}
				}
			}
		}
	}
}

class BankAccount2 {
	private int amount; 
	
	public int getBalance () {
		return amount;
	}
	
	public void debit (int n) {
		amount = amount - n;
	}
	
	public void credit (int n) {
		amount = amount + n;
	}
}

