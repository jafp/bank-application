package bank.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bank.model.BankException;
import bank.model.DepositAccount;
import bank.model.LoanAccount;

public class LoanAccountTest {
	
	private LoanAccount loanAccount;
	private DepositAccount depositAccount;

	@Before
	public void before() {
		depositAccount = new DepositAccount();
		loanAccount = new LoanAccount(500,depositAccount);
	}
	
	@Test
	public void testConstruct() {
		assertEquals(depositAccount.getBalance(),-loanAccount.getBalance(),0);
	}
	
	@Test
	public void testDeposit() throws BankException {
		loanAccount.deposit(250);
		assertEquals(loanAccount.getBalance(),-250,0);
		assertEquals(-loanAccount.getBalance(),depositAccount.getBalance(),0);
	}
	
	@Test (expected = BankException.class)
	public void testException() throws BankException {
		loanAccount.deposit(600);
	}
	
	@Test
	public void testLoan() {
		loanAccount.loan(500);
		assertEquals(depositAccount.getBalance(),1000,0);
		assertEquals(loanAccount.getBalance(),-1000,0);
		assertEquals(depositAccount.getBalance(),-loanAccount.getBalance(),0);
	}

}
