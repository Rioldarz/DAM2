import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class aEjercicio10 {
	public static String leerTeclado() {
		// Entorno:
		BufferedReader teclado;
		String linea;

		// Algoritmo:
		teclado = new BufferedReader(new InputStreamReader(System.in));
		linea = null;

		try {
			linea = teclado.readLine();
		} catch (IOException e) {
			System.err.println("Error E/S");
		} // Fin try

		return linea;
	}// Fin Función

	public static void main(String[] args) {
		// Entorno:
		String ruta, palabra;
		GestionaFichero ficherete;

		// Algoritmo:
		ruta = null;
		ficherete = null;
		
		do {
			System.out.print("Introduzca la ruta del fichero: ");
			ruta = leerTeclado().replace('/', File.separatorChar);

			try {
				ficherete = new GestionaFichero(ruta);
			} catch (FileNotFoundException e) {
				System.out.println("El fichero que ha introducido no existe");
				ruta = null;
			} // Fin trys
		} while (ruta == null);

		palabra = null;
		do {
			System.out.print("Introduzca la palabra a buscar: ");
			palabra = leerTeclado();

			char[] comprobante = palabra.toUpperCase().toCharArray();
			byte i = 0;
			while (i < comprobante.length && comprobante[i] >= 65 && comprobante[i] <= 90) {
				i++;
			}//Fin Mientras
			
			if (i < comprobante.length) {
				palabra = null;
			}//Fin Si
		} while (palabra == null);
		
		ficherete.insertaPalabra(palabra);
		System.out.println(ficherete.cuentaPalabra());
	}// Fin Programa
}
