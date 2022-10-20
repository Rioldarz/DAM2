import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GestionaFichero {
	// Atributos:
	private File ruta;
	private FileReader lector;
	private BufferedReader lectorLinea;
	private String palabra, linea;
	private byte contador;

	// Constructor:
	public GestionaFichero(String ruta) throws FileNotFoundException {
		this.ruta = new File(ruta);
		this.compruebaRuta();
	}// Fin Constructor

	// Métodos:
	private void compruebaRuta() throws FileNotFoundException {
		// Entorno:
		// Algoritmo:
		lector = new FileReader(ruta);
	}// Fin Procedimiento

	public void insertaPalabra(String palabra) {
		this.palabra = palabra;
	}//Fin Procedimiento
	
	public byte cuentaPalabra() {
		// Entorno:
		// Algoritmo:
		this.contador = 0;
		this.lectorLinea = new BufferedReader(lector);

		try {
			while (this.lectorLinea.ready()) {
				this.linea = this.lectorLinea.readLine();
				if (this.linea.equalsIgnoreCase(this.palabra)) {
					this.contador++;
				} // Fin Si
			} // Fin Mientras
		} catch (IOException e) {
			System.err.println("Error E/S");
		}//Fin try
		
		return this.contador;
	}//Fin Función
}
