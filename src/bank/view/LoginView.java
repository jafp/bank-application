package bank.view;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import bank.controller.LoginController;
import bank.controller.MainController;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class LoginView extends javax.swing.JFrame {

	private static final long serialVersionUID = -3266899153926274082L;
	
	private LoginController loginController;
	
	public JTextField nameField;
	public JPasswordField passwordField;
	
	private JPanel nameContainer;
	private JButton loginButton;
	private JPanel loginContainer;
	private JLabel passwordLabel;
	private JPanel passwordContainer;
	private JLabel nameLabel;
	
	/*
	 * Super is called here, and that initializes JFrame.
	 * Also we add the MainController as the JFrame's WindowListener.
	 * The controller is saved as a reference, so we can use it later on as ActionListener.
	 * The GUI is then being initialized and the window is set visible.
	 */
	public LoginView(LoginController lc, MainController mc) {
		super();
		this.addWindowListener(mc);
		loginController = lc;
		initGUI();
	}
	
	/*
	 * This method sets up all our windows components, such as containers, buttons, lists etc.
	 * Also here the Controller ActionListener is added to our button components.
	 */
	private void initGUI() {
		try {
			BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS);
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				nameContainer = new JPanel();
				getContentPane().add(nameContainer);
				getContentPane().add(getJPanel2());
				FlowLayout jPanel1Layout = new FlowLayout();
				nameContainer.setLayout(jPanel1Layout);
				nameContainer.setPreferredSize(new java.awt.Dimension(366, 47));
				{
					nameLabel = new JLabel();
					nameContainer.add(nameLabel);
					nameLabel.setText("Name:");
					nameLabel.setPreferredSize(new java.awt.Dimension(100, 20));
				}
				{
					nameField = new JTextField();
					FlowLayout jTextField1Layout = new FlowLayout();
					nameField.setLayout(jTextField1Layout);
					nameContainer.add(nameField);
					nameField.setPreferredSize(new java.awt.Dimension(250, 30));
				}
			}
			{
				loginContainer = new JPanel();
				getContentPane().add(loginContainer);
				loginContainer.setPreferredSize(new java.awt.Dimension(390, 84));
				{
					loginButton = new JButton();
					loginContainer.add(loginButton);
					loginButton.setText("Login");
					loginButton.setPreferredSize(new java.awt.Dimension(117, 29));
					loginButton.addActionListener(loginController);
				}
			}
			pack();
			this.setSize(376, 154);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	/*
	 * Below here we have getters and setters for the private fields.
	 */
	private JPanel getJPanel2() {
		if(passwordContainer == null) {
			passwordContainer = new JPanel();
			passwordContainer.setPreferredSize(new java.awt.Dimension(366, 42));
			{
				passwordLabel = new JLabel();
				passwordContainer.add(passwordLabel);
				passwordContainer.add(getPasswordField());
				passwordLabel.setText("Password:");
				passwordLabel.setPreferredSize(new java.awt.Dimension(100, 20));
			}
		}
		return passwordContainer;
	}
	
	private JPasswordField getPasswordField() {
		if(passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setPreferredSize(new java.awt.Dimension(250, 30));
		}
		return passwordField;
	}
}
