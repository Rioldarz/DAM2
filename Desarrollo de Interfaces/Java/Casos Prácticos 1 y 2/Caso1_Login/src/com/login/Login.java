package com.login;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField insertaUsuario;
	private JPasswordField insertaContrasenia;
	private final JButton btnNewButton = new JButton("X");

	/**
	 * Launch the application.
	 */
	public void Inicio() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setLocationByPlatform(true);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnNewButton.setBackground(new Color(136, 212, 234));
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

		JLabel nombreEmpresa = new JLabel("ITEP");
		nombreEmpresa.setForeground(new Color(255, 255, 255));
		nombreEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		nombreEmpresa.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		nombreEmpresa.setBounds(490, 241, 296, 45);
		contentPane.add(nombreEmpresa);

		JLabel logoGrande = new JLabel("");
		logoGrande.setHorizontalAlignment(SwingConstants.CENTER);
		logoGrande.setIcon(new ImageIcon(Login.class.getResource("/com/images/logo.png")));
		logoGrande.setBounds(490, 59, 296, 184);
		contentPane.add(logoGrande);

		JLabel fotoCiudad = new JLabel("");
		fotoCiudad.setIcon(new ImageIcon(Login.class.getResource("/com/images/city.png")));
		fotoCiudad.setBounds(490, 0, 296, 473);
		contentPane.add(fotoCiudad);

		JLabel logoImagen = new JLabel("LOGO");
		logoImagen.setFont(new Font("Roboto Black", Font.PLAIN, 24));
		logoImagen.setHorizontalAlignment(SwingConstants.CENTER);
		logoImagen.setIcon(new ImageIcon(Login.class.getResource("/com/images/favicon.png")));
		logoImagen.setBounds(10, 10, 132, 65);
		contentPane.add(logoImagen);

		JLabel inicioSesion = new JLabel("INICIAR SESIÓN");
		inicioSesion.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		inicioSesion.setBounds(20, 86, 460, 45);
		contentPane.add(inicioSesion);

		JLabel usuario = new JLabel("USUARIO");
		usuario.setFont(new Font("Roboto Light", Font.BOLD, 14));
		usuario.setBounds(10, 156, 460, 29);
		contentPane.add(usuario);

		insertaUsuario = new JTextField();
		insertaUsuario.setForeground(new Color(192, 192, 192));
		insertaUsuario.setFont(new Font("Roboto Light", Font.PLAIN, 12));
		insertaUsuario.setText("");
		insertaUsuario.setBounds(10, 196, 460, 35);
		contentPane.add(insertaUsuario);
		insertaUsuario.setColumns(10);

		JSeparator separador = new JSeparator();
		separador.setBackground(new Color(0, 0, 0));
		separador.setBounds(10, 230, 460, 20);
		contentPane.add(separador);

		JLabel contrasenia = new JLabel("CONTRASEÑA");
		contrasenia.setFont(new Font("Roboto Light", Font.BOLD, 14));
		contrasenia.setBounds(10, 262, 460, 29);
		contentPane.add(contrasenia);

		JSeparator separador2 = new JSeparator();
		separador2.setBackground(Color.BLACK);
		separador2.setBounds(10, 330, 460, 20);
		contentPane.add(separador2);

		insertaContrasenia = new JPasswordField();
		insertaContrasenia.setText("");
		insertaContrasenia.setEchoChar('*');
		insertaContrasenia.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		insertaContrasenia.setForeground(new Color(192, 192, 192));
		insertaContrasenia.setToolTipText("");
		insertaContrasenia.setBounds(10, 301, 460, 29);
		contentPane.add(insertaContrasenia);

		JButton entrar = new JButton("ENTRAR");
		entrar.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		entrar.setBackground(new Color(0, 134, 255));
		entrar.setForeground(new Color(255, 255, 255));
		entrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (insertaUsuario.getText().equals("admin") && insertaContrasenia.getText().equals("1234")) {
					JFrame jFrame = new JFrame();
					JDialog jd = new JDialog(jFrame);
					jd.getContentPane().setLayout(new FlowLayout());
					jd.setBounds(500, 300, 400, 300);
					JLabel jLabel = new JLabel("Usuario Correcto");
					jd.getContentPane().add(jLabel);
					jd.setVisible(true);
				} else {
					JFrame jFrame = new JFrame();
					JDialog jd = new JDialog(jFrame);
					jd.getContentPane().setLayout(new FlowLayout());
					jd.setBounds(500, 300, 400, 300);
					JLabel jLabel = new JLabel("Usuario Incorrecto");
					jd.getContentPane().add(jLabel);
					jd.setVisible(true);
				} // Fin Si
			}//Fin acción
		});
		entrar.setBounds(20, 360, 119, 49);
		contentPane.add(entrar);
	}
}
