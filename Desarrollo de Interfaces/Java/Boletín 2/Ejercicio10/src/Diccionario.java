import java.util.HashMap;
import java.util.Map.Entry;

public class Diccionario {
	// Atributos:
	private HashMap<String, String> espaniolIngles;

	// Constructor:
	public Diccionario() {
		this.espaniolIngles = new HashMap<String, String>(20);
	}// Fin Constructor

	// Métodos:
	public boolean aniadir(String esp, String ing) {
		// Entorno:
		boolean esta;
		String espNuevo, ingNuevo;

		// Algoritmo:
		esta = false;
		espNuevo = esp.substring(0, 1).toUpperCase();
		espNuevo += esp.substring(1).toLowerCase();
		ingNuevo = ing.substring(0, 1).toUpperCase();
		ingNuevo += ing.substring(1).toLowerCase();

		if (this.espaniolIngles.get(esp) == null) {
			this.espaniolIngles.put(espNuevo, ingNuevo);
		} else {
			esta = true;
		} // Fin Si

		return !esta;
	}// Fin Función

	public String buscaSinonimos(String esp) {
		// Entorno:
		String devolucion;
		String espNuevo;

		// Algoritmo:
		devolucion = "";
		espNuevo = esp.substring(0, 1).toUpperCase();
		espNuevo += esp.substring(1).toLowerCase();

		if (this.espaniolIngles.get(espNuevo) != null) {
			String ing = this.espaniolIngles.get(espNuevo);
			for (Entry<String, String> i : espaniolIngles.entrySet()) {
				if (i.getValue().equalsIgnoreCase(ing)) {
					devolucion += i.getKey() + ", ";
				} // Fin Si
			} // Fin Para
			if (devolucion.lastIndexOf(',') < 10) { // quizas con split
				devolucion = "No conozco sinónimos de esa palabra  ";
			} // Fin Si
		} else {
			devolucion = "No conozco esa palabra  ";
		} // Fin Si

		return devolucion.substring(0, devolucion.length() - 2);
	}// Fin Función
}
