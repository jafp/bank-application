package bank.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bank.model.BankException;
import bank.model.OverdraftAccount;

public class OverdraftAccountTest {

	private OverdraftAccount account;
	
	@Before
	public void before() {
		account = new OverdraftAccount(500);
	}
	
	@Test
	public void testConstruct() {
		assertEquals(account.getBalance(),0,0);
		assertEquals(account.getOverdraftLimit(),-500,0);
	}
	
	@Test
	public void testDeposit() {
		account.deposit(250);
		assertEquals(account.getBalance(),250,0);
	}
	
	@Test
	public void testWithdraw() throws BankException {
		account.withdraw(250);
		assertEquals(account.getBalance(),-250,0);
	}
	
	@Test (expected = BankException.class)
	public void testException() throws BankException {
		account.withdraw(750);
	}
}
