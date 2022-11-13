package com.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);

//		JMenuBar menuBar = new JMenuBar();
//		JMenu menu = new JMenu("| | |");
//		JMenuItem size = new JMenu("Reservas");
//		JMenuItem reserva1 = new JMenu("28/11/12");
//		JMenuItem reserva2 = new JMenu("25/12/12");
//		menu.add(size);
//		size.add(reserva1);
//		size.add(reserva2);
//		menuBar.add(menu);
//		setJMenuBar(menuBar);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel direccion = new JLabel("Calle Agricultores, 99");
		direccion.setForeground(new Color(0, 200, 0));
		direccion.setBackground(Color.GREEN);
		direccion.setFont(new Font("Roboto", Font.PLAIN, 15));

		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(Main.class.getResource("/com/recursos/amore-s-italian-restaurant.jpg")));

		JLabel textoMain = new JLabel("Haz una reserva");
		textoMain.setForeground(Color.RED);
		textoMain.setFont(new Font("Roboto", Font.PLAIN, 28));

		JLabel dirPostalMain = new JLabel("DIRECCIÓN POSTAL");
		dirPostalMain.setForeground(Color.RED);
		dirPostalMain.setFont(new Font("Roboto", Font.PLAIN, 18));

		JLabel mailMain = new JLabel("CORREO ELECTRÓNICO");
		mailMain.setForeground(Color.RED);
		mailMain.setFont(new Font("Roboto", Font.PLAIN, 18));

		JLabel mail = new JLabel("tuitaliano@italiasi.com");
		mail.setForeground(new Color(0, 200, 0));
		mail.setFont(new Font("Roboto", Font.PLAIN, 15));
		mail.setBackground(Color.GREEN);

		JLabel telefonoMain = new JLabel("TELÉFONO");
		telefonoMain.setForeground(Color.RED);
		telefonoMain.setFont(new Font("Roboto", Font.PLAIN, 18));

		JLabel telefono = new JLabel("+34 999888999");
		telefono.setForeground(new Color(0, 200, 0));
		telefono.setFont(new Font("Roboto", Font.PLAIN, 15));
		telefono.setBackground(Color.GREEN);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contentPane, popupMenu);
		popupMenu.setBounds(0, 0, 5, 5);
		
		JMenuItem reservaciones = new JMenuItem("Reservas");
		popupMenu.add(reservaciones);
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textoMain, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(direccion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(dirPostalMain, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 230,
										Short.MAX_VALUE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(mail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(mailMain, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 230,
										Short.MAX_VALUE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(telefono, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(telefonoMain, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 230,
										Short.MAX_VALUE)))
				.addPreferredGap(ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
				.addComponent(imagen, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE).addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(imagen)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(textoMain).addGap(35)
								.addComponent(dirPostalMain).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(direccion, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(mailMain, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(mail, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(telefonoMain, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(telefono, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(154, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
