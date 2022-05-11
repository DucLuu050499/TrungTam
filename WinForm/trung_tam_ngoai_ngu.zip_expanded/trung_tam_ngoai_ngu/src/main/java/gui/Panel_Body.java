package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class Panel_Body extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	JPanel table;
	JLabel lblTableTitle;
	public Panel_Body(String tableName, JPanel jPanel) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{80, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblTableTitle = new JLabel(tableName);
		lblTableTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTableTitle = new GridBagConstraints();
		gbc_lblTableTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTableTitle.gridx = 0;
		gbc_lblTableTitle.gridy = 0;
		add(lblTableTitle, gbc_lblTableTitle);
		
		table = jPanel;
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		add(table, gbc_table);

	}

}
