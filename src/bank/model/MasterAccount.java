package bank.model;

import java.io.Serializable;

public class MasterAccount implements Serializable {
	
	private static final long serialVersionUID = 8295246216654490918L;
	private String name;
	private DepositAccount depositAccount;
	private LoanAccount loanAccount;
	private OverdraftAccount overdraftAccount;
	
	/*
	 * This class is used to create a MasterAccount which stores 3 different sub accounts.
	 * These constructed objects gives the customer the option of having multiple accounts.
	 */
	public MasterAccount(String newName, double loanAmount, double overdraftLimit) {
		name = newName;
		depositAccount = new DepositAccount();
		loanAccount = new LoanAccount(loanAmount,depositAccount);
		overdraftAccount = new OverdraftAccount(overdraftLimit);
	}
	
	/*
	 * Getters and setters.
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public DepositAccount getDA() {
		return depositAccount;
	}
	
	public LoanAccount getLA() {
		return loanAccount;
	}
	
	public OverdraftAccount getOA() {
		return overdraftAccount;
	}

}
