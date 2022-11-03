package com.vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
				Clientes.main(null);
			}
		});
		clientes.setForeground(new Color(255, 255, 255));
		clientes.setBackground(new Color(0, 128, 255));
		clientes.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		clientes.setBounds(100, 150, 250, 100);
		contentPane.add(clientes);
		
		JButton proveedores = new JButton("Proveedores");
		proveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proveedores.main(null);
			}
		});
		proveedores.setForeground(Color.WHITE);
		proveedores.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		proveedores.setBackground(new Color(0, 128, 255));
		proveedores.setBounds(450, 150, 250, 100);
		contentPane.add(proveedores);
		
		JButton pedidosPendientes = new JButton("Pedidos pendientes");
		pedidosPendientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PedidosPendientes.main(null);
			}
		});
		pedidosPendientes.setForeground(Color.WHITE);
		pedidosPendientes.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		pedidosPendientes.setBackground(new Color(0, 128, 255));
		pedidosPendientes.setBounds(100, 350, 250, 100);
		contentPane.add(pedidosPendientes);
		
		JButton pedidosPendientes_1 = new JButton("Pedidos pendientes");
		pedidosPendientes_1.setForeground(Color.WHITE);
		pedidosPendientes_1.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		pedidosPendientes_1.setBackground(new Color(0, 128, 255));
		pedidosPendientes_1.setBounds(0, 0, 250, 100);
		contentPane.add(pedidosPendientes_1);
	}
}
