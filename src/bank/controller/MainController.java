package bank.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import bank.view.MainView;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class MainController implements ActionListener,WindowListener {
	
	private MainView mainView;
	private BankController bankController;
	private LoginController loginController;
	private SaveController saveController = new SaveController();
	
	/*
	 * The constructor creates a new MainView object, so the program will startup with this View.
	 * Also parses itself into the MainView, so it can be used as an ActionListener and WindowListener
	 * for the MainView's components.
	 */
	public MainController() {
		mainView = new MainView(this);
	}
	
	/*
	 * Here we check if an action is performed on the bankView Button.
	 * If so we will call the BankController and thereby displaying the BankView.
	 */
	public void bankViewButtonActionPerformed() {
		if(bankController == null) {
			bankController = new BankController(this);
		}
		mainView.setVisible(false);
		bankController.setVisible();
	}
	
	/*
	 * Here we check if an action is performed on the customerView Button.
	 * If so we will call the LoginController and thereby displaying the LoginView.
	 */
	public void customerViewButtonActionPerformed() {
		if(loginController == null) {
			loginController = new LoginController(this);
		}
		mainView.setVisible(false);
		loginController.setVisible();
	}
	
	/*
	 * The actionPerformed is a method contained in the ActionListener interface.
	 * We must have this method to receive our ActionEvent, when we perform an action on a object,
	 * that has this listener added to it.
	 * In this case we listen on two buttons, and call the right method when the button is pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = new String(e.getActionCommand());
		if(command.equals("Bank View")) bankViewButtonActionPerformed();
		else if(command.equals("Customer View")) customerViewButtonActionPerformed();
	}
	
	/*
	 * Here is the enter point of the program, we immediately create a new MainController.
	 */
	public static void main(String[] args) {
		new MainController();
	}

	/*
	 * The windowClosing method is a part of the WindowListener interface,
	 * we must have it in our program, because this method is called when window objects close.
	 * We use this to know when its time to show the MainView again, and also when the program is closing,
	 * so that we can save our new active data.
	 */
	public void windowClosing(WindowEvent arg0) {
		if(arg0.getSource().getClass().getName().equals("bank.view.MainView")) {
			saveController.writeFile();
		}
		else {
			mainView.setVisible(true);
		}
	}
	
	/*
	 * All these methods are also part of the WindowListener interface,
	 * it if required that we have these in our program, but not that we use them.
	 */
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
}
