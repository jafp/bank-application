package bank.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import bank.view.MainView;

public class MainController implements ActionListener,WindowListener {
	
	private MainView mainView;
	private BankController bankController;
	private LoginController loginController;
	private SaveController saveController = new SaveController();
	
	public MainController() {
		mainView = new MainView(this,saveController);
	}
	
	public void bankViewButtonActionPerformed() {
		if(bankController == null) {
			bankController = new BankController(this);
		}
		mainView.setVisible(false);
		bankController.setVisible();
	}
	
	public void customerViewButtonActionPerformed() {
		if(loginController == null) {
			loginController = new LoginController(this);
		}
		mainView.setVisible(false);
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

	public void windowClosing(WindowEvent arg0) {
		mainView.setVisible(true);
	}
	
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
}
