package com.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import de.wannawork.jcalendar.JCalendarPanel;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	private final JCalendarPanel calendarPanel = new JCalendarPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	public Interfaz() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fotoMetro = new JLabel("");
		fotoMetro.setIcon(new ImageIcon(Interfaz.class.getResource("/com/resources/Metro_petit.jpg")));
		fotoMetro.setBounds(50, 50, 250, 125);
		contentPane.add(fotoMetro);
		
		JPanel panel = new JPanel();
		panel.setBounds(442, 50, 316, 454);
		contentPane.add(panel);
		panel.add(calendarPanel);
	}
}
