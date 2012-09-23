package bank.model;
import java.util.ArrayList;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class Bank {
	
	private static Bank instance;
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	/*
	 * Creates a static Bank, so the information contained always is the same,
	 * no matter where it is accessed from. There will always only be one object of Bank.
	 */
	public static Bank instance() {
		if (instance == null) {
			instance = new Bank();
		}
		return instance;
	}
	
	/*
	 * Methods for handling data to and from the ArrayList.
	 */
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
