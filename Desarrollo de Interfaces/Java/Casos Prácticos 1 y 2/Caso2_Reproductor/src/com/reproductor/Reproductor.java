package com.reproductor;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class Reproductor extends JFrame {

	public void playSound(String soundName) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JButton btnNewButton = new JButton("X");

	/**
	 * Launch the application.
	 */
	public void inicio() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reproductor frame = new Reproductor();
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
	@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
	public Reproductor() {
		setLocationByPlatform(true);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 221, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnNewButton.setBackground(new Color(221, 221, 221));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Roboto", Font.PLAIN, 10));
		btnNewButton.setIcon(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(724, 0, 62, 35);
		contentPane.add(btnNewButton);

		JLabel reproduccion = new JLabel("Actual: The Weeknd - Blinding Lights");
		reproduccion.setForeground(new Color(221, 221, 221));
		reproduccion.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		reproduccion.setBounds(20, 86, 460, 45);
		contentPane.add(reproduccion);

		JButton back = new JButton("<");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File fi = new File("C:\\Users\\" + System.getProperty("user.name")
						+ "\\eclipse-workspace\\Tema2CasoPractico2_Reproductor\\src\\com\\sounds\\beep-01a.wav");
				playSound(fi.getAbsolutePath());
			}// Fin Acción
		});
		back.setBackground(new Color(255, 255, 255));
		back.setFont(new Font("Roboto", Font.PLAIN, 14));
		back.setBounds(79, 338, 44, 35);
		contentPane.add(back);

		JButton pauseNext = new JButton("| | >");
		pauseNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File fi = new File("C:\\Users\\" + System.getProperty("user.name")
						+ "\\eclipse-workspace\\Tema2CasoPractico2_Reproductor\\src\\com\\sounds\\beep-01a.wav");
				playSound(fi.getAbsolutePath());
			}// Fin Acción
		});
		pauseNext.setBackground(new Color(255, 255, 255));
		pauseNext.setFont(new Font("Roboto", Font.PLAIN, 14));
		pauseNext.setBounds(133, 338, 64, 35);
		contentPane.add(pauseNext);

		JButton next = new JButton(">");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File fi = new File("C:\\Users\\" + System.getProperty("user.name")
						+ "\\eclipse-workspace\\Tema2CasoPractico2_Reproductor\\src\\com\\sounds\\beep-01a.wav");
				playSound(fi.getAbsolutePath());
			}// Fin Acción
		});
		next.setBackground(new Color(255, 255, 255));
		next.setFont(new Font("Roboto", Font.PLAIN, 14));
		next.setBounds(207, 338, 44, 35);
		contentPane.add(next);

		JLabel icon = new JLabel("");
		icon.setIcon(new ImageIcon(Reproductor.class.getResource("/com/images/R.jpg")));
		icon.setBounds(79, 141, 172, 174);
		contentPane.add(icon);

		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "S3rl - Pika Girl",
					"----------------------------------------------------------------", "Ghost - Mary on a cross",
					"----------------------------------------------------------------",
					"Fito y Fitipaldis - Por un beso de la flaca",
					"----------------------------------------------------------------", "S3rl - Better off Alone",
					"----------------------------------------------------------------",
					"Rick Astley - Never Gonna Give You Up" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setFont(new Font("Roboto", Font.PLAIN, 14));
		list.setBounds(350, 141, 350, 174);
		contentPane.add(list);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Reproductor.class.getResource("/com/images/R (1).jpg")));
		fondo.setBounds(0, 0, 800, 500);
		contentPane.add(fondo);
	}
}
