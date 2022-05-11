package gui.frame_model;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bus.BUS_KhoaThi;
import bus.BUS_ThiSinh;
import bus.BUS_TrinhDo;
import dto.DTO_KhoaThi;
import dto.DTO_ThiSinh;
import dto.DTO_TrinhDo;
import gui.Panel_Field;
import gui.Select_Custom;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Frame_Popup_ThiSinhDuThi extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	JTextField cmnd;
	BUS_ThiSinh bus_ThiSinh = new BUS_ThiSinh();
	BUS_KhoaThi bus_KhoaThi = new BUS_KhoaThi();
	BUS_TrinhDo bus_TrinhDo = new BUS_TrinhDo();
	private JButton btnNewButton;
	private Select_Custom khoaThi, tenThiSinh, trinhDo;
	private JPanel panel_3;
	public Frame_Popup_ThiSinhDuThi(String title, boolean isEdit, DTO_ThiSinh thiSinh) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 457);
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
		
		DTO_ThiSinh[] thiSinhs = bus_ThiSinh.getData();
		String tenThiSinhs[] = new String[thiSinhs.length];
		String cmndThiSinhs[] = new String[thiSinhs.length];
		for(int i = 0; i < thiSinhs.length; i++) {
			tenThiSinhs[i] = thiSinhs[i].getho() + " " + thiSinhs[i].getten();
			cmndThiSinhs[i] = thiSinhs[i].getcmnd();
		}
		
		DTO_KhoaThi[] khoaThis = bus_KhoaThi.getData();
		String tenKhoaThis[] = new String[khoaThis.length];
		Integer maKhoaThis[] = new Integer[khoaThis.length];
		for(int i = 0; i < khoaThis.length; i++) {
			tenKhoaThis[i] = khoaThis[i].gettenKhoaThi();
			maKhoaThis[i] = khoaThis[i].getmaKhoaThi();
		}
		
		DTO_TrinhDo[] trinhDos = bus_TrinhDo.getData();
		String tenTrinhDos[] = new String[trinhDos.length];
		Integer maTrinhDos[] = new Integer[trinhDos.length];
		for(int i = 0; i < trinhDos.length; i++) {
			tenTrinhDos[i] = trinhDos[i].gettenTrinhDo();
			maTrinhDos[i] = trinhDos[i].getmaTrinhDo();
		}
		
		
		
		cmnd = new JTextField();
		cmnd.setEditable(false);
		khoaThi = new Select_Custom(tenKhoaThis, maKhoaThis);
		tenThiSinh = new Select_Custom(tenThiSinhs, cmndThiSinhs);
		trinhDo = new Select_Custom(tenTrinhDos, maTrinhDos);
		if(!isEdit) {
			khoaThi.setEditable(isEdit);
			tenThiSinh.setEditable(isEdit);
			trinhDo.setEditable(isEdit);
		}
		if(thiSinh != null) {

		}
		
		JPanel panel = new Panel_Field("Khóa thi", khoaThi);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		JPanel panel_1 = new Panel_Field("Tên thí sinh", tenThiSinh);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		
		JPanel panel_2 = new Panel_Field("CMND/CCCD", cmnd);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		contentPane.add(panel_2, gbc_panel_2);
		
		panel_3 = new Panel_Field("Trình độ", trinhDo);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 1;
		contentPane.add(panel_3, gbc_panel_3);
		
		btnNewButton = new JButton("Lưu");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 6;
		if(isEdit) {
			contentPane.add(btnNewButton, gbc_btnNewButton);
		}
		
		
		tenThiSinh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cmnd.setText((String) tenThiSinh.getSelectedID());
			} 
		});
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmndString = cmnd.getText();
				int maTrinhDo = (Integer) trinhDo.getSelectedID();
				int maKhoaThi = (Integer) khoaThi.getSelectedID();
				if(cmndString != null && !cmndString.contentEquals("") && maKhoaThi != -1 && maTrinhDo != -1)
					dao.DAO_ThiSinhDuThi.create(cmndString, maTrinhDo, maKhoaThi);
			}
		});
	}

}
