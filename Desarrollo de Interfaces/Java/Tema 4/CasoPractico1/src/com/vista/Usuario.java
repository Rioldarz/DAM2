package com.vista;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.modelo.GestionaRecargas;
import com.toedter.calendar.JMonthChooser;



public class Usuario extends JFrame {

	private JPanel contentPane;
	private JTextField dineroIntroducido;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario frame = new Usuario();
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(dim.width / 2 - frame.getSize().width / 2,
							dim.height / 2 - frame.getSize().height / 2);
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
	public Usuario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel fotoMetro = new JLabel("");
		fotoMetro.setIcon(new ImageIcon(Usuario.class.getResource("/com/resources/Metro_petit.jpg")));
		fotoMetro.setBounds(50, 50, 250, 125);
		contentPane.add(fotoMetro);

		JPanel panel = new JPanel();
		panel.setBounds(190, 178, 110, 30);
		contentPane.add(panel);

		JMonthChooser monthChooser = new JMonthChooser();
		panel.add(monthChooser);

		JLabel dinero = new JLabel("0€");
		dinero.setBounds(184, 214, 45, 13);
		contentPane.add(dinero);

		dineroIntroducido = new JTextField();
		dineroIntroducido.setBounds(50, 210, 96, 19);
		contentPane.add(dineroIntroducido);
		dineroIntroducido.setColumns(10);

		JLabel texto = new JLabel("Introduzca cantidad");
		texto.setBounds(50, 186, 130, 13);
		contentPane.add(texto);
		JButton aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionaRecargas gr = new GestionaRecargas();
				
				int temp1 = monthChooser.getMonth();
				String temp2 = dineroIntroducido.getText();
				gr.setMes(temp1, temp2);
				int salida = gr.getMes(temp1);
				dinero.setText(salida + "€");
				
			}
		});
		aceptar.setBounds(130, 235, 85, 21);
		contentPane.add(aceptar);
	}
}
