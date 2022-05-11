package gui;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;

import java.awt.Insets;
import java.awt.GridBagLayout;

public class Panel_Master extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1078088945893076044L;

	/**
	 * Create the panel.
	 */
	GridBagConstraints gbc_menuPanel = new GridBagConstraints();
	JPanel bodyPanel;
	
	public Panel_Master() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{1.0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
		gridBagLayout.rowHeights = new int[]{Frame_Master.SCREEN_HEIGTH};
		gridBagLayout.columnWidths = new int[]{150};
		setLayout(gridBagLayout);
		gbc_menuPanel.ipady = 5;
		gbc_menuPanel.ipadx = 5;
		gbc_menuPanel.fill = GridBagConstraints.VERTICAL;
		gbc_menuPanel.anchor = GridBagConstraints.NORTHWEST;
		
		gbc_menuPanel.insets = new Insets(5, 5, 5, 5);
		
		JPanel menuPanel = new Panel_Menu();
		gbc_menuPanel.gridx = 0;
		gbc_menuPanel.gridy = 0;
		add(menuPanel,gbc_menuPanel);
		
		bodyPanel = new JPanel();
		GridBagConstraints gbc_bodyPanel = new GridBagConstraints();
		gbc_bodyPanel.insets = new Insets(5, 5, 5, 5);
		gbc_bodyPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_bodyPanel.fill = GridBagConstraints.BOTH;
		gbc_bodyPanel.gridx = 1;
		gbc_bodyPanel.gridy = 0;
		add(bodyPanel, gbc_bodyPanel);
		
	}
	
}
