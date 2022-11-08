package com.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jfugue.player.Player;

public class Main {

	private int xMouse, yMouse;
	private JFrame frame;
	private Player var = new Player();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				frame.setLocation(x - xMouse, y - yMouse);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();

			}
		});
		panel.setBounds(0, 0, 800, 30);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(Color.LIGHT_GRAY);
			}
		});
		panel_1.setBounds(750, 0, 50, 30);
		panel.add(panel_1);

		JLabel x = new JLabel("X");
		x.setFont(new Font("Dialog", Font.BOLD, 15));
		x.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(x);

		JButton botonDo = new JButton("DO");
		botonDo.setBackground(Color.WHITE);
		botonDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var.play("c");
			}
		});
		botonDo.setBounds(5, 30, 100, 570);
		frame.getContentPane().add(botonDo);

		JButton botonRe = new JButton("RE");
		botonRe.setBackground(Color.WHITE);
		botonRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var.play("d");
			}
		});
		botonRe.setBounds(120, 30, 100, 570);
		frame.getContentPane().add(botonRe);

		JButton botonMi = new JButton("MI");
		botonMi.setBackground(Color.WHITE);
		botonMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var.play("e");
			}
		});
		botonMi.setBounds(235, 30, 100, 570);
		frame.getContentPane().add(botonMi);

		JButton botonFa = new JButton("FA");
		botonFa.setBackground(Color.WHITE);
		botonFa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var.play("f");
			}
		});
		botonFa.setBounds(350, 30, 100, 570);
		frame.getContentPane().add(botonFa);

		JButton botonSol = new JButton("SOL");
		botonSol.setBackground(Color.WHITE);
		botonSol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var.play("g");
			}
		});
		botonSol.setBounds(465, 30, 100, 570);
		frame.getContentPane().add(botonSol);

		JButton botonLa = new JButton("LA");
		botonLa.setBackground(Color.WHITE);
		botonLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var.play("a");
			}
		});
		botonLa.setBounds(580, 30, 100, 570);
		frame.getContentPane().add(botonLa);

		JButton botonSi = new JButton("SI");
		botonSi.setBackground(Color.WHITE);
		botonSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var.play("b");
			}
		});
		botonSi.setBounds(695, 30, 100, 570);
		frame.getContentPane().add(botonSi);
	}
}
