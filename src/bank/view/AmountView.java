package bank.view;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import bank.controller.CustomerController;

/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class AmountView extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 8822570419338127412L;
	
	private CustomerController customerController;
	
	private JTextField amountField;
	private JPanel amountContainer;
	private JLabel amountLabel;
	private JButton submitAmount;
	
	/*
	 * Super is called here, and that initializes JFrame.
	 * The controller is saved as a reference, so we can use it later on as ActionListener.
	 * The GUI is then being initialized and the window is set visible.
	 */
	public AmountView(CustomerController cc) {
		super();
		customerController = cc;
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
				amountContainer = new JPanel();
				getContentPane().add(amountContainer);
				amountContainer.setPreferredSize(new java.awt.Dimension(390, 95));
				{
					amountLabel = new JLabel();
					amountContainer.add(amountLabel);
					amountLabel.setText("Enter Amount:");
				}
				{
					setAmountField(new JTextField());
					amountContainer.add(getAmountField());
					getAmountField().setPreferredSize(new java.awt.Dimension(250, 30));
				}
				{
					submitAmount = new JButton();
					amountContainer.add(submitAmount);
					submitAmount.setText("Submit");
					submitAmount.setName("Submit");
					submitAmount.addActionListener(customerController);
				}
			}
			pack();
			this.setSize(384, 99);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	/*
	 * Below here we have getters and setters for the private fields.
	 */
	public JTextField getAmountField() {
		return amountField;
	}

	public void setAmountField(JTextField amountField) {
		this.amountField = amountField;
	}
}
