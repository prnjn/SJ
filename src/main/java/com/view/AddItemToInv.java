package com.view;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang3.StringUtils;

import com.bean.ApplicationConfiguration;
import com.business.Compute;
import com.constants.ApplicationConstants;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.beans.PropertyChangeEvent;

public class AddItemToInv extends JPanel {
	public static JTextField textField_AddItemCustomerId;
	private JTextField textField_particular;
	private JTextField textField_weight;
	private JTextField textField_makingPerGm;
	private JTextField textField_ratePerGm;
	private JTextField textField_makingPerPc;
	private JTextField textField_amount;
	private final ButtonGroup buttonGroup_itemType = new ButtonGroup();
	private final ButtonGroup buttonGroup_makingCharge = new ButtonGroup();
	private JTextField textField_qty;
	private JTextField textField_pricePerPc;
	private JComboBox<String> comboBox_gold_carat;
	private JRadioButton radioButton_silver;
	private JRadioButton radioButton_gold;
	private JRadioButton radioButton_gem;
	private JRadioButton radioButton_ornament;

	public ApplicationConfiguration appConfig = ApplicationConfiguration.getAppConfig();
	private Compute compute = new Compute();
	private JCheckBox chckbxEnablePc;
	private JRadioButton radioButton_mcgm;
	private JRadioButton radioButton_mcp;
	private JButton btnOk;
	private JButton btnReset;
	
	private static final String COMMIT_ACTION = "commit";
	
