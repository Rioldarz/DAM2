import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xMouse, yMouse;
	private JFrame frame;

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
	 * Create the frame.
	 */
	public Main() {
		frame = new JFrame();
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

		JProgressBar velocidadAsignada = new JProgressBar();
		velocidadAsignada.setMaximum(50);
		velocidadAsignada.setBounds(30, 110, 115, 15);
		frame.getContentPane().add(velocidadAsignada);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 50, 25));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner.setBounds(30, 80, 115, 20);
		frame.getContentPane().add(spinner);
		spinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				velocidadAsignada.setValue((int) spinner.getValue());
			}
		});

		JLabel textoVel = new JLabel("Velocidad del ratón");
		textoVel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoVel.setBounds(30, 50, 121, 15);
		frame.getContentPane().add(textoVel);
		
		JLabel raton = new JLabel("");
		raton.setIcon(new ImageIcon(Main.class.getResource("/com/recursos/725ab3c4-fc40-4a26-af32-600c2678d118 (2).jpg")));
		raton.setBounds(400, 123, 313, 319);
		frame.getContentPane().add(raton);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Izquierdo", "Derecho"}));
		comboBox.setBounds(400, 80, 120, 20);
		frame.getContentPane().add(comboBox);
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getItem().toString().equalsIgnoreCase("izquierdo")) {
					raton.setIcon(new ImageIcon(Main.class.getResource("/com/recursos/725ab3c4-fc40-4a26-af32-600c2678d118 (2).jpg")));
				}else {
					raton.setIcon(new ImageIcon(Main.class.getResource("/com/recursos/725ab3c4-fc40-4a26-af32-600c2678d118_2 (1).jpg")));
				}
			}
		});
		
		JLabel textoSel = new JLabel("Botón seleccionado");
		textoSel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoSel.setBounds(400, 50, 120, 15);
		frame.getContentPane().add(textoSel);
		
		
	}
}
