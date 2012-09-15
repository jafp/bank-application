package bank.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import bank.model.Bank;
import bank.model.Customer;
import bank.view.BankView;

public class BankController implements ActionListener {
	
	private BankView bankView;
	private Bank bankModel = Bank.instance();
	
	public BankController() {
		bankView = new BankView(this);
	}
	
	public void setVisible() {
		bankView.setVisible(true);
	}
	
	public void addCustomer() {
		Customer newCustomer = new Customer(
				bankView.nameField.getText(),
				new String(bankView.passwordField.getPassword()),
				Double.parseDouble(bankView.loanField.getText()),
				Double.parseDouble(bankView.overdraftField.getText())
				);
		bankModel.addCustomer(newCustomer);
		updateList();
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
		DefaultListModel model = (DefaultListModel) bankView.customerList.getModel();
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
