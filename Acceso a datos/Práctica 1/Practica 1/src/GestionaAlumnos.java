import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class GestionaAlumnos {
	// Atributos:
	File ruta, borrados;

	// Constructores:
	public GestionaAlumnos() {
		this.ruta = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Alumnos");
		this.ruta.mkdir();
		this.borrados = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\AlumnosBorrados");
		this.borrados.mkdir();
	}// Fin Constructor

	public GestionaAlumnos(String ruta) {
		this.ruta = new File(ruta);
		this.ruta.mkdir();
		this.borrados = new File(this.ruta + ".\\Borrados");
		this.ruta.mkdir();
	}// Fin Constructor

	// Métodos:
	public String getRuta() {
		return this.ruta.getAbsolutePath();
	}// Fin Función

	public void setRuta(String ruta) {
		this.ruta = new File(ruta);
		this.ruta.mkdir();
		this.borrados = new File(this.ruta + ".\\Borrados");
		this.ruta.mkdir();
	}// Fin Procedimiento

	public boolean crearAlumno(Alumno alu) {
		// Entorno:
		boolean retornar;
		FileWriter ficheroAGenerar;
		String datosAGuardar;

		// Algoritmo:
		retornar = true;

		try {
			ficheroAGenerar = new FileWriter(this.ruta + "\\" + alu.dni + ".txt");
			datosAGuardar = alu.getNombre() + ":" + alu.getPosicion() + ":" + alu.getNotaMedia() + ":" + alu.getDni()
					+ ":" + alu.getFoto();
			ficheroAGenerar.write(datosAGuardar);
			ficheroAGenerar.close();
		} catch (IOException e) {
			retornar = false;
		} // Fin try

		return retornar;
	}// Fin Función

	public boolean modificarAlumno(Alumno aluModificado) {
		// Entorno:
		// Algoritmo:
		return crearAlumno(aluModificado);
	}// Fin Función

	public boolean eliminarAlumno(Alumno alu) {
		// Entorno:
		File borrarEsto;

		// Algoritmo:
		borrarEsto = new File(this.ruta + "\\" + alu.dni + ".txt");

		backup(borrarEsto.toString(), this.borrados + "\\ultElem.txt");

		return borrarEsto.delete();
	}// Fin Función

	private boolean backup(String aCopiar, String aGenerar) {
		File origen = new File(aCopiar);
		File destino = new File(aGenerar);
		boolean salida = true;

		if (origen.exists()) {
			try {
				InputStream in = new FileInputStream(origen);
				OutputStream out = new FileOutputStream(destino);
				byte[] buf = new byte[1024];
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				} // Fin Mientras
				in.close();
				out.close();
				salida = true;
			} catch (IOException ioe) {
				ioe.printStackTrace();
				salida = false;
			} // Fin try
		} else {
			salida = false;
		} // Fin Si

		return salida;
	}// Fin Función

	public String listadoAlumnos() {
//		public Alumno[] listadoAlumnos() {
		// Entorno:
		String[] dnis, datos;
		BufferedReader lecturaActual;
//		Alumno[] salida;
		String salida;

		// Algoritmo:
		dnis = this.ruta.list();
//		salida = new Alumno[dnis.length];
		salida = "";
		for (int i = 0; i < dnis.length; i++) {
			try {
				lecturaActual = new BufferedReader(new FileReader(ruta.getAbsolutePath() + "\\" + dnis[i]));
				datos = lecturaActual.readLine().split(":");

				salida += "Nombre: " + datos[0] + "\n";
				salida += "Posición: " + datos[1] + "\n";
				salida += "Nota media: " + datos[2] + "\n";
				salida += "DNI: " + datos[3] + "\n";
				salida += "Imagen: " + datos[4] + "\n" + "\n";

//				salida[i] = new Alumno(datos[0], Integer.parseInt(datos[1]), Float.parseFloat(datos[2]), datos[3], (Imagen)datos[4]); //Arreglar lo de imagen
			} catch (FileNotFoundException e) {
				System.out.println("No pude ver al alumno con dni: " + dnis[i]);
			} catch (IOException e) {
				System.err.println("Error E/S");
			} // Fin try
		} // Fin Para

		return salida;
	}// Fin Función

	public Alumno busquedaAvanzada(String dni) {
		// Entorno:
		String[] dnis;
		BufferedReader alumnoLeido;
		Alumno devuelta;
		byte i;

		// Algoritmo:
		devuelta = null;
		dnis = this.ruta.list();

		i = 0;
		while (!dnis[i].equalsIgnoreCase(dni + ".txt") && i < dnis.length) {
			i++;
		} // Fin Mientras

		try {
			alumnoLeido = new BufferedReader(new FileReader(this.ruta.getAbsolutePath() + "\\" + dnis[i]));
			dnis = alumnoLeido.readLine().split(":");

			devuelta = new Alumno(dnis[0], Integer.parseInt(dnis[1]), Float.parseFloat(dnis[2]), dnis[3], dnis[4]);
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el Alumno con dni: " + dni);
		} catch (IOException e) {
			System.out.println("Error E/S");
		} // Fin Si

		return devuelta;
	}// Fin Función

	public boolean guardarDatosActuales() {
		return true;
	}// Fin Función

	public boolean borrarTodosLosDatos() {
		// Entorno:
		// Algoritmo:
		String[] archivos = this.ruta.list();
		for (int i = 0; i < archivos.length; i++) {
			File aDeletear = this.ruta;
			aDeletear = new File(aDeletear + "\\" + archivos[i]);
			aDeletear.delete();
		} // Fin Para

		archivos = this.borrados.list();
		for (int i = 0; i < archivos.length; i++) {
			File aDeletear = this.ruta;
			aDeletear = new File(aDeletear + "\\" + archivos[i]);
			aDeletear.delete();
		} // Fin Para

		return this.ruta.delete();
	}// Fin Función

	public Alumno recuperarUltimoElementoBorrado() {
		// Entorno:
		Alumno devolucion;
		BufferedReader fichero;
		String[] archivo;

		// Algoritmo:
		devolucion = null;
		try {
			fichero = new BufferedReader(new FileReader(this.borrados + "\\ultElem.txt"));

			archivo = fichero.readLine().split(":");
			devolucion = new Alumno(archivo[0], Integer.parseInt(archivo[1]), Float.parseFloat(archivo[2]), archivo[3],
					archivo[4]);
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo econtrar el último elemento");
		} catch (IOException e) {
			System.err.println("Error E/S");
		} // Fin try

		return devolucion;
	}// Fin Función
}
