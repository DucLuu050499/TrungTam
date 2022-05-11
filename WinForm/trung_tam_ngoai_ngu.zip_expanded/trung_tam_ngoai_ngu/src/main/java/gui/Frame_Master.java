package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame_Master extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 159497960572358340L;

	public static final int SCREEN_WIDTH = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int SCREEN_HEIGTH = (int) SCREEN_WIDTH * 9 / 16;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_Master frame = new Frame_Master();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame_Master() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGTH);
		setResizable(false);
		contentPane = new Panel_Master();
		setContentPane(contentPane);
	}

}
