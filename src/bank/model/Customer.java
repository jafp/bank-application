package bank.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	
	private ArrayList<MasterAccount> masterAccounts = new ArrayList<MasterAccount>();
	private int activeAccount;
	
	/*
	 * When the constructor is called a new customer is created.
	 * It takes all parameters necessary to create 1 MasterAccount with all sub-accounts, name & password.
	 */
	public Customer(String newName, String newPassword, String accountName, 
			double loanAmount, double overdraftLimit) {
		name = newName;
		password = newPassword;
		masterAccounts.add(new MasterAccount(accountName,loanAmount,overdraftLimit));
		activeAccount = 0;
	}
	
	/*
	 * Intended for creating additional master accounts.
	 */
	public void newMasterAccount(String newName, double loanAmount, double overdraftLimit) {
		masterAccounts.add(new MasterAccount(newName,loanAmount,overdraftLimit));
	}
	
	/*
	 * Methods for getting customer information and accounts.
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String newPassword) {
		password = newPassword;
	}
	
	public MasterAccount getActiveAccount() {
		return masterAccounts.get(activeAccount);
	}
	
	public void setActiveAccount(int i) {
		activeAccount = i;
	}
	
	public void removeActiveAccount() {
		masterAccounts.remove(activeAccount);
		setActiveAccount(0);
	}
	
	public ArrayList<MasterAccount> getAccounts() {
		return masterAccounts;
	}
	
	public DepositAccount getDA() {
		return masterAccounts.get(activeAccount).getDA();
	}
	
	public LoanAccount getLA() {
		return masterAccounts.get(activeAccount).getLA();
	}
	
	public OverdraftAccount getOA() {
		return masterAccounts.get(activeAccount).getOA();
	}
}
