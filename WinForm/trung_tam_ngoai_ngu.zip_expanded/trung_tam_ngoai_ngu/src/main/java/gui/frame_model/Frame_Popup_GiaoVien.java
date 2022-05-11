package gui.frame_model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bus.BUS_GiaoVien;
import dto.DTO_GiaoVien;
import gui.Panel_Field;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Frame_Popup_GiaoVien extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	JTextField jTextField;
	BUS_GiaoVien bus_GiaoVien = new BUS_GiaoVien();
	private JButton btnNewButton;
	public Frame_Popup_GiaoVien(String title, boolean isEdit, DTO_GiaoVien giaoVien) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 250);
		setTitle(title);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{200, 200, 0};
		gbl_contentPane.rowHeights = new int[]{160, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		jTextField = new JTextField();
		
		if(!isEdit) {
			jTextField.setEditable(isEdit);
		}
		if(giaoVien != null) {
			jTextField.setText(giaoVien.gettenGiaoVien());
		}
		
		JPanel panel = new Panel_Field("Tên giáo viên", jTextField);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		btnNewButton = new JButton("Lưu");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 6;
		if(isEdit) {
			contentPane.add(btnNewButton, gbc_btnNewButton);
		}
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DTO_GiaoVien dto_GiaoVien = new DTO_GiaoVien();
				dto_GiaoVien.settenGiaoVien(jTextField.getText());
				if(giaoVien == null) {
					if(bus_GiaoVien.create(dto_GiaoVien) != 1) {
						JOptionPane.showMessageDialog(contentPane, "Thêm thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);	
					}else {
						JOptionPane.showMessageDialog(contentPane, "Thêm thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				}
				else{
					if(bus_GiaoVien.update(dto_GiaoVien, giaoVien) != 1) {
						JOptionPane.showMessageDialog(contentPane, "Chỉnh sửa thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
						dispose();
					}else {
						JOptionPane.showMessageDialog(contentPane, "Chỉnh sửa thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				}
			}
		});
	}

}
