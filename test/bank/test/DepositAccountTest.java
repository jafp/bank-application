package bank.test;

import bank.model.BankException;
import bank.model.DepositAccount;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DepositAccountTest {
	
	private DepositAccount account;

	@Before
	public void before() {
		account = new DepositAccount();
	}
	
	@Test
	public void testDepositable() {
		account.deposit(100);
		assertEquals(account.getBalance(),100.0,0.0);
	}
	
	@Test
	public void testWithdrawable() throws BankException {
		account.deposit(100);
		account.withdraw(50);
		assertEquals(account.getBalance(),50,0.0);
	}
	
	@Test (expected = BankException.class)
	public void testBankException() throws BankException {
		account.deposit(50);
		account.withdraw(100);
	}

}
