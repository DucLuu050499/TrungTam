package gui;

import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class Panel_Field extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Panel_Field(String nameField, JComponent component) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{160, 260, 0};
		gridBagLayout.rowHeights = new int[]{80, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblFieldName = new JLabel(nameField);
		lblFieldName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblFieldName = new GridBagConstraints();
		gbc_lblFieldName.anchor = GridBagConstraints.EAST;
		gbc_lblFieldName.insets = new Insets(10, 10, 10, 20);
		gbc_lblFieldName.gridx = 0;
		gbc_lblFieldName.gridy = 0;
		add(lblFieldName, gbc_lblFieldName);
		
		component.setFont(new Font("Tahoma", Font.PLAIN, 14));
		if(component.getClass() == JTextField.class) {
			((JTextField) component).setHorizontalAlignment(SwingConstants.LEFT);
		}else if(component.getClass() == JDateChooser.class) {
			JTextFieldDateEditor editor = (JTextFieldDateEditor) ((JDateChooser) component).getDateEditor();
			editor.setEditable(false);
		}
		GridBagConstraints gbc_input = new GridBagConstraints();
		gbc_input.insets = new Insets(10, 10, 10, 20);
		gbc_input.fill = GridBagConstraints.HORIZONTAL;
		gbc_input.gridx = 1;
		gbc_input.gridy = 0;
		add(component, gbc_input);

	}

}
