package bank.view;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import bank.controller.MainController;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class MainView extends javax.swing.JFrame {

	private static final long serialVersionUID = 27723259255681567L;
	private MainController mainController;
	private JPanel bankButtonContainer;
	private JButton bankViewButton;
	private JLabel creditsLabel;
	private JPanel footerContainer;
	private JLabel welcomeLabel;
	private JPanel headerContainer;
	private JButton customerViewButton;
	private JPanel customerButtonContainer;
	
	/*
	 * Super is called here, and that initializes JFrame.
	 * Also we add the MainController as the JFrame's WindowListener.
	 * The controller is saved as a reference, so we can use it later on as ActionListener.
	 * The GUI is then being initialized and the window is set visible.
	 */
	public MainView(MainController mc) {
		super();
		this.addWindowListener(mc);
		mainController = mc;
		initGUI();
		setVisible(true);
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
				headerContainer = new JPanel();
				getContentPane().add(headerContainer);
				{
					welcomeLabel = new JLabel();
					headerContainer.add(welcomeLabel);
					welcomeLabel.setText("Welcome to the Bank Application.");
				}
			}
			{
				bankButtonContainer = new JPanel();
				getContentPane().add(bankButtonContainer);
				BorderLayout bankButtonContainerLayout = new BorderLayout();
				bankButtonContainer.setLayout(bankButtonContainerLayout);
				{
					bankViewButton = new JButton();
					bankButtonContainer.add(bankViewButton, BorderLayout.CENTER);
					bankViewButton.setText("Bank View");
					bankViewButton.addActionListener(mainController);
				}
			}
			{
				customerButtonContainer = new JPanel();
				getContentPane().add(customerButtonContainer);
				BorderLayout customerButtonContainerLayout = new BorderLayout();
				customerButtonContainer.setLayout(customerButtonContainerLayout);
				{
					customerViewButton = new JButton();
					customerButtonContainer.add(customerViewButton, BorderLayout.CENTER);
					customerViewButton.setText("Customer View");
					customerViewButton.addActionListener(mainController);
				}
			}
			{
				footerContainer = new JPanel();
				getContentPane().add(footerContainer);
				{
					creditsLabel = new JLabel();
					footerContainer.add(creditsLabel);
					creditsLabel.setText("IHK Java App - Jacob Pedersen & Pierre Zabell");
				}
			}
			pack();
			this.setSize(384, 181);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
}