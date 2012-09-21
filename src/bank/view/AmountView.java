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
	
	public AmountView(CustomerController cc) {
		super();
		customerController = cc;
		initGUI();
	}
	
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

	public JTextField getAmountField() {
		return amountField;
	}

	public void setAmountField(JTextField amountField) {
		this.amountField = amountField;
	}
}
