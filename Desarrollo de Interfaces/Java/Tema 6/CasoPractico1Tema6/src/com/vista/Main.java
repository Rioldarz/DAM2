package com.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

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
					Main frame = new Main();
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
	public Main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel texto = new JLabel("¿A qué desea acceder?");
		texto.setFont(new Font("Roboto Medium", Font.PLAIN, 28));
		texto.setBounds(250, 50, 300, 50);
		contentPane.add(texto);

		JButton clientes = new JButton("Clientes");
		clientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Interfaz1.main(null);
				Clientes.run();
			}
		});
		clientes.setForeground(new Color(255, 255, 255));
		clientes.setBackground(new Color(0, 128, 255));
		clientes.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		clientes.setBounds(75, 150, 300, 100);
		contentPane.add(clientes);

		JButton proveedores = new JButton("Proveedores");
		proveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proveedores.run();
			}
		});
		proveedores.setForeground(Color.WHITE);
		proveedores.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		proveedores.setBackground(new Color(0, 128, 255));
		proveedores.setBounds(450, 150, 300, 100);
		contentPane.add(proveedores);

		JButton pedidosPendientes = new JButton("Pedidos pendientes");
		pedidosPendientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PedidosPendientes.run();
			}
		});
		pedidosPendientes.setForeground(Color.WHITE);
		pedidosPendientes.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		pedidosPendientes.setBackground(new Color(0, 128, 255));
		pedidosPendientes.setBounds(75, 350, 300, 100);
		contentPane.add(pedidosPendientes);

		JButton pedidosPendientesDevolucion = new JButton("Devoluciones pendientes");
		pedidosPendientesDevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DevolucionesPendientes.run();
			}
		});
		pedidosPendientesDevolucion.setForeground(Color.WHITE);
		pedidosPendientesDevolucion.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		pedidosPendientesDevolucion.setBackground(new Color(0, 128, 255));
		pedidosPendientesDevolucion.setBounds(450, 350, 300, 100);
		contentPane.add(pedidosPendientesDevolucion);
	}
}
