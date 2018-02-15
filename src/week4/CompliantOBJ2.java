package week4;

class CompliantBankAccount extends Account {
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
	
	//make sure the same security policy is implemented
	@Override boolean overdraft() { // override
		if (!securityCheck()) {
			try {
				throw new IllegalAccessException();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return super.overdraft();
	}
}

public class CompliantOBJ2 {
	public static void main(String[] args) {
		Account account = new CompliantBankAccount();
		// Enforce security manager check
		boolean result = account.withdraw(200.0);
		System.out.println("Withdrawal successful? " + result);
	}
}
