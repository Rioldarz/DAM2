import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Imagen {
	/* AWT Components declaration */
	private Frame frame1;
	private Label label1;
	private Label statusLabel;
	private Panel panel1;

	public Imagen() {
		showFrame();
	}

	/* Driver Code */
	public static void Ejecutar(String ruta) {
		Imagen obj = new Imagen();
		obj.showImageDemo(ruta);
	}

	/* Method to show Frame */
	private void showFrame() {
		frame1 = new Frame("Java AWT Examples");
		frame1.setSize(500, 500);
		frame1.setLayout(new GridLayout(3, 1));
		frame1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		label1 = new Label();
		label1.setAlignment(Label.CENTER);
		statusLabel = new Label();
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(350, 100);
		panel1 = new Panel();
		panel1.setLayout(new FlowLayout());
		frame1.add(label1);
		frame1.add(panel1);
		frame1.add(statusLabel);
		frame1.setVisible(true);
	}

	/* Method to add image on the Frame */
	private void showImageDemo(String rutaArchivo) {
		label1.setText("Image class Demo");

		panel1.add(new ImgComp(rutaArchivo));
		frame1.setVisible(true);
	}

	@SuppressWarnings("serial")
	class ImgComp extends Component {
		BufferedImage ig;

		public void paint(Graphics p) {
			p.drawImage(ig, 0, 0, null);
		}

		public ImgComp(String filepath) {
			try {
				ig = ImageIO.read(new File(filepath));
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		/* Sets the size of the image */
		public Dimension getPreferredSize() {
			if (ig == null) {
				return new Dimension(120, 200);
			} else {
				return new Dimension(ig.getWidth(), ig.getHeight());
			}
		}
	}
}