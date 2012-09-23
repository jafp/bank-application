package bank.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import bank.model.Bank;
import bank.model.BankException;
import bank.model.Customer;
import bank.view.BankView;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class BankController implements ActionListener {
	
	private BankView bankView;
	private Bank bankModel = Bank.instance();
	
	/*
	 * A new BankView is created, the ActionListener(this) and the WindowListener(mc),
	 * is parsed into the BankView, and finally we update the customer list,
	 * because we might have a saved file with customer information in store.
	 */
	public BankController(MainController mc) {
		bankView = new BankView(this,mc);
		updateList();
	}
	
	/*
	 * This method is used by the MainController, so it can set the BankView visible.
	 * Because of the BankView being private, and only accessible from the BankController class.
	 */
	public void setVisible() {
		bankView.setVisible(true);
	}
	
	/*
	 * This method is for adding new customers to our Bank(Model).
	 * First of all we get the name of the customer, and check if such name already exists.
	 * If we are clear to go, we create a new Customer object, and then add it to our ArrayList
	 * of customers in the BankModel.
	 */
	public void addCustomer() {
		try {
			String name = bankView.nameField.getText();
			boolean alreadyExists = false;
			for(Customer c : bankModel.getCustomers()) {
				if(c.getName().toLowerCase().equals(name.toLowerCase())) {
					alreadyExists = true;
				}
			}
			if(alreadyExists == true) {
				throw new BankException("A customer with the name " + name + " already exists!");
			}
			else {
				try {
					Customer newCustomer = new Customer(
							name,
							new String(bankView.passwordField.getPassword()),
							Double.parseDouble(bankView.loanField.getText()),
							Double.parseDouble(bankView.overdraftField.getText())
							);
					bankModel.addCustomer(newCustomer);
				}
				catch (Exception e)  {
					throw new BankException("All fields needs to be filled!");
				}
			}
		}
		catch (BankException e) {
			new ErrorController(e);
		}
		finally {
			bankView.clearFields();
			updateList();
		}
	}
	
	/*
	 * Here we have a small method for deleting a given customer in the ArrayList for BankModel.
	 */
	public void deleteCustomer() {
		String name = new String((String) bankView.customerList.getSelectedValue());
		for(Customer c : bankModel.getCustomers()) {
			if(c.getName().equals(name)) {
				bankModel.deleteCustomer(c);
				updateList();
				return;
			}
		}
	}
	
	/*
	 * This method is for updating the ListModel used by the List components in the BankView.
	 * When this is called we refresh the list, so proper data will be displayed in the GUI.
	 */
	public void updateList() {
		DefaultListModel<String> model = (DefaultListModel<String>) bankView.customerList.getModel();
		model.clear();
		for(Customer c : bankModel.getCustomers()) {
			model.addElement(c.getName());
		}
	}

	/*
	 * The actionPerformed is a method contained in the ActionListener interface.
	 * We must have this method to receive our ActionEvent, when we perform an action on a object,
	 * that has this listener added to it.
	 * In this case we can either perform the addCustomer or deleteCustomer method.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = new String(e.getActionCommand());
		if(command.equals("Add")) addCustomer();
		else if(command.equals("Delete")) deleteCustomer();
	}
}
