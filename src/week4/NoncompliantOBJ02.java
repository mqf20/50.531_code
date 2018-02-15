package week4;
abstract class Account {
	// Maintains all banking related data such as account balance
	private double balance = 100;

//	private Account () {}
	
	boolean withdraw(double amount) {
		if ((balance - amount) >= 0) {
			balance -= amount;
			System.out.println("Withdrawal successful. The balance is : " + balance);
			return true;
		}
		return false;
	}
	
	//The following is added later on without knowing the security policy implemented in BankAccount
	boolean overdraft() {
		balance += 300; // Add 300 in case there is an overdraft
		System.out.println("Added back-up amount. The balance is :"
		+ balance);
		return true;
	}
}

class BankAccount extends Account {
	// Subclass handles authentication
	@Override
	boolean withdraw(double amount) {
		if (!securityCheck()) {
			try {
				throw new IllegalAccessException();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super.withdraw(amount);
	}

	private final boolean securityCheck() {
		// check that account management may proceed
		return true;
	}
}

public class NoncompliantOBJ02 {
	public static void main(String[] args) {
		Account account = new BankAccount();
		// Enforce security manager check
		boolean result = account.withdraw(200.0);
		System.out.println("Withdrawal successful? " + result);
		
		//the following shows how the class can be attacked. 
		//if (!result) {
		//result = account.overdraft();
		//}
		//System.out.println("Withdrawal successful? " + result);
	}
}
