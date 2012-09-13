package bank.view;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class AmountView extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8822570419338127412L;
	private JPanel amountContainer;
	private JLabel amountLabel;
	private JButton submitAmount;
	private JTextField amountField;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AmountView inst = new AmountView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AmountView() {
		super();
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
					amountField = new JTextField();
					amountContainer.add(amountField);
					amountField.setPreferredSize(new java.awt.Dimension(250, 30));
				}
				{
					submitAmount = new JButton();
					amountContainer.add(submitAmount);
					submitAmount.setText("Submit");
				}
			}
			pack();
			this.setSize(384, 99);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
