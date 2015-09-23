package PS3;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class AccountTest extends Account {
	
	static Account testAccount = new Account(1122, 20000, .045, new Date());

	@Test
	public void testWithdraw() throws InsufficientFundsException {
		testAccount.withdraw(2500);
		assertEquals(testAccount.getBalance(), 17500, 0);
	}
	
	@Test
	public void testDeposit() {
		testAccount.deposit(3000);
		assertEquals(testAccount.getBalance(), 20500, 0);
		System.out.println("The balance is: " + testAccount.getBalance());
		System.out.println("The monthly interest is: " + testAccount.getMonthlyInterestRate());
		System.out.println("The date the account was created is: " + testAccount.getDateCreated());
	}
	
	@Test(expected=InsufficientFundsException.class)
	public void testException() throws InsufficientFundsException {
		try {
			testAccount.withdraw(30000);
		} catch (InsufficientFundsException e) {
			throw e;
		}
	}
}
