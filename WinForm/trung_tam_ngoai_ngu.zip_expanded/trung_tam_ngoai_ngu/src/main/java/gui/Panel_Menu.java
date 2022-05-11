package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.Insets;
import java.awt.Component;
import gui.panel_model.Panel_GiaoVien;
import gui.panel_model.Panel_KhoaThi;
import gui.panel_model.Panel_PhongThi;
import gui.panel_model.Panel_ThiSinh;
import gui.panel_model.Panel_ThiSinhDuThi;

import java.awt.Font;

public class Panel_Menu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Panel_Menu() {
		
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setBackground(SystemColor.menu);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {200};
		gridBagLayout.rowHeights = new int[] {80, 50, 50, 50, 50, 50, 0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		setLayout(gridBagLayout);
		
		JLabel lblTitleMenu = new JLabel("Trung tâm ngoại ngữ");
		lblTitleMenu.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTitleMenu.setForeground(Color.BLACK);
		lblTitleMenu.setBackground(Color.BLACK);
		GridBagConstraints gbc_lblTitleMenu = new GridBagConstraints();
		gbc_lblTitleMenu.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitleMenu.gridx = 0;
		gbc_lblTitleMenu.gridy = 0;
		add(lblTitleMenu, gbc_lblTitleMenu);
		
		JLabel lblKhoaThi = new JLabel("Khóa thi");
		lblKhoaThi.setFont(new Font("Arial", Font.PLAIN, 14));
		lblKhoaThi.setHorizontalAlignment(SwingConstants.LEFT);
		lblKhoaThi.setHorizontalTextPosition(SwingConstants.LEFT);
		GridBagConstraints gbc_lblKhoaThi = new GridBagConstraints();
		gbc_lblKhoaThi.anchor = GridBagConstraints.WEST;
		gbc_lblKhoaThi.insets = new Insets(5, 20, 5, 20);
		gbc_lblKhoaThi.gridx = 0;
		gbc_lblKhoaThi.gridy = 1;
		add(lblKhoaThi, gbc_lblKhoaThi);
		
		JLabel lblPhongThi = new JLabel("Phòng thi");
		lblPhongThi.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPhongThi.setAlignmentX(Component.RIGHT_ALIGNMENT);
		GridBagConstraints gbc_lblPhongThi = new GridBagConstraints();
		gbc_lblPhongThi.anchor = GridBagConstraints.WEST;
		gbc_lblPhongThi.insets = new Insets(5, 20, 5, 20);
		gbc_lblPhongThi.gridx = 0;
		gbc_lblPhongThi.gridy = 2;
		add(lblPhongThi, gbc_lblPhongThi);
		
		JLabel lblThiSinhDuThi = new JLabel("Thí sinh dự thi");
		lblThiSinhDuThi.setFont(new Font("Arial", Font.PLAIN, 14));
		lblThiSinhDuThi.setAlignmentX(Component.RIGHT_ALIGNMENT);
		GridBagConstraints gbc_lblThiSinhDuThi = new GridBagConstraints();
		gbc_lblThiSinhDuThi.anchor = GridBagConstraints.WEST;
		gbc_lblThiSinhDuThi.insets = new Insets(5, 20, 5, 20);
		gbc_lblThiSinhDuThi.gridx = 0;
		gbc_lblThiSinhDuThi.gridy = 3;
		add(lblThiSinhDuThi, gbc_lblThiSinhDuThi);
		
		JLabel lblThiSinh = new JLabel("Thí sinh");
		lblThiSinh.setFont(new Font("Arial", Font.PLAIN, 14));
		lblThiSinh.setAlignmentX(Component.RIGHT_ALIGNMENT);
		GridBagConstraints gbc_lblThiSinh = new GridBagConstraints();
		gbc_lblThiSinh.anchor = GridBagConstraints.WEST;
		gbc_lblThiSinh.insets = new Insets(5, 20, 5, 20);
		gbc_lblThiSinh.gridx = 0;
		gbc_lblThiSinh.gridy = 4;
		add(lblThiSinh, gbc_lblThiSinh);
		
		JLabel lblGiaoVien = new JLabel("Giáo viên");
		lblGiaoVien.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGiaoVien.setAlignmentX(Component.RIGHT_ALIGNMENT);
		GridBagConstraints gbc_lblGiaoVien = new GridBagConstraints();
		gbc_lblGiaoVien.anchor = GridBagConstraints.WEST;
		gbc_lblGiaoVien.insets = new Insets(5, 20, 5, 20);
		gbc_lblGiaoVien.gridx = 0;
		gbc_lblGiaoVien.gridy = 5;
		add(lblGiaoVien, gbc_lblGiaoVien);
		
		JPanel footer = new JPanel();
		GridBagConstraints gbc_footer = new GridBagConstraints();
		gbc_footer.anchor = GridBagConstraints.SOUTH;
		gbc_footer.gridx = 0;
		gbc_footer.gridy = 6;
		add(footer, gbc_footer);
		GridBagLayout gbl_footer = new GridBagLayout();
		gbl_footer.columnWidths = new int[]{200, 0};
		gbl_footer.rowHeights = new int[]{40, 0};
		gbl_footer.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_footer.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		footer.setLayout(gbl_footer);
		
		JLabel lblExit = new JLabel("Thoát");
		lblExit.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblExit = new GridBagConstraints();
		gbc_lblExit.gridx = 0;
		gbc_lblExit.gridy = 0;
		footer.add(lblExit, gbc_lblExit);

		
		lblExit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);;
			}
		});
		
		lblThiSinh.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				getParent().remove(1);
				Panel_Body body = new Panel_Body("Thí sinh", new Panel_ThiSinh());
				
				GridBagConstraints gbc_bodyPanel = new GridBagConstraints();
				gbc_bodyPanel.insets = new Insets(5, 5, 5, 5);
				gbc_bodyPanel.anchor = GridBagConstraints.NORTHWEST;
				gbc_bodyPanel.fill = GridBagConstraints.BOTH;
				gbc_bodyPanel.gridx = 1;
				gbc_bodyPanel.gridy = 0;
				getParent().add(body,gbc_bodyPanel);
				getParent().revalidate();
				getParent().repaint();
			}
		});
		
		lblKhoaThi.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				getParent().remove(1);
				Panel_Body body = new Panel_Body("Khóa thi", new Panel_KhoaThi());
				
				GridBagConstraints gbc_bodyPanel = new GridBagConstraints();
				gbc_bodyPanel.insets = new Insets(5, 5, 5, 5);
				gbc_bodyPanel.anchor = GridBagConstraints.NORTHWEST;
				gbc_bodyPanel.fill = GridBagConstraints.BOTH;
				gbc_bodyPanel.gridx = 1;
				gbc_bodyPanel.gridy = 0;
				getParent().add(body,gbc_bodyPanel);
				getParent().revalidate();
				getParent().repaint();
			}
		});
		
		lblGiaoVien.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				getParent().remove(1);
				Panel_Body body = new Panel_Body("Giáo viên", new Panel_GiaoVien());
				
				GridBagConstraints gbc_bodyPanel = new GridBagConstraints();
				gbc_bodyPanel.insets = new Insets(5, 5, 5, 5);
				gbc_bodyPanel.anchor = GridBagConstraints.NORTHWEST;
				gbc_bodyPanel.fill = GridBagConstraints.BOTH;
				gbc_bodyPanel.gridx = 1;
				gbc_bodyPanel.gridy = 0;
				getParent().add(body,gbc_bodyPanel);
				getParent().revalidate();
				getParent().repaint();
			}
		});
		
		lblThiSinhDuThi.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				getParent().remove(1);
				Panel_Body body = new Panel_Body("Thí sinh dự thi", new Panel_ThiSinhDuThi());
				
				GridBagConstraints gbc_bodyPanel = new GridBagConstraints();
				gbc_bodyPanel.insets = new Insets(5, 5, 5, 5);
				gbc_bodyPanel.anchor = GridBagConstraints.NORTHWEST;
				gbc_bodyPanel.fill = GridBagConstraints.BOTH;
				gbc_bodyPanel.gridx = 1;
				gbc_bodyPanel.gridy = 0;
				getParent().add(body,gbc_bodyPanel);
				getParent().revalidate();
				getParent().repaint();
				
			}
		});
		
		lblPhongThi.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				getParent().remove(1);
				Panel_Body body = new Panel_Body("Phòng thi", new Panel_PhongThi());
				
				GridBagConstraints gbc_bodyPanel = new GridBagConstraints();
				gbc_bodyPanel.insets = new Insets(5, 5, 5, 5);
				gbc_bodyPanel.anchor = GridBagConstraints.NORTHWEST;
				gbc_bodyPanel.fill = GridBagConstraints.BOTH;
				gbc_bodyPanel.gridx = 1;
				gbc_bodyPanel.gridy = 0;
				getParent().add(body,gbc_bodyPanel);
				getParent().revalidate();
				getParent().repaint();
				
			}
		});
	}

}
