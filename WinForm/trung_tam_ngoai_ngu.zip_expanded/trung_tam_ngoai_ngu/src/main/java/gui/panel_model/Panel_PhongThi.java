package gui.panel_model;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTable;
import bus.BUS_BaiThi;
import bus.BUS_KhoaThi;
import bus.BUS_PhongThi;
import dto.DTO_BaiThi;
import dto.DTO_KhoaThi;
import dto.DTO_PhongThi;
import gui.Panel_Field;
import gui.Select_Custom;

public class Panel_PhongThi extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	Select_Custom khoaThi, phongThi;
	BUS_PhongThi bus_PhongThi;
	BUS_BaiThi bus_BaiThi = new BUS_BaiThi();
	BUS_KhoaThi bus_KhoaThi = new BUS_KhoaThi();
	JPanel field1, field2;
	String[] columns = {"Số báo danh", "Họ tên", "CMND/CCCD", "Tên phòng thi", "Tên khóa thi", "Điểm nghe", "Điểm nói", "Điểm đọc", "Điểm viết"};
	int countRow = 9;
	String[][] tableData;
	DTO_BaiThi[] arrBaiThi;
	
	public Panel_PhongThi() {
		bus_PhongThi = new BUS_PhongThi();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[] {200, 50, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel search = new JPanel();
		GridBagConstraints gbc_search = new GridBagConstraints();
		gbc_search.insets = new Insets(0, 0, 5, 0);
		gbc_search.fill = GridBagConstraints.BOTH;
		gbc_search.gridx = 0;
		gbc_search.gridy = 0;
		add(search, gbc_search);
		search.setLayout(new GridLayout(2, 0, 0, 0));
		
		DTO_KhoaThi[] khoaThis = bus_KhoaThi.getData();
		String tenKhoaThis[] = new String[khoaThis.length];
		Integer maKhoaThis[] = new Integer[khoaThis.length];
		for(int i = 0; i < khoaThis.length; i++) {
			tenKhoaThis[i] = khoaThis[i].gettenKhoaThi();
			maKhoaThis[i] = khoaThis[i].getmaKhoaThi();
		}
		
		DTO_PhongThi[] phongThis = bus_PhongThi.getData();
		String tenPhongThis[] = new String[phongThis.length];
		Integer maPhongThis[] = new Integer[phongThis.length];
		for(int i = 0; i < phongThis.length; i++) {
			tenPhongThis[i] = phongThis[i].gettenPhongThi();
			maPhongThis[i] = phongThis[i].getmaPhongThi();
		}
		
		
		
		
		khoaThi = new Select_Custom(tenKhoaThis, maKhoaThis);
		field1 = new Panel_Field("Tên khóa thi", khoaThi);
		GridBagLayout gridBagLayout_2 = (GridBagLayout) field1.getLayout();
		gridBagLayout_2.rowHeights = new int[] {80, 0};
		search.add(field1);
		
		phongThi = new Select_Custom(tenPhongThis, maPhongThis);
		field2 = new Panel_Field("Tên phòng thi", phongThi);
		GridBagLayout gridBagLayout_3 = (GridBagLayout) field2.getLayout();
		gridBagLayout_3.rowHeights = new int[] {80, 0};
		search.add(field2);
		
		JPanel listButton = new JPanel();
		GridBagConstraints gbc_listButton = new GridBagConstraints();
		gbc_listButton.insets = new Insets(0, 0, 5, 0);
		gbc_listButton.fill = GridBagConstraints.BOTH;
		gbc_listButton.gridx = 0;
		gbc_listButton.gridy = 1;
		add(listButton, gbc_listButton);
		listButton.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listButton.add(btnSearch);
		
		JButton btnCreate = new JButton("Lưu Lại");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listButton.add(btnCreate);
		
		JPanel table = new JPanel();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(5, 5, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 2;
		add(table, gbc_table);
		table.setLayout(new GridLayout(0, 1, 0, 0));
		
		tableData = new String[0][countRow];
		
		table_1 = new JTable(tableData,columns){
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	        	if(column >= 5)
	        		return true;
	        	return false;               
	        };
	    };
		table.add(new JScrollPane(table_1));	
		
		
		khoaThi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DTO_PhongThi[] phongThis = bus_PhongThi.getData(new DTO_PhongThi(-1, (Integer) khoaThi.getSelectedID(), -1, null, -1));
				String tenPhongThis[] = new String[phongThis.length + 1];
				Integer maPhongThis[] = new Integer[phongThis.length];
				tenPhongThis[0] = "";
				for(int i = 0; i < phongThis.length; i++) {
					tenPhongThis[i + 1] = phongThis[i].gettenPhongThi();
					maPhongThis[i] = phongThis[i].getmaPhongThi();
				}
				phongThi.removeAllItems();
				phongThi.setModel(new DefaultComboBoxModel<String>(tenPhongThis));
				phongThi.setArrValue(maPhongThis);
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTable();
			}
		});
		btnCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveData();
			}
		});
	}

	public void updateTable() {
		DTO_BaiThi dto_BaiThi = new DTO_BaiThi();
		dto_BaiThi.setMaPhongThi((Integer) phongThi.getSelectedID());
		dto_BaiThi.setMaKhoaThi((Integer) khoaThi.getSelectedID());
		
		DTO_BaiThi[] temp = bus_BaiThi.getData(dto_BaiThi);
		arrBaiThi = new DTO_BaiThi[temp.length];
		System.arraycopy(temp, 0, arrBaiThi, 0, temp.length);;
		tableData = new String[arrBaiThi.length][countRow];;
		for(int i = 0; i < arrBaiThi.length; i++) {
			for(int j = 0; j < tableData[i].length; j++) {
				tableData[i][j] = arrBaiThi[i].getTableData()[j];
			}
		}
		
		JTable tempTable = new JTable(tableData,columns){
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	        	if(column >= 5)
	        		return true;
	        	return false;
	        };
	    };
		table_1.setModel(tempTable.getModel());
		
	}
	
	public void saveData() {
		DTO_BaiThi dto_BaiThiUpdate = new DTO_BaiThi();
		for(int i = 0; i < table_1.getRowCount(); i ++) {
			double diemNghe, diemNoi, diemDoc, diemViet;
			try {
				diemNghe = Double.parseDouble((String) table_1.getValueAt(i, 5));
				diemNoi = Double.parseDouble((String) table_1.getValueAt(i, 6));
				diemDoc = Double.parseDouble((String) table_1.getValueAt(i, 7));
				diemViet = Double.parseDouble((String) table_1.getValueAt(i, 8));
				dto_BaiThiUpdate.setdiemDoc(diemDoc);
				dto_BaiThiUpdate.setdiemNghe(diemNghe);
				dto_BaiThiUpdate.setdiemNoi(diemNoi);
				dto_BaiThiUpdate.setdiemViet(diemViet);
				if(bus_BaiThi.update(dto_BaiThiUpdate, arrBaiThi[i]) != 1) {
					JOptionPane.showMessageDialog(this, "Chỉnh sửa thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Chỉnh sửa thất bại. Điểm là số", "Lỗi", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
	}

}
