package gui.frame_model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import bus.BUS_ThiSinh;
import dto.DTO_ThiSinh;
import gui.Panel_Field;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Frame_Popup_ThiSinh extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	JTextField cmnd, ho, ten, gioiTinh, noiSinh, noiCap, sdt, email;
	JDateChooser ngaySinh, ngayCap;	
	BUS_ThiSinh bus_ThiSinh = new BUS_ThiSinh();
	private JButton btnNewButton;
	public Frame_Popup_ThiSinh(String title, boolean isEdit, DTO_ThiSinh thiSinh) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 532);
		setTitle(title);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{200, 200, 0};
		gbl_contentPane.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		ngaySinh =  new JDateChooser();
		ngayCap =  new JDateChooser();
		cmnd = new JTextField();
		ho = new JTextField();
		ten = new JTextField();
		gioiTinh = new JTextField();
		noiSinh = new JTextField();
		noiCap = new JTextField();
		sdt = new JTextField();
		email = new JTextField();
		
		if(!isEdit) {
			cmnd.setEditable(isEdit);
			ho.setEditable(isEdit);
			ten.setEditable(isEdit);
			gioiTinh.setEditable(isEdit);
			noiSinh.setEditable(isEdit);
			noiCap.setEditable(isEdit);
			sdt.setEditable(isEdit);
			email.setEditable(isEdit);
			ngaySinh.setEnabled(isEdit);
			ngayCap.setEnabled(isEdit);
		}
		if(thiSinh != null) {
			cmnd.setText(thiSinh.getcmnd());;
			ho.setText(thiSinh.getho());
			ten.setText(thiSinh.getten());
			gioiTinh.setText(thiSinh.getgioiTinh());
			noiSinh.setText(thiSinh.getnoiSinh());
			noiCap.setText(thiSinh.getnoiCap());
			sdt.setText(thiSinh.getsdt());
			email.setText(thiSinh.getemail());
			ngaySinh.setDate(thiSinh.getngaySinh());
			ngayCap.setDate(thiSinh.getngayCap());
		}
		
		JPanel panel = new Panel_Field("Họ thí sinh", ho);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		JPanel panel_1 = new Panel_Field("Tên thí sinh", ten);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		
		JPanel panel_2 = new Panel_Field("Giới tính", gioiTinh);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		contentPane.add(panel_2, gbc_panel_2);
		
		JPanel panel_3 = new Panel_Field("Ngày sinh", ngaySinh);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 1;
		contentPane.add(panel_3, gbc_panel_3);
		
		JPanel panel_4 = new Panel_Field("Nơi sinh", noiSinh);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 2;
		contentPane.add(panel_4, gbc_panel_4);
		
		JPanel panel_5 = new Panel_Field("CMNN/CCCD", cmnd);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 1;
		gbc_panel_5.gridy = 2;
		contentPane.add(panel_5, gbc_panel_5);
		
		JPanel panel_6 = new Panel_Field("Ngày cấp", ngayCap);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 3;
		contentPane.add(panel_6, gbc_panel_6);
		
		JPanel panel_7 = new Panel_Field("Nơi cấp", noiCap);
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 1;
		gbc_panel_7.gridy = 3;
		contentPane.add(panel_7, gbc_panel_7);
		
		JPanel panel_8 = new Panel_Field("Số điện thoại", sdt);
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 4;
		contentPane.add(panel_8, gbc_panel_8);
		
		JPanel panel_9 = new Panel_Field("Email", email);
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 5, 0);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 1;
		gbc_panel_9.gridy = 4;
		contentPane.add(panel_9, gbc_panel_9);
		
		
		
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
				DTO_ThiSinh dto_ThiSinh = new DTO_ThiSinh();
				dto_ThiSinh.setten(ten.getText());
				dto_ThiSinh.setcmnd(cmnd.getText());;
				dto_ThiSinh.setho(ho.getText());
				dto_ThiSinh.setten(ten.getText());
				dto_ThiSinh.setgioiTinh(gioiTinh.getText());
				dto_ThiSinh.setnoiSinh(noiSinh.getText());
				dto_ThiSinh.setnoiCap(noiCap.getText());
				dto_ThiSinh.setsdt(sdt.getText());
				dto_ThiSinh.setemail(email.getText());
				dto_ThiSinh.setngaySinh(support.Method.getDateAdd(ngaySinh.getDate()));
				dto_ThiSinh.setngayCap(support.Method.getDateAdd(ngayCap.getDate()));
				if(thiSinh == null) {
					if(bus_ThiSinh.create(dto_ThiSinh) != 1) {
						JOptionPane.showMessageDialog(contentPane, "Thêm thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(contentPane, "Thêm thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				}
				else{
					if(bus_ThiSinh.update(dto_ThiSinh, thiSinh) != 1) {
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