	/**
	 * Create the panel.
	 */
	public AddItemToInv() {
		setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel label = new JLabel("Customer Id : ");
		
		textField_AddItemCustomerId = new JTextField();
		textField_AddItemCustomerId.setEditable(false);
		textField_AddItemCustomerId.setColumns(10);
		
		JLabel lblAddItem = new JLabel("Add Item");
		lblAddItem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_AddItemCustomerId, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(85)
					.addComponent(lblAddItem)
					.addGap(145))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField_AddItemCustomerId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblAddItem)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		radioButton_silver = new JRadioButton("Silver");
		radioButton_silver.setSelected(true);
		radioButton_silver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_silver.isSelected()) {
					textField_makingPerGm.setText(Double.toString(appConfig.getMakingPerGmSilver()));
					textField_ratePerGm.setText(Double.toString(appConfig.getSilverPricePerGm()));
				}
				
				// check and disable Gold Carat combobox
				if(!radioButton_gold.isSelected()){
					comboBox_gold_carat.setEnabled(false);
					comboBox_gold_carat.setEditable(false);
				}
			}
		});
		radioButton_gold = new JRadioButton("Gold");
		radioButton_gold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_gold.isSelected()) {
					comboBox_gold_carat.setEnabled(true);
					comboBox_gold_carat.setEditable(true);
					//comboBox_gold_carat.setSelectedItem(ApplicationConstants.gold_22c);
					textField_makingPerGm.setText(Double.toString(appConfig.getMakingPerGmGold()));
					
					if(ApplicationConstants.gold_18c.equals(comboBox_gold_carat.getSelectedItem())) {
						textField_ratePerGm.setText(Double.toString(appConfig.getGoldPricePerGm_18c()));
					}else if(ApplicationConstants.gold_20c.equals(comboBox_gold_carat.getSelectedItem())) {
						textField_ratePerGm.setText(Double.toString(appConfig.getGoldPricePerGm_20c()));
					}else if(ApplicationConstants.gold_22c.equals(comboBox_gold_carat.getSelectedItem())) {
						textField_ratePerGm.setText(Double.toString(appConfig.getGoldPricePerGm_22c()));
					}
					
				}else if(!radioButton_gold.isSelected()){
					comboBox_gold_carat.setEnabled(false);
					comboBox_gold_carat.setEditable(false);
				}
		    }
		});
		radioButton_gem = new JRadioButton("Gem");
		radioButton_gem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!radioButton_gold.isSelected()){
					comboBox_gold_carat.setEnabled(false);
					comboBox_gold_carat.setEditable(false);
					textField_makingPerGm.setText(StringUtils.EMPTY);
					textField_makingPerPc.setText(StringUtils.EMPTY);
					textField_ratePerGm.setText(StringUtils.EMPTY);
					textField_weight.setText(StringUtils.EMPTY);
				}
			}
		});
		radioButton_ornament = new JRadioButton("Ornament");
		radioButton_ornament.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!radioButton_gold.isSelected()){
					comboBox_gold_carat.setEnabled(false);
					comboBox_gold_carat.setEditable(false);
					textField_makingPerGm.setText(StringUtils.EMPTY);
					textField_makingPerPc.setText(StringUtils.EMPTY);
					textField_ratePerGm.setText(StringUtils.EMPTY);
					textField_weight.setText(StringUtils.EMPTY);
				}
			}
		});
		
		buttonGroup_itemType.add(radioButton_silver);
		buttonGroup_itemType.add(radioButton_gold);
		buttonGroup_itemType.add(radioButton_gem);
		buttonGroup_itemType.add(radioButton_ornament);
		
		comboBox_gold_carat = new JComboBox();
		comboBox_gold_carat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ApplicationConstants.gold_18c.equals(comboBox_gold_carat.getSelectedItem())) {
					textField_ratePerGm.setText(Double.toString(appConfig.getGoldPricePerGm_18c()));
				}else if(ApplicationConstants.gold_20c.equals(comboBox_gold_carat.getSelectedItem())) {
					textField_ratePerGm.setText(Double.toString(appConfig.getGoldPricePerGm_20c()));
				}else if(ApplicationConstants.gold_22c.equals(comboBox_gold_carat.getSelectedItem())) {
					textField_ratePerGm.setText(Double.toString(appConfig.getGoldPricePerGm_22c()));
				}
			}
		});
		comboBox_gold_carat.setModel(new DefaultComboBoxModel(new String[] {"18", "20", "22"}));
		comboBox_gold_carat.setEnabled(false);
		comboBox_gold_carat.setEditable(true);
		
		JLabel lblC = new JLabel("C");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(22)
							.addComponent(radioButton_silver)
							.addGap(18)
							.addComponent(radioButton_gold)
							.addGap(10)
							.addComponent(radioButton_gem)
							.addGap(10)
							.addComponent(radioButton_ornament))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(92)
							.addComponent(comboBox_gold_carat, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblC)))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(radioButton_silver)
						.addComponent(radioButton_gold)
						.addComponent(radioButton_ornament)
						.addComponent(radioButton_gem))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_gold_carat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblC))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel label_1 = new JLabel("Particular");
		
		textField_particular = new JTextField();
		textField_particular.setColumns(10);
		
		//////prnjn Autocomplete test
		textField_particular.setFocusTraversalKeysEnabled(false);
		List<String> keywords = new ArrayList<String>();
		keywords.add("example");
        keywords.add("autocomplete");
        keywords.add("stackabuse");
        keywords.add("java");
		Autocomplete autoComplete = new Autocomplete(textField_particular, keywords);
		textField_particular.getDocument().addDocumentListener(autoComplete);
		
		// Maps the tab key to the commit action, which finishes the autocomplete
		// when given a suggestion
		textField_particular.getInputMap().put(KeyStroke.getKeyStroke("TAB"), COMMIT_ACTION);
		textField_particular.getActionMap().put(COMMIT_ACTION, autoComplete.new CommitAction());
		
		///// prnjn autocomplete test end ////////
		
		
		JLabel label_2 = new JLabel("Weight");
		
		textField_weight = new JTextField();
//		textField_weight.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				computeAmountAction(e);
//			}
//		});
		textField_weight.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				computeAmount(e);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				computeAmount(e);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				computeAmount(e);
			}
		});
		
		textField_weight.setColumns(10);
		
		radioButton_mcgm = new JRadioButton("Making / gram");
		radioButton_mcgm.setSelected(true);
		radioButton_mcgm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_mcgmActionPerfoemed(e);
			}
		});
		buttonGroup_makingCharge.add(radioButton_mcgm);
		
		textField_makingPerGm = new JTextField(Double.toString(appConfig.getMakingPerGmSilver()));
//		textField_makingPerGm.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				computeAmountAction(e);
//			}
//		});
		
		textField_makingPerGm.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				computeAmount(e);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				computeAmount(e);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				computeAmount(e);
			}
		});
		
		textField_makingPerGm.setColumns(10);
		
		JLabel label_3 = new JLabel("Rate/gm");
		
		textField_ratePerGm = new JTextField(Double.toString(appConfig.getSilverPricePerGm()));
//		textField_ratePerGm.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				computeAmountAction(e);
//			}
//		});
		
		textField_ratePerGm.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				computeAmount(e);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				computeAmount(e);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				computeAmount(e);
			}
		});
		
		textField_ratePerGm.setColumns(10);
		
		radioButton_mcp = new JRadioButton("Making / piece");
		radioButton_mcp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_mcpActionPerformed(e);
			}
		});
		buttonGroup_makingCharge.add(radioButton_mcp);
		
		textField_makingPerPc = new JTextField();
		textField_makingPerPc.setEnabled(false);
