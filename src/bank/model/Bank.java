package bank.model;

import java.util.ArrayList;

public class Bank {
	
	private static Bank instance;
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public static Bank instance() {
		if (instance == null) {
			instance = new Bank();
		}
		return instance;
	}
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public void deleteCustomer(Customer customer) {
		customers.remove(customer);
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
}
