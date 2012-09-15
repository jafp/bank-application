package bank.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bank.model.Bank;
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
		for(Customer c : bankModel.getCustomers()) {
			if(
				loginView.nameField.getText().equals(c.getName()) && 
				new String(loginView.passwordField.getPassword()).equals(c.getPassword())) {
				new CustomerController(c);
				loginView.setVisible(false);
			}
			else System.out.println("Wrong login information!");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = new String(e.getActionCommand());
		if(command.equals("Login")) login();
	}

}
