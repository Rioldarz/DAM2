package com.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Interfaz1 extends JFrame {

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
					Interfaz1 frame = new Interfaz1();
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
	public Interfaz1() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel clientes = new JLabel("Clientes de la empresa:");
		clientes.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		clientes.setBounds(30, 30, 155, 15);
		contentPane.add(clientes);

		JList<Object> listaClientes = new JList<Object>();
		listaClientes.setBackground(new Color(240, 240, 240));
		listaClientes.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		listaClientes.setModel(new AbstractListModel<Object>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"Amazon", "AliExpress"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaClientes.setBounds(30, 70, 155, 155);
		contentPane.add(listaClientes);

		JLabel proveedores = new JLabel("Proveedores de la empresa:");
		proveedores.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		proveedores.setBounds(230, 30, 180, 15);
		contentPane.add(proveedores);
		
		JList<Object> listaProveedores = new JList<Object>();
		listaProveedores.setBackground(new Color(240, 240, 240));
		listaProveedores.setModel(new AbstractListModel<Object>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"Azulejos Gonzalez SL", "Mercado mosaico SA"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaProveedores.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		listaProveedores.setBounds(230, 70, 180, 155);
		contentPane.add(listaProveedores);
		
		JLabel pedidosPendientes = new JLabel("Pedidos pendientes de tramitar:");
		pedidosPendientes.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		pedidosPendientes.setBounds(450, 30, 210, 15);
		contentPane.add(pedidosPendientes);
		
		JList<Object> listaPedidosPendientes = new JList<Object>();
		listaPedidosPendientes.setModel(new AbstractListModel<Object>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"Azulejos marmitako x 12", "Mosaico guepardo x 200"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaPedidosPendientes.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		listaPedidosPendientes.setBackground(SystemColor.menu);
		listaPedidosPendientes.setBounds(450, 70, 210, 155);
		contentPane.add(listaPedidosPendientes);
		
		JLabel devolucionesPendientes = new JLabel("Devoluciones pendientes de tramitar:");
		devolucionesPendientes.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		devolucionesPendientes.setBounds(30, 260, 245, 15);
		contentPane.add(devolucionesPendientes);
		
		JList<Object> listaDevolucionesPendientes = new JList<Object>();
		listaDevolucionesPendientes.setModel(new AbstractListModel<Object>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"Azulejos azules x 130", "Mosaico escarabajo x 24"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaDevolucionesPendientes.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		listaDevolucionesPendientes.setBackground(SystemColor.menu);
		listaDevolucionesPendientes.setBounds(30, 310, 245, 155);
		contentPane.add(listaDevolucionesPendientes);
		
		JLabel logoEmpresa = new JLabel("");
		logoEmpresa.setIcon(new ImageIcon(Interfaz1.class.getResource("/com/recursos/R-removebg-preview_entre2.png")));
		logoEmpresa.setBounds(450, 260, 238, 262);
		contentPane.add(logoEmpresa);
	}
}
