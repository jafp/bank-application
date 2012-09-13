package bank.view;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
public class LoginView extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3266899153926274082L;
	private JPanel nameContainer;
	private JButton loginButton;
	private JPasswordField passwordField;
	private JPanel loginContainer;
	private JTextField nameField;
	private JLabel passwordLabel;
	private JPanel passwordContainer;
	private JLabel nameLabel;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginView inst = new LoginView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public LoginView() {
		super();
		initGUI();
	}
	
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
				}
			}
			pack();
			this.setSize(376, 154);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
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
