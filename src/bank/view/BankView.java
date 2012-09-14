package bank.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


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
public class BankView extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3008784199281279137L;
	private JPanel functionContainer;
	private JPanel overdraftFieldContainer;
	private JPanel overdraftLabelContainer;
	private JPanel loanFieldContainer;
	private JPanel loanLabelContainer;
	private JPanel passwordFieldContainer;
	private JPanel passwordLabelContainer;
	private JPanel nameFieldContainer;
	private JPanel nameLabelContainer;
	private JTextField overdraftField;
	private JLabel overdraftLabel;
	private JTextField loanField;
	private JLabel loanLabel;
	private JPasswordField passwordField;
	private JLabel passwordLabel;
	private JButton addButton;
	private JTextField nameField;
	private JLabel nameLabel;
	private JPanel overdraftContainer;
	private JPanel loanContainer;
	private JPanel passwordContainer;
	private JPanel nameContainer;
	private JButton deleteButton;
	private JPanel buttonContainer;
	private JList customerLIst;
	private JPanel listContainer;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BankView inst = new BankView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public BankView() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.X_AXIS);
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				functionContainer = new JPanel();
				getContentPane().add(functionContainer);
				BoxLayout functionContainerLayout = new BoxLayout(functionContainer, javax.swing.BoxLayout.Y_AXIS);
				functionContainer.setLayout(functionContainerLayout);
				functionContainer.setPreferredSize(new java.awt.Dimension(224, 270));
				{
					buttonContainer = new JPanel();
					functionContainer.add(buttonContainer);
					{
						addButton = new JButton();
						buttonContainer.add(addButton);
						addButton.setText("Add");
					}
					{
						deleteButton = new JButton();
						buttonContainer.add(deleteButton);
						deleteButton.setText("Delete");
					}
				}
				{
					nameContainer = new JPanel();
					BoxLayout jPanel2Layout = new BoxLayout(nameContainer, javax.swing.BoxLayout.X_AXIS);
					nameContainer.setLayout(jPanel2Layout);
					functionContainer.add(nameContainer);
					{
						nameLabelContainer = new JPanel();
						FlowLayout jPanel6Layout = new FlowLayout();
						jPanel6Layout.setAlignment(FlowLayout.LEFT);
						nameContainer.add(nameLabelContainer);
						nameLabelContainer.setLayout(jPanel6Layout);
						{
							nameLabel = new JLabel();
							nameLabelContainer.add(nameLabel);
							nameLabel.setText("Name:");
						}
					}
					{
						nameFieldContainer = new JPanel();
						FlowLayout jPanel7Layout = new FlowLayout();
						jPanel7Layout.setAlignment(FlowLayout.RIGHT);
						nameContainer.add(nameFieldContainer);
						nameFieldContainer.setLayout(jPanel7Layout);
						{
							nameField = new JTextField();
							nameFieldContainer.add(nameField);
							nameField.setPreferredSize(new java.awt.Dimension(115, 22));
						}
					}
				}
				{
					passwordContainer = new JPanel();
					BoxLayout jPanel3Layout = new BoxLayout(passwordContainer, javax.swing.BoxLayout.X_AXIS);
					passwordContainer.setLayout(jPanel3Layout);
					functionContainer.add(passwordContainer);
					{
						passwordLabelContainer = new JPanel();
						FlowLayout jPanel8Layout = new FlowLayout();
						jPanel8Layout.setAlignment(FlowLayout.LEFT);
						passwordContainer.add(passwordLabelContainer);
						passwordLabelContainer.setLayout(jPanel8Layout);
						{
							passwordLabel = new JLabel();
							passwordLabelContainer.add(passwordLabel);
							passwordLabel.setText("Password:");
						}
					}
					{
						passwordFieldContainer = new JPanel();
						FlowLayout jPanel9Layout = new FlowLayout();
						jPanel9Layout.setAlignment(FlowLayout.RIGHT);
						passwordContainer.add(passwordFieldContainer);
						passwordFieldContainer.setLayout(jPanel9Layout);
						{
							passwordField = new JPasswordField();
							passwordFieldContainer.add(passwordField);
							passwordField.setPreferredSize(new java.awt.Dimension(115, 22));
						}
					}
				}
				{
					loanContainer = new JPanel();
					BoxLayout jPanel4Layout = new BoxLayout(loanContainer, javax.swing.BoxLayout.X_AXIS);
					loanContainer.setLayout(jPanel4Layout);
					functionContainer.add(loanContainer);
					{
						loanLabelContainer = new JPanel();
						FlowLayout jPanel10Layout = new FlowLayout();
						jPanel10Layout.setAlignment(FlowLayout.LEFT);
						loanContainer.add(loanLabelContainer);
						loanLabelContainer.setLayout(jPanel10Layout);
						{
							loanLabel = new JLabel();
							loanLabelContainer.add(loanLabel);
							loanLabel.setText("Initial Loan:");
						}
					}
					{
						loanFieldContainer = new JPanel();
						FlowLayout jPanel11Layout = new FlowLayout();
						jPanel11Layout.setAlignment(FlowLayout.RIGHT);
						loanContainer.add(loanFieldContainer);
						loanFieldContainer.setLayout(jPanel11Layout);
						{
							loanField = new JTextField();
							loanFieldContainer.add(loanField);
							loanField.setPreferredSize(new java.awt.Dimension(80, 22));
						}
					}
				}
				{
					overdraftContainer = new JPanel();
					BoxLayout jPanel5Layout = new BoxLayout(overdraftContainer, javax.swing.BoxLayout.X_AXIS);
					overdraftContainer.setLayout(jPanel5Layout);
					functionContainer.add(overdraftContainer);
					{
						overdraftLabelContainer = new JPanel();
						FlowLayout jPanel12Layout = new FlowLayout();
						jPanel12Layout.setAlignment(FlowLayout.LEFT);
						overdraftContainer.add(overdraftLabelContainer);
						overdraftLabelContainer.setLayout(jPanel12Layout);
						{
							overdraftLabel = new JLabel();
							overdraftLabelContainer.add(overdraftLabel);
							overdraftLabel.setText("Overdraft Limit:");
						}
					}
					{
						overdraftFieldContainer = new JPanel();
						FlowLayout jPanel13Layout = new FlowLayout();
						jPanel13Layout.setAlignment(FlowLayout.RIGHT);
						overdraftContainer.add(overdraftFieldContainer);
						overdraftFieldContainer.setLayout(jPanel13Layout);
						{
							overdraftField = new JTextField();
							overdraftFieldContainer.add(overdraftField);
							overdraftField.setPreferredSize(new java.awt.Dimension(80, 22));
						}
					}
				}
			}
			{
				listContainer = new JPanel();
				getContentPane().add(listContainer);
				BorderLayout listContainerLayout = new BorderLayout();
				listContainer.setLayout(listContainerLayout);
				listContainer.setPreferredSize(new java.awt.Dimension(213, 270));
				{
					ListModel customerLIstModel = 
							new DefaultComboBoxModel(
									new String[] { "Item One", "Item Two" });
					customerLIst = new JList();
					listContainer.add(customerLIst, BorderLayout.CENTER);
					customerLIst.setModel(customerLIstModel);
					customerLIst.setPreferredSize(new java.awt.Dimension(176, 236));
				}
			}
			pack();
			this.setSize(392, 280);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