//		textField_makingPerPc.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				computeAmountAction(e);
//			}
//		});
		
		textField_makingPerPc.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				computeAmount(e);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				computeAmount(e);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				computeAmount(e);
			}
		});
		
		textField_makingPerPc.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		
		textField_amount = new JTextField();
		textField_amount.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblAmount)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_amount, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(label_2)
								.addComponent(label_3))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(textField_particular, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
									.addGap(8))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textField_ratePerGm, Alignment.LEADING)
										.addComponent(textField_weight, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(radioButton_mcp)
										.addComponent(radioButton_mcgm))
									.addGap(6)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_makingPerGm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_makingPerPc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE))
					.addGap(45))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(86)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(105, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_particular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_weight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2))
							.addGap(11)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3)
								.addComponent(textField_ratePerGm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(25)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(radioButton_mcp)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(1)
											.addComponent(textField_makingPerPc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
									.addComponent(textField_makingPerGm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(radioButton_mcgm)))))
					.addGap(18)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmount)
						.addComponent(textField_amount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblQty = new JLabel("Qty");
		lblQty.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textField_qty = new JTextField("1");
//		textField_qty.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				computeAmountAction(e);
//			}
//		});
		
		textField_qty.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				computeAmount(e);
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				computeAmount(e);
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				computeAmount(e);
				
			}
		});
		
		textField_qty.setColumns(10);
		
		JLabel lblPricePc = new JLabel("Price / pc");
		
		textField_pricePerPc = new JTextField();
		textField_pricePerPc.setEnabled(false);
