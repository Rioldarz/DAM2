package com.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField dineroIntroducido;

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
		panel.setBounds(514, 220, 126, 29);
		contentPane.add(panel);

		JMonthChooser monthChooser = new JMonthChooser();
		panel.add(monthChooser);

		JLabel dinero = new JLabel("0€");
		dinero.setBounds(607, 292, 45, 13);
		contentPane.add(dinero);

		dineroIntroducido = new JTextField();
		dineroIntroducido.setBounds(433, 289, 96, 19);
		contentPane.add(dineroIntroducido);
		dineroIntroducido.setColumns(10);

		JLabel texto = new JLabel("Introduzca cantidad");
		texto.setBounds(433, 266, 96, 13);
		contentPane.add(texto);
		JButton aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dinero.setText(dineroIntroducido.getText());
			}
		});
		aceptar.setBounds(492, 365, 85, 21);
		contentPane.add(aceptar);
	}
}
