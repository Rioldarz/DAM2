package com.vista;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.modelo.GestionaRecargas;
import com.toedter.calendar.JMonthChooser;
import java.awt.Font;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField dineroIntroducido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel fotoMetro = new JLabel("");
		fotoMetro.setIcon(new ImageIcon(Main.class.getResource("/com/resources/Metro_petit.jpg")));
		fotoMetro.setBounds(50, 50, 250, 125);
		contentPane.add(fotoMetro);

		JPanel panel = new JPanel();
		panel.setBounds(220, 178, 110, 30);
		contentPane.add(panel);

		JMonthChooser monthChooser = new JMonthChooser();
		panel.add(monthChooser);

		JLabel dinero = new JLabel("0€");
		dinero.setBounds(130, 212, 80, 13);
		contentPane.add(dinero);

		dineroIntroducido = new JTextField();
		dineroIntroducido.setBounds(20, 208, 96, 19);
		contentPane.add(dineroIntroducido);
		dineroIntroducido.setColumns(10);

		GestionaRecargas gr = new GestionaRecargas();

		JLabel texto = new JLabel("Introduzca cantidad");
		texto.setBounds(10, 186, 130, 13);
		contentPane.add(texto);
		JButton aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int temp1 = monthChooser.getMonth();
				String temp2 = dineroIntroducido.getText();
				gr.setMes(temp1, temp2);
				int salida = gr.getMes(temp1);

				dinero.setText(salida + "€");
			}
		});
		aceptar.setBounds(130, 235, 85, 21);
		contentPane.add(aceptar);

		JButton selecMes = new JButton("Seleccionar mes");
		selecMes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		selecMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int temp1 = monthChooser.getMonth();
				int salida = gr.getMes(temp1);
				dinero.setText(salida + "€");
			}
		});
		selecMes.setBounds(220, 209, 110, 23);
		contentPane.add(selecMes);
	}
}
