import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GuardaFichero {
	// Atributos:
	File ruta;
	FileWriter aEscribir;
	String cadenaAGuardar = "hola \nsoy \n";

	// Constructores:
	public GuardaFichero(String cadena) {
		this.cadenaAGuardar += cadena;
	}// Fin Constructor

	// Métodos:
	public void construyeFichero() {
		// Entorno:
		ruta = new File("/temp/darth.txt".replace('/', File.separatorChar));
		try {
			ruta.createNewFile();
		} catch (IOException e1) {
			System.err.println("No se pudo crear el archivo");
		} // Fin try
		System.out.println(ruta.getAbsolutePath());
		try {
			aEscribir = new FileWriter(ruta);

			aEscribir.write(cadenaAGuardar);
			aEscribir.close();
		} catch (IOException e) {
			System.err.println("Error E/S");
		} // Fin try
	}
}
