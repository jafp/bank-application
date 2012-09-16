package bank.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bank.model.Bank;
import bank.model.BankException;
import bank.model.Customer;
import bank.view.LoginView;

public class LoginController implements ActionListener {
	
	private Bank bankModel = Bank.instance();
	private LoginView loginView;
	
	public LoginController() {
		loginView = new LoginView(this);
	}
	
	public void setVisible() {
		loginView.setVisible(true);
	}
	
	public void login() {
		try {
			if(bankModel.getCustomers().size() != 0) {
				for(Customer c : bankModel.getCustomers()) {
					if(
						loginView.nameField.getText().toLowerCase().equals(c.getName()) && 
						new String(loginView.passwordField.getPassword()).equals(c.getPassword())) {
						new CustomerController(c);
						loginView.setVisible(false);
					}
					else throw new BankException("Wrong login information!");
				}
			}
			else throw new BankException("No customers are registered in the system!");
		}
		catch (BankException e) {
			new ErrorController(e);
		}	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = new String(e.getActionCommand());
		if(command.equals("Login")) login();
	}

}
