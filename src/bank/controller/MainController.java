package bank.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bank.view.MainView;

public class MainController implements ActionListener {
	
	private BankController bankController;
	private LoginController loginController;
	private SaveController saveController = new SaveController();
	
	public MainController() {
		new MainView(this,saveController);
	}
	
	public void bankViewButtonActionPerformed() {
		if(bankController == null) {
			bankController = new BankController();
		}
		bankController.setVisible();
	}
	
	public void customerViewButtonActionPerformed() {
		if(loginController == null) {
			loginController = new LoginController();
		}
		loginController.setVisible();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = new String(e.getActionCommand());
		if(command.equals("Bank View")) bankViewButtonActionPerformed();
		else if(command.equals("Customer View")) customerViewButtonActionPerformed();
	}
	
	public static void main(String[] args) {
		new MainController();
	}
}
