package bank.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import bank.model.Bank;
import bank.model.BankException;
import bank.model.Customer;
import bank.view.BankView;

public class BankController implements ActionListener {
	
	private BankView bankView;
	private Bank bankModel = Bank.instance();
	
	public BankController(MainController mc) {
		bankView = new BankView(this,mc);
		updateList();
	}
	
	public void setVisible() {
		bankView.setVisible(true);
	}
	
	public void addCustomer() {
		try {
			String name = bankView.nameField.getText().toLowerCase();
			boolean already_exists = false;
			for(Customer c : bankModel.getCustomers()) {
				System.out.println();
				if(c.getName().equals(name)) {
					already_exists = true;
				}
			}
			if(already_exists == true) {
				throw new BankException("A customer with the name "+name+" already exists!");
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
			updateList();
		}
	}
	
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
	
	public void updateList() {
		DefaultListModel<String> model = (DefaultListModel<String>) bankView.customerList.getModel();
		model.clear();
		for(Customer c : bankModel.getCustomers()) {
			model.addElement(c.getName());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = new String(e.getActionCommand());
		if(command.equals("Add")) addCustomer();
		else if(command.equals("Delete")) deleteCustomer();
	}
}
