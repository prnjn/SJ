package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import java.awt.CardLayout;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame {

	private JFrame frame;
	private JPanel panel_invoice;
	private JTabbedPane tabbedPane_customerAccount;
	private JTextField textField_customerId;
	private JTextField textField_customerName;
	private JTextField textField_mobileNumber;
	private JTextField textField_addressLine1;
	private JTextField textField_addressLine2;
	private JTextField textField_landmark;
	private JTextField textField_city;
	private JTextField textField_state;
	private JTextField textField_date;
	private JTextField textField_amtInWords;
	private JTextField textField_totalAmount;
	private JTextField textField_amountPaid;
	private JTextField textField_discountAmount;
	private JTextField textField_balanceAmount;
	private JTable table_invoice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1224, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_header = new JPanel();
		
		JPanel panel_left_options = new JPanel();
		panel_left_options.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panel_cards = new JPanel();
		panel_cards.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panel_footer = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_left_options, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_cards, 0, 0, Short.MAX_VALUE))
						.addComponent(panel_header, GroupLayout.PREFERRED_SIZE, 1208, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_footer, GroupLayout.PREFERRED_SIZE, 1208, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(0, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_header, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_cards, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
						.addComponent(panel_left_options, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_footer, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_panel_footer = new GroupLayout(panel_footer);
		gl_panel_footer.setHorizontalGroup(
			gl_panel_footer.createParallelGroup(Alignment.LEADING)
				.addGap(0, 707, Short.MAX_VALUE)
		);
		gl_panel_footer.setVerticalGroup(
			gl_panel_footer.createParallelGroup(Alignment.LEADING)
				.addGap(0, 16, Short.MAX_VALUE)
		);
		panel_footer.setLayout(gl_panel_footer);
		
		JButton btnInvoice = new JButton("Invoice");
		
		JButton btnCustomer = new JButton("Customer Account");
		GroupLayout gl_panel_left_options = new GroupLayout(panel_left_options);
		gl_panel_left_options.setHorizontalGroup(
			gl_panel_left_options.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_left_options.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_panel_left_options.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCustomer, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
						.addComponent(btnInvoice, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_left_options.setVerticalGroup(
			gl_panel_left_options.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_left_options.createSequentialGroup()
					.addGap(42)
					.addComponent(btnInvoice)
					.addGap(18)
					.addComponent(btnCustomer)
					.addContainerGap(427, Short.MAX_VALUE))
		);
		panel_left_options.setLayout(gl_panel_left_options);
		
		JLabel lblSj = new JLabel("SJ");
		GroupLayout gl_panel_header = new GroupLayout(panel_header);
		gl_panel_header.setHorizontalGroup(
			gl_panel_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_header.createSequentialGroup()
					.addGap(292)
					.addComponent(lblSj, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(392, Short.MAX_VALUE))
		);
		gl_panel_header.setVerticalGroup(
			gl_panel_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_header.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSj)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		panel_header.setLayout(gl_panel_header);
		panel_cards.setLayout(new CardLayout(0, 0));
		
		panel_invoice = new JPanel();
		panel_cards.add(panel_invoice, "name_5204846530869");
		
		JPanel panel_invoice_top = new JPanel();
		panel_invoice_top.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_invoice_botton = new JPanel();
		panel_invoice_botton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JScrollPane scrollPane_invoice = new JScrollPane();
		GroupLayout gl_panel_invoice = new GroupLayout(panel_invoice);
		gl_panel_invoice.setHorizontalGroup(
			gl_panel_invoice.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_invoice.createSequentialGroup()
					.addGroup(gl_panel_invoice.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_invoice_top, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_invoice_botton, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPane_invoice, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		gl_panel_invoice.setVerticalGroup(
			gl_panel_invoice.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_invoice.createSequentialGroup()
					.addComponent(panel_invoice_top, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_invoice, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_invoice_botton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		table_invoice = new JTable();
		scrollPane_invoice.setColumnHeaderView(table_invoice);
		
		JLabel lblPaidInWords = new JLabel("PAID IN WORDS :");
		
		textField_amtInWords = new JTextField();
		textField_amtInWords.setColumns(10);
		
		JLabel lblTotalAmont = new JLabel("Total Amont :");
		
		JLabel lblAmountPaid = new JLabel("Amount Paid :");
		
		JLabel lblDiscount = new JLabel("Discount :");
		
		JLabel lblBalanceAmount = new JLabel("Balance Amount :");
		
		textField_totalAmount = new JTextField();
		textField_totalAmount.setColumns(10);
		
		textField_amountPaid = new JTextField();
		textField_amountPaid.setColumns(10);
		
		textField_discountAmount = new JTextField();
		textField_discountAmount.setColumns(10);
		
		textField_balanceAmount = new JTextField();
		textField_balanceAmount.setColumns(10);
		
		JPanel panel_invoice_actionButtons = new JPanel();
		panel_invoice_actionButtons.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_panel_invoice_botton = new GroupLayout(panel_invoice_botton);
		gl_panel_invoice_botton.setHorizontalGroup(
			gl_panel_invoice_botton.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_invoice_botton.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_invoice_botton.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_invoice_botton.createSequentialGroup()
							.addComponent(lblPaidInWords, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_amtInWords, GroupLayout.PREFERRED_SIZE, 476, GroupLayout.PREFERRED_SIZE)
							.addGap(126))
						.addGroup(gl_panel_invoice_botton.createSequentialGroup()
							.addComponent(panel_invoice_actionButtons, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel_invoice_botton.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_invoice_botton.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblBalanceAmount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblDiscount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblAmountPaid))
						.addComponent(lblTotalAmont, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_invoice_botton.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_balanceAmount)
						.addComponent(textField_amountPaid)
						.addComponent(textField_totalAmount, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addComponent(textField_discountAmount))
					.addGap(83))
		);
		gl_panel_invoice_botton.setVerticalGroup(
			gl_panel_invoice_botton.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_invoice_botton.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_invoice_botton.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_invoice_botton.createSequentialGroup()
							.addGroup(gl_panel_invoice_botton.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_totalAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTotalAmont))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_invoice_botton.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAmountPaid)
								.addComponent(textField_amountPaid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_invoice_botton.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDiscount)
								.addComponent(textField_discountAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_invoice_botton.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBalanceAmount)
								.addComponent(textField_balanceAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_invoice_botton.createSequentialGroup()
							.addGroup(gl_panel_invoice_botton.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPaidInWords)
								.addComponent(textField_amtInWords, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_invoice_actionButtons, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JButton btnAddItem = new JButton("Add item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add Item action performed called");
				
				AddItemToInv addItem = new AddItemToInv();
				addItem.setVisible(true);
				JFrame addItemFrame = new JFrame("Add Item");
				addItemFrame.setBounds(100, 100, 560, 360);
				addItemFrame.getContentPane().add(addItem);
				addItemFrame.setVisible(true);
				
//				AddItemToInvoice addItem = new AddItemToInvoice();
//				addItem.setVisible(true);
//				JFrame addItemFrame = new JFrame("Add Item");
//				addItemFrame.setBounds(100, 100, 567, 456);
//				addItemFrame.getContentPane().add(addItem);
//				addItemFrame.setVisible(true);
//				
//				try {
//					addItem.setSelected(true);
//				}catch(Exception ex) {
//					ex.printStackTrace();
//				}
				
			}
		});
		btnAddItem.setActionCommand("invoiceActionPerformed");
		
		JButton btnAddPayment = new JButton("Add Payment");
		btnAddPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					System.out.println("Add Payment action performed called");
					
					AddPaymentDetails addPayment = new AddPaymentDetails();
					addPayment.setVisible(true);
					JFrame addItemFrame = new JFrame("Add Payment");
					addItemFrame.setBounds(100, 100, 567, 456);
					addItemFrame.getContentPane().add(addPayment);
					addItemFrame.setVisible(true);
			}
		});
		
		JButton btnSave = new JButton("Save");
		
		JButton btnNewButton = new JButton("Add Old Resale");
		
		JButton btnReset = new JButton("Reset");
		GroupLayout gl_panel_invoice_actionButtons = new GroupLayout(panel_invoice_actionButtons);
		gl_panel_invoice_actionButtons.setHorizontalGroup(
			gl_panel_invoice_actionButtons.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_invoice_actionButtons.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel_invoice_actionButtons.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAddItem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAddPayment, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
					.addGroup(gl_panel_invoice_actionButtons.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_invoice_actionButtons.createSequentialGroup()
							.addGap(32)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_invoice_actionButtons.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
		);
		gl_panel_invoice_actionButtons.setVerticalGroup(
			gl_panel_invoice_actionButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_invoice_actionButtons.createSequentialGroup()
					.addGroup(gl_panel_invoice_actionButtons.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_invoice_actionButtons.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_invoice_actionButtons.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAddItem)
								.addComponent(btnNewButton))
							.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
							.addGroup(gl_panel_invoice_actionButtons.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAddPayment)
								.addComponent(btnReset)))
						.addGroup(gl_panel_invoice_actionButtons.createSequentialGroup()
							.addGap(19)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel_invoice_actionButtons.setLayout(gl_panel_invoice_actionButtons);
		panel_invoice_botton.setLayout(gl_panel_invoice_botton);
		
		JLabel lblCustomerId = new JLabel("Customer Id ");
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		
		textField_customerId = new JTextField();
		textField_customerId.setColumns(10);
		
		textField_customerName = new JTextField();
		textField_customerName.setColumns(10);
		
		textField_mobileNumber = new JTextField();
		textField_mobileNumber.setColumns(10);
		
		JCheckBox chckbxNewCustomer = new JCheckBox("New Customer");
		
		JLabel lblAddressLine = new JLabel("Address Line1");
		
		JLabel lblAddressLine_1 = new JLabel("Address Line2");
		
		JLabel lblCity = new JLabel("Landmark");
		
		JLabel lblState = new JLabel("City");
		
		textField_addressLine1 = new JTextField();
		textField_addressLine1.setColumns(10);
		
		textField_addressLine2 = new JTextField();
		textField_addressLine2.setColumns(10);
		
		textField_landmark = new JTextField();
		textField_landmark.setColumns(10);
		
		JLabel lblState_1 = new JLabel("State");
		
		textField_city = new JTextField();
		textField_city.setColumns(10);
		
		textField_state = new JTextField();
		textField_state.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		
		textField_date = new JTextField();
		textField_date.setColumns(10);
		GroupLayout gl_panel_invoice_top = new GroupLayout(panel_invoice_top);
		gl_panel_invoice_top.setHorizontalGroup(
			gl_panel_invoice_top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_invoice_top.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_invoice_top.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_invoice_top.createSequentialGroup()
							.addGroup(gl_panel_invoice_top.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblMobileNumber, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblCustomerId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblCustomerName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_invoice_top.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_mobileNumber, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_customerName, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_customerId, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_invoice_top.createSequentialGroup()
							.addComponent(chckbxNewCustomer)
							.addGap(44)
							.addComponent(lblDate)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_date)))
					.addGap(48)
					.addGroup(gl_panel_invoice_top.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_invoice_top.createSequentialGroup()
							.addComponent(lblAddressLine)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_addressLine1))
						.addGroup(gl_panel_invoice_top.createSequentialGroup()
							.addGroup(gl_panel_invoice_top.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAddressLine_1)
								.addComponent(lblCity)
								.addComponent(lblState))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_invoice_top.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_invoice_top.createSequentialGroup()
									.addComponent(textField_city, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
									.addGap(24)
									.addComponent(lblState_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_state, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
								.addComponent(textField_landmark, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
								.addComponent(textField_addressLine2))))
					.addGap(335))
		);
		gl_panel_invoice_top.setVerticalGroup(
			gl_panel_invoice_top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_invoice_top.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_invoice_top.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_invoice_top.createSequentialGroup()
							.addGroup(gl_panel_invoice_top.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAddressLine)
								.addComponent(textField_addressLine1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_invoice_top.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAddressLine_1)
								.addComponent(textField_addressLine2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_invoice_top.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCity)
								.addComponent(textField_landmark, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_invoice_top.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblState)
								.addComponent(textField_city, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_state, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblState_1)))
						.addGroup(gl_panel_invoice_top.createSequentialGroup()
							.addGroup(gl_panel_invoice_top.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCustomerId, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_customerId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_invoice_top.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCustomerName)
								.addComponent(textField_customerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_invoice_top.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMobileNumber)
								.addComponent(textField_mobileNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_invoice_top.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxNewCustomer)
								.addComponent(textField_date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDate))))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		panel_invoice_top.setLayout(gl_panel_invoice_top);
		panel_invoice.setLayout(gl_panel_invoice);
		
		tabbedPane_customerAccount = new JTabbedPane(JTabbedPane.TOP);
		panel_cards.add(tabbedPane_customerAccount, "name_5297673933862");
		
		JPanel panel = new JPanel();
		tabbedPane_customerAccount.addTab("New tab", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_customerAccount.addTab("New tab", null, panel_1, null);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnInvoice = new JMenu("Invoice");
		mnFile.add(mnInvoice);
	}
}
