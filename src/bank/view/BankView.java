package bank.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import bank.controller.BankController;
import bank.controller.MainController;


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
/**
 * @authors Pierre Zabell, Jacob Pedersen
 */
public class BankView extends javax.swing.JFrame {

	private static final long serialVersionUID = -3008784199281279137L;
	
	private BankController bankController;

	public JTextField nameField;
	public JPasswordField passwordField;
	public JTextField loanField;
	public JTextField overdraftField;
	public JList<String> customerList;
	public JTextField accountField;
	public JList<String> accountList;
	
	private JPanel functionContainer;
	private JPanel overdraftFieldContainer;
	private JPanel overdraftLabelContainer;
	private JPanel loanFieldContainer;
	private JPanel loanLabelContainer;
	private JPanel passwordFieldContainer;
	private JPanel passwordLabelContainer;
	private JPanel nameFieldContainer;
	private JPanel nameLabelContainer;
	public JLabel nameLabel;
	private JLabel overdraftLabel;
	private JLabel loanLabel;
	private JLabel passwordLabel;
	private JButton addButton;
	private JPanel overdraftContainer;
	private JPanel loanContainer;
	private JPanel passwordContainer;
	private JPanel nameContainer;
	private JButton deleteButton;
	private JPanel buttonContainer;
	private JLabel accountsLabel;
	private JLabel customerLabel;
	private JPanel xContainer;
	private JPanel accountsContainer;
	private JLabel accountLabel;
	private JPanel accountFieldContainer;
	private JPanel accountLabelContainer;
	private JPanel accountContainer;
	private JButton updateButton;
	private JPanel listContainer;
	
