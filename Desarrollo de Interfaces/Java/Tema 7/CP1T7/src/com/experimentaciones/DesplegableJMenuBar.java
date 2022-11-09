package com.experimentaciones;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DesplegableJMenuBar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesplegableJMenuBar frame = new DesplegableJMenuBar();
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
	public DesplegableJMenuBar() {
		JFrame frame = new JFrame();
		frame.setSize(1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("size");
		JMenuItem size = new JMenu("Size");
		menu.add(size);
		menubar.add(menu);

		frame.setJMenuBar(menubar);
	}

}
