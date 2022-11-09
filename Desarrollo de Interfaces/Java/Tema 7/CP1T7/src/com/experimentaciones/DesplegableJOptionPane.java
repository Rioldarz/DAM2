package com.experimentaciones;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DesplegableJOptionPane extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesplegableJOptionPane frame = new DesplegableJOptionPane();
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
	public DesplegableJOptionPane() {
	        String[] optionsToChoose = {"Apple", "Orange", "Banana", "Pineapple", "None of the listed"};

	        String getFavFruit = (String) JOptionPane.showInputDialog(
	                null,
	                "What fruit do you like the most?",
	                "Choose Fruit",
	                JOptionPane.QUESTION_MESSAGE,
	                null,
	                optionsToChoose,
	                optionsToChoose[3]);

	        System.out.println("Your chosen fruit: " + getFavFruit);
	}

}
