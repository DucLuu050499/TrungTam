package gui.panel_model;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;

import bus.BUS_ThiSinh;
import dto.DTO_ThiSinh;
import gui.Panel_Field;
import gui.frame_model.Frame_Popup_ThiSinh;

public class Panel_ThiSinh extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	JTextField jTextField1, jTextField2, jTextField3, jTextField4;
	BUS_ThiSinh bus_ThiSinh;
	String[] columns = {"Họ thí sinh", "Tên thí sinh", "Giới tính", "Ngày sinh", "Nơi sinh", "CMND/CCCD", "Ngày cấp", "Nơi cấp", "Số điện thoại", "Email"};
	String[][] tableData;
	int numRow = 10;
	DTO_ThiSinh[] arrThiSinh;
	
	public Panel_ThiSinh() {
		bus_ThiSinh = new BUS_ThiSinh();
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
		
		jTextField1 = new JTextField();
		jTextField2 = new JTextField();
		jTextField3 = new JTextField();
		jTextField4 = new JTextField();
		
		JPanel field1 = new Panel_Field("Họ thí sinh", jTextField1);
		GridBagLayout gridBagLayout_2 = (GridBagLayout) field1.getLayout();
		gridBagLayout_2.rowHeights = new int[] {80, 0};
		search.add(field1);
		
		JPanel field2 = new Panel_Field("Tên thí sinh", jTextField2);
		GridBagLayout gridBagLayout_3 = (GridBagLayout) field2.getLayout();
		gridBagLayout_3.rowHeights = new int[] {80, 0};
		search.add(field2);
		
		JPanel field3 = new Panel_Field("CMND/CCCD", jTextField3);
		GridBagLayout gridBagLayout_4 = (GridBagLayout) field3.getLayout();
		gridBagLayout_4.rowHeights = new int[] {80, 0};
		search.add(field3);
		
		JPanel field4 = new Panel_Field("Số điên thoại", jTextField4);
		GridBagLayout gridBagLayout_1 = (GridBagLayout) field4.getLayout();
		gridBagLayout_1.rowHeights = new int[] {80, 0};
		search.add(field4);
		
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
		
		JButton btnCreate = new JButton("Thêm mới");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listButton.add(btnCreate);
		
		JButton btnView = new JButton("Xem");
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listButton.add(btnView);
		
		JButton btnEdit = new JButton("Sửa");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listButton.add(btnEdit);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listButton.add(btnDelete);
		
		JPanel table = new JPanel();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(5, 5, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 2;
		add(table, gbc_table);
		table.setLayout(new GridLayout(0, 1, 0, 0));
		
		tableData = new String[0][numRow];
		
		table_1 = new JTable(tableData,columns){
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
		table.add(new JScrollPane(table_1));	
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTable();
			}
		});
		
		btnCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame add = new Frame_Popup_ThiSinh("Thêm thí sinh", true, null);
				add.setVisible(true);
				add.addWindowListener(new WindowListener() {
					
					@Override
					public void windowOpened(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowIconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowDeiconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowDeactivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowClosing(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						updateTable();
					}
					
					@Override
					public void windowActivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DTO_ThiSinh thiSinh;
				if(table_1.getSelectedRow() >= 0) {
					thiSinh = arrThiSinh[table_1.getSelectedRow()];
					JFrame edit = new Frame_Popup_ThiSinh("Chỉnh sửa thí sinh", true, thiSinh);
					edit.setVisible(true);
					edit.addWindowListener(new WindowListener() {
						
						@Override
						public void windowOpened(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowIconified(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowDeiconified(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowDeactivated(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowClosing(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowClosed(WindowEvent e) {
							// TODO Auto-generated method stub
							updateTable();
						}
						
						@Override
						public void windowActivated(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
					});
				}else {
					JOptionPane.showMessageDialog(search, "Vui lòng chọn dòng chỉnh sửa", "Lỗi", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DTO_ThiSinh thiSinh;
				if(table_1.getSelectedRow() >= 0) {
					thiSinh = arrThiSinh[table_1.getSelectedRow()];
					JFrame view = new Frame_Popup_ThiSinh("Xem thông tin thí sinh", false, thiSinh);
					view.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(search, "Vui lòng chọn dòng để xem", "Lỗi", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DTO_ThiSinh thiSinh;
				if(table_1.getSelectedRow() >= 0) {
					thiSinh = arrThiSinh[table_1.getSelectedRow()];
					bus_ThiSinh.delete(thiSinh);
					updateTable();
				}else {
					JOptionPane.showMessageDialog(search, "Vui lòng chọn dòng để xóa", "Lỗi", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}

	public void updateTable() {
		DTO_ThiSinh dto_ThiSinh = new DTO_ThiSinh();
		dto_ThiSinh.setho(jTextField1.getText());
		dto_ThiSinh.setten(jTextField2.getText());
		dto_ThiSinh.setcmnd(jTextField3.getText());
		dto_ThiSinh.setsdt(jTextField4.getText());
		
		DTO_ThiSinh[] temp = bus_ThiSinh.getData(dto_ThiSinh);
		arrThiSinh = new DTO_ThiSinh[temp.length];
		System.arraycopy(temp, 0, arrThiSinh, 0, temp.length);;
		tableData = new String[arrThiSinh.length][numRow];;
		for(int i = 0; i < arrThiSinh.length; i++) {
			for(int j = 0; j < tableData[i].length; j++) {
				tableData[i][j] = arrThiSinh[i].getTableData()[j];
			}
		}
		
		JTable tempTable = new JTable(tableData,columns){
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
		table_1.setModel(tempTable.getModel());
	}

}