	/*
	 * Super is called here, and that initializes JFrame.
	 * Also we add the MainController as the JFrame's WindowListener.
	 * The controller is saved as a reference, so we can use it later on as ActionListener.
	 * The GUI is then being initialized and the window is set visible.
	 */
	public BankView(BankController bc, MainController mc) {
		super();
		this.addWindowListener(mc);
		bankController = bc;
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
				xContainer = new JPanel();
				getContentPane().add(xContainer);
				BoxLayout xContainerLayout = new BoxLayout(xContainer, javax.swing.BoxLayout.X_AXIS);
				xContainer.setLayout(xContainerLayout);
				xContainer.setPreferredSize(new java.awt.Dimension(423, 235));
				{
					functionContainer = new JPanel();
					xContainer.add(functionContainer);
					BoxLayout functionContainerLayout = new BoxLayout(functionContainer, javax.swing.BoxLayout.Y_AXIS);
					functionContainer.setLayout(functionContainerLayout);
					functionContainer.setPreferredSize(new java.awt.Dimension(258, 252));
					{
						buttonContainer = new JPanel();
						functionContainer.add(buttonContainer);
						{
							addButton = new JButton();
							buttonContainer.add(addButton);
							addButton.setText("Add");
							addButton.addActionListener(bankController);
						}
						{
							deleteButton = new JButton();
							buttonContainer.add(deleteButton);
							deleteButton.setText("Delete");
							deleteButton.addActionListener(bankController);
						}
						{
							updateButton = new JButton();
							buttonContainer.add(updateButton);
							updateButton.setText("Update");
							updateButton.addActionListener(bankController);						}
					}
					{
						nameContainer = new JPanel();
						functionContainer.add(nameContainer);
						BoxLayout jPanel2Layout = new BoxLayout(nameContainer, javax.swing.BoxLayout.X_AXIS);
						nameContainer.setLayout(jPanel2Layout);
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
								nameField.setPreferredSize(new java.awt.Dimension(120, 22));
							}
						}
					}
					{
						passwordContainer = new JPanel();
						functionContainer.add(passwordContainer);
						BoxLayout jPanel3Layout = new BoxLayout(passwordContainer, javax.swing.BoxLayout.X_AXIS);
						passwordContainer.setLayout(jPanel3Layout);
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
								passwordField.setPreferredSize(new java.awt.Dimension(120, 22));
							}
						}
					}
					{
						accountContainer = new JPanel();
						BoxLayout accountContainerLayout = new BoxLayout(accountContainer, javax.swing.BoxLayout.X_AXIS);
						accountContainer.setLayout(accountContainerLayout);
						functionContainer.add(accountContainer);
						{
							accountLabelContainer = new JPanel();
							accountContainer.add(accountLabelContainer);
							FlowLayout accountLabelContainerLayout = new FlowLayout();
							accountLabelContainerLayout.setAlignment(FlowLayout.LEFT);
							accountLabelContainer.setLayout(accountLabelContainerLayout);
							{
								accountLabel = new JLabel();
								accountLabelContainer.add(accountLabel);
								accountLabel.setText("Account Name:");
							}
						}
						{
							accountFieldContainer = new JPanel();
							accountContainer.add(accountFieldContainer);
							FlowLayout accountFieldContainerLayout = new FlowLayout();
							accountFieldContainerLayout.setAlignment(FlowLayout.RIGHT);
							accountFieldContainer.setLayout(accountFieldContainerLayout);
							{
								accountField = new JTextField();
								accountFieldContainer.add(accountField);
								accountField.setPreferredSize(new java.awt.Dimension(120, 22));
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
								loanLabel.setText("Loan Amount:");
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
								loanField.setPreferredSize(new java.awt.Dimension(120, 22));
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
								overdraftField.setPreferredSize(new java.awt.Dimension(120, 22));
							}
						}
					}
				}
				{
					listContainer = new JPanel();
					xContainer.add(listContainer);
					BorderLayout listContainerLayout = new BorderLayout();
					listContainer.setLayout(listContainerLayout);
					listContainer.setPreferredSize(new java.awt.Dimension(179, 249));
					{
						DefaultListModel<String> customerListModel = new DefaultListModel<String>();
						
						customerList = new JList<String>();
						listContainer.add(customerList, BorderLayout.CENTER);
						listContainer.add(getCustomerLabel(), BorderLayout.NORTH);
						customerList.setModel(customerListModel);
						customerList.setPreferredSize(new java.awt.Dimension(161, 252));
						customerList.addMouseListener(bankController);
						customerList.addFocusListener(bankController);
						customerList.setName("customerList");
					}
				}
			}
			{
				getContentPane().add(getAccountsContainer());
			}
			pack();
			this.setSize(433, 353);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	/*
	 * This clears the TextField's when actions are performed.
	 */
	public void clearFields() {
		nameField.setText("");
		passwordField.setText("");
		accountField.setText("");
		loanField.setText("");
		overdraftField.setText("");
	}
	
	private JPanel getAccountsContainer() {
		if(accountsContainer == null) {
			accountsContainer = new JPanel();
			BorderLayout accountsContainerLayout = new BorderLayout();
			accountsContainer.setLayout(accountsContainerLayout);
			accountsContainer.setPreferredSize(new java.awt.Dimension(431, 53));
			{
				DefaultListModel<String> accountListModel = new DefaultListModel<String>();
				accountList = new JList<String>();
				accountsContainer.add(accountList, BorderLayout.CENTER);
				accountsContainer.add(getAccountsLabel(), BorderLayout.NORTH);
				accountList.setModel(accountListModel);
				accountList.setPreferredSize(new java.awt.Dimension(423, 94));
				accountList.addMouseListener(bankController);
				accountList.addFocusListener(bankController);
				accountList.setName("accountList");
			}
		}
		return accountsContainer;
	}
	
	private JLabel getCustomerLabel() {
		if(customerLabel == null) {
			customerLabel = new JLabel();
			customerLabel.setText("Customers:");
		}
		return customerLabel;
	}
	
	private JLabel getAccountsLabel() {
		if(accountsLabel == null) {
			accountsLabel = new JLabel();
			accountsLabel.setText("Accounts:");
		}
		return accountsLabel;
	}

	/*
	 * Below here we have getters and setters for the private fields.
	 */
}
