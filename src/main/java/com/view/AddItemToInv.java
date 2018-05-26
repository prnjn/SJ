package com.view;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class AddItemToInv extends JPanel {
	private JTextField textField;
	private JTextField textField_particular;
	private JTextField textField_weight;
	private JTextField textField_makingPerGm;
	private JTextField textField_ratePerGm;
	private JTextField textField_makingPerPc;
	private JTextField textField_amount;
	private final ButtonGroup buttonGroup_itemType = new ButtonGroup();
	private final ButtonGroup buttonGroup_makingCharge = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public AddItemToInv() {
		setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel label = new JLabel("Customer Id : ");
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 551, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(453))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 45, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JRadioButton radioButton_silver = new JRadioButton("Silver");
		buttonGroup_itemType.add(radioButton_silver);
		
		JRadioButton radioButton_gold = new JRadioButton("Gold");
		buttonGroup_itemType.add(radioButton_gold);
		
		JRadioButton radioButton_gem = new JRadioButton("Gem");
		buttonGroup_itemType.add(radioButton_gem);
		
		JRadioButton radioButton_ornament = new JRadioButton("Ornament");
		buttonGroup_itemType.add(radioButton_ornament);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(22)
					.addComponent(radioButton_silver)
					.addGap(18)
					.addComponent(radioButton_gold)
					.addGap(10)
					.addComponent(radioButton_gem)
					.addGap(10)
					.addComponent(radioButton_ornament)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 38, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(radioButton_silver)
						.addComponent(radioButton_gold)
						.addComponent(radioButton_ornament)
						.addComponent(radioButton_gem))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel label_1 = new JLabel("Particular");
		
		textField_particular = new JTextField();
		textField_particular.setColumns(10);
		
		JLabel label_2 = new JLabel("Weight");
		
		textField_weight = new JTextField();
		textField_weight.setColumns(10);
		
		JRadioButton radioButton_mcgm = new JRadioButton("Making / gram");
		buttonGroup_makingCharge.add(radioButton_mcgm);
		
		textField_makingPerGm = new JTextField();
		textField_makingPerGm.setColumns(10);
		
		JLabel label_3 = new JLabel("Rate/gm");
		
		textField_ratePerGm = new JTextField();
		textField_ratePerGm.setColumns(10);
		
		JRadioButton radioButton_mcp = new JRadioButton("Making / piece");
		buttonGroup_makingCharge.add(radioButton_mcp);
		
		textField_makingPerPc = new JTextField();
		textField_makingPerPc.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		
		textField_amount = new JTextField();
		textField_amount.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(lblAmount))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textField_particular, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
							.addGap(10))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textField_amount, Alignment.LEADING)
								.addComponent(textField_ratePerGm, Alignment.LEADING)
								.addComponent(textField_weight, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(radioButton_mcp)
								.addComponent(radioButton_mcgm))
							.addGap(6)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_makingPerGm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_makingPerPc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(44))
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGap(86)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(126, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
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
								.addComponent(textField_ratePerGm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAmount)
								.addComponent(textField_amount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JButton btnAddItem = new JButton("Add Item");
		
		JButton btnReset = new JButton("Reset");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(panel, 0, 0, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(119)
							.addComponent(btnAddItem)
							.addGap(155)
							.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
							.addGap(113)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddItem)
						.addComponent(btnReset))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