//		textField_pricePerPc.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				computeAmountAction(e);
//			}
//		});
		
		textField_pricePerPc.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				computeAmount(e);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				computeAmount(e);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				computeAmount(e);
			}
		});
		
		textField_pricePerPc.setColumns(10);
		
		chckbxEnablePc = new JCheckBox("Enable / pc");
		chckbxEnablePc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chckbxEnablePcActionPerformed(arg0);
			}
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPricePc)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_pricePerPc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblQty)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_qty, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxEnablePc)
					.addContainerGap(82, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPricePc)
						.addComponent(textField_pricePerPc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQty)
						.addComponent(textField_qty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxEnablePc))
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		panel_1.setLayout(gl_panel_1);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnOkActionPerformed(arg0);
			}
		});
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnResetActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(88)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(91)
					.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
					.addGap(171))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOk)
						.addComponent(btnReset))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////       Event Handling below
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void btnOkActionPerformed(ActionEvent e) {
		DefaultTableModel model = (DefaultTableModel) MainFrame.table_invoice.getModel();
		
		// Adding items to row
		Object itemsRowData[] = new Object[9];
		itemsRowData[0] = MainFrame.table_invoice.getRowCount()+1;
		itemsRowData[1] = textField_particular.getText();
		itemsRowData[2] = textField_qty.getText();
		itemsRowData[3] = textField_pricePerPc.getText();
		itemsRowData[4] = textField_makingPerPc.getText();
		itemsRowData[5] = textField_makingPerGm.getText();
		itemsRowData[6] = textField_ratePerGm.getText();
		itemsRowData[7] = textField_weight.getText();
		itemsRowData[8] = textField_amount.getText();
		
		model.addRow(itemsRowData);
	}
	
	private void btnResetActionPerformed(ActionEvent e) {
		// reseting the values 
		radioButton_silver.setSelected(true);
		textField_makingPerGm.setText(Double.toString(appConfig.getMakingPerGmSilver()));
		textField_ratePerGm.setText(Double.toString(appConfig.getSilverPricePerGm()));
		textField_particular.setText(StringUtils.EMPTY);
		textField_weight.setText(StringUtils.EMPTY);
		textField_makingPerPc.setText(StringUtils.EMPTY);
		
		textField_pricePerPc.setText(StringUtils.EMPTY);
		textField_qty.setText(StringUtils.EMPTY);
		chckbxEnablePc.setSelected(false);
		comboBox_gold_carat.setEnabled(false);
	}
	
	private void computeAmountAction(ActionEvent e) {		
		String weight=StringUtils.EMPTY;
		String ratePerGm=StringUtils.EMPTY;
		String makingPerGm=StringUtils.EMPTY;
		String makingPerPc=StringUtils.EMPTY;
		String pricePerPc = StringUtils.EMPTY;
		String qty=StringUtils.EMPTY;
		
		double d_weight      = 0;
		double d_ratePerGm   = 0;
		double d_makingPerGm = 0;
		double d_makingPerPc = 0;
		double d_pricePerPc  = 0;
		int    i_qty         = 0;
		boolean makingPerGmEnabled = false;
		double amount=0;
		
		qty = textField_qty.getText();
		if(StringUtils.isNotBlank(qty)) {
			i_qty=Integer.parseInt(qty);
		}else {
			i_qty=1;
		}
		
		if(!chckbxEnablePc.isSelected()) {
			if(textField_weight.isEnabled()) {
				weight = textField_weight.getText();
				if(StringUtils.isNotBlank(weight)) d_weight = Double.parseDouble(weight);
			}
			if(textField_ratePerGm.isEnabled()) {
				ratePerGm = textField_ratePerGm.getText();
				if(StringUtils.isNotBlank(ratePerGm)) d_ratePerGm = Double.parseDouble(ratePerGm);
			}
			if(textField_makingPerGm.isEnabled() && radioButton_mcgm.isSelected()) {
				makingPerGmEnabled = true;
				makingPerGm = textField_makingPerGm.getText();
				if(StringUtils.isNotBlank(makingPerGm)) d_makingPerGm = Double.parseDouble(makingPerGm);
			}
			if(textField_makingPerPc.isEnabled() && radioButton_mcp.isSelected()) {
				makingPerGmEnabled = false;
				makingPerPc =  textField_makingPerPc.getText();
				if(StringUtils.isNotBlank(makingPerPc)) d_makingPerPc = Double.parseDouble(makingPerPc);
			}
			
			amount = compute.caluclateItemAmountPerGm(d_weight, d_ratePerGm, d_makingPerGm, d_makingPerPc, i_qty, makingPerGmEnabled);
			
			
		}else if(chckbxEnablePc.isSelected()) {
			if(textField_pricePerPc.isEnabled()) {
				pricePerPc = textField_pricePerPc.getText();
				if(StringUtils.isNotBlank(pricePerPc)) d_pricePerPc = Double.parseDouble(pricePerPc);
			}
			if(textField_makingPerPc.isEnabled()) {
				makingPerPc = textField_makingPerPc.getText();
				if(StringUtils.isNotBlank(makingPerPc)) d_makingPerPc = Double.parseDouble(makingPerPc);
			}
			
			amount = compute.calculateItemAmountPerPc(d_pricePerPc, d_makingPerPc, i_qty);
		}
		textField_amount.setText(Double.toString(amount));
	}
	
	private void computeAmount(DocumentEvent e) {
		
		String weight=StringUtils.EMPTY;
		String ratePerGm=StringUtils.EMPTY;
		String makingPerGm=StringUtils.EMPTY;
		String makingPerPc=StringUtils.EMPTY;
		String pricePerPc = StringUtils.EMPTY;
		String qty=StringUtils.EMPTY;
		
		double d_weight      = 0;
		double d_ratePerGm   = 0;
		double d_makingPerGm = 0;
		double d_makingPerPc = 0;
		double d_pricePerPc  = 0;
		int    i_qty         = 0;
		boolean makingPerGmEnabled = false;
		double amount=0;
		
		qty = textField_qty.getText();
		if(StringUtils.isNotBlank(qty)) {
			i_qty=Integer.parseInt(qty);
		}else {
			i_qty=1;
		}
		
		if(!chckbxEnablePc.isSelected()) {
			if(textField_weight.isEnabled()) {
				weight = textField_weight.getText();
				if(StringUtils.isNotBlank(weight)) d_weight = Double.parseDouble(weight);
			}
			if(textField_ratePerGm.isEnabled()) {
				ratePerGm = textField_ratePerGm.getText();
				if(StringUtils.isNotBlank(ratePerGm)) d_ratePerGm = Double.parseDouble(ratePerGm);
			}
			if(textField_makingPerGm.isEnabled() && radioButton_mcgm.isSelected()) {
				makingPerGmEnabled = true;
				makingPerGm = textField_makingPerGm.getText();
				if(StringUtils.isNotBlank(makingPerGm)) d_makingPerGm = Double.parseDouble(makingPerGm);
			}
			if(textField_makingPerPc.isEnabled() && radioButton_mcp.isSelected()) {
				makingPerGmEnabled = false;
				makingPerPc =  textField_makingPerPc.getText();
				if(StringUtils.isNotBlank(makingPerPc)) d_makingPerPc = Double.parseDouble(makingPerPc);
			}
			
			amount = compute.caluclateItemAmountPerGm(d_weight, d_ratePerGm, d_makingPerGm, d_makingPerPc, i_qty, makingPerGmEnabled);
			
			
		}else if(chckbxEnablePc.isSelected()) {
			if(textField_pricePerPc.isEnabled()) {
				pricePerPc = textField_pricePerPc.getText();
				if(StringUtils.isNotBlank(pricePerPc)) d_pricePerPc = Double.parseDouble(pricePerPc);
			}
			if(textField_makingPerPc.isEnabled()) {
				makingPerPc = textField_makingPerPc.getText();
				if(StringUtils.isNotBlank(makingPerPc)) d_makingPerPc = Double.parseDouble(makingPerPc);
			}
			
			amount = compute.calculateItemAmountPerPc(d_pricePerPc, d_makingPerPc, i_qty);
		}
		textField_amount.setText(Double.toString(amount));
	}
	
	
	private void chckbxEnablePcActionPerformed(ActionEvent e) {
		if(chckbxEnablePc.isSelected()) {
			
			// Disabling fields
			textField_weight.setEnabled(false);
			textField_weight.setEditable(false);
			textField_ratePerGm.setEditable(false);
			textField_ratePerGm.setEnabled(false);
			textField_makingPerGm.setEnabled(false);
			textField_makingPerGm.setText(StringUtils.EMPTY);
			radioButton_mcgm.setSelected(false);
			radioButton_mcgm.setEnabled(false);
			radioButton_mcp.setSelected(true);
			
			//Enabling Fields
			textField_pricePerPc.setEnabled(true);
			textField_pricePerPc.setEditable(true);
            textField_makingPerPc.setEnabled(true);
			radioButton_mcp.setEnabled(true);
			textField_qty.setEditable(true);
			
		}else if(!chckbxEnablePc.isSelected()){
			// Enabling fields
			textField_weight.setEnabled(true);
			textField_weight.setEditable(true);
			textField_ratePerGm.setEditable(true);
			textField_ratePerGm.setEnabled(true);
			textField_makingPerGm.setEnabled(true);
			textField_makingPerPc.setText(StringUtils.EMPTY);
			radioButton_mcgm.setSelected(true);
			radioButton_mcgm.setEnabled(true);
			
			if(radioButton_gold.isSelected()) {
				textField_makingPerGm.setText(Double.toString(appConfig.getMakingPerGmGold()));
				
				if(ApplicationConstants.gold_18c.equals(comboBox_gold_carat.getSelectedItem())) {
					textField_ratePerGm.setText(Double.toString(appConfig.getGoldPricePerGm_18c()));
				}else if(ApplicationConstants.gold_20c.equals(comboBox_gold_carat.getSelectedItem())) {
					textField_ratePerGm.setText(Double.toString(appConfig.getGoldPricePerGm_20c()));
				}else if(ApplicationConstants.gold_22c.equals(comboBox_gold_carat.getSelectedItem())) {
					textField_ratePerGm.setText(Double.toString(appConfig.getGoldPricePerGm_22c()));
				}
				
			}else if(radioButton_silver.isSelected()) {
				textField_makingPerGm.setText(Double.toString(appConfig.getMakingPerGmSilver()));
				textField_ratePerGm.setText(Double.toString(appConfig.getSilverPricePerGm()));
			}
			
			//Disabling Fields
			textField_pricePerPc.setEnabled(false);
			textField_pricePerPc.setEditable(false);
			textField_makingPerPc.setEnabled(false);
			textField_qty.setText("1");
		}
	}
	
	private void radioButton_mcpActionPerformed(ActionEvent e){
		textField_makingPerGm.setText(StringUtils.EMPTY);
		textField_makingPerGm.setEnabled(false);
		textField_makingPerPc.setEnabled(true);
	}
	
	
	private void radioButton_mcgmActionPerfoemed(ActionEvent e) {
		textField_makingPerPc.setEnabled(false);
		textField_makingPerPc.setText(StringUtils.EMPTY);
		textField_makingPerGm.setEnabled(true);
		
		if(radioButton_gold.isSelected()) {
			textField_makingPerGm.setText(Double.toString(appConfig.getMakingPerGmGold()));
		}if(radioButton_silver.isSelected()) {
			textField_makingPerGm.setText(Double.toString(appConfig.getMakingPerGmSilver()));
		}
	}
}
