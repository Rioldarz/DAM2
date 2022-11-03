package com.vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Proveedores extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proveedores frame = new Proveedores();
					frame.setLocationRelativeTo(null);
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
	public Proveedores() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel texto = new JLabel("Nuestros proveedores son:");
		texto.setFont(new Font("Roboto Medium", Font.PLAIN, 28));
		texto.setBounds(30, 30, 350, 30);
		contentPane.add(texto);

		JList<Object> listaProveedores = new JList<Object>();
		listaProveedores.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listaProveedores.setFont(new Font("Roboto", Font.PLAIN, 28));
		listaProveedores.setModel(new AbstractListModel<Object>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] { "Azulejos Domínguez S.L.", "MercaMadrid S.A.", "Jesús Mosaiquería",
					"Cristales S.A." };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaProveedores.setBounds(30, 70, 350, 300);
		contentPane.add(listaProveedores);

		JLabel logoMarca = new JLabel("");
		logoMarca.setIcon(new ImageIcon(Proveedores.class.getResource("/com/recursos/R-removebg-preview_entre2.png")));
		logoMarca.setBounds(500, 30, 238, 262);
		contentPane.add(logoMarca);

		JButton atras = new JButton("Atrás");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.main(null);
			}
		});
		atras.setForeground(new Color(255, 255, 255));
		atras.setBackground(new Color(0, 128, 255));
		atras.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		atras.setBounds(30, 450, 85, 21);
		contentPane.add(atras);
	}
}
