import java.util.HashMap;

public class Diccionario {
	// Atributos:
	HashMap<String, String> palabras;

	// Constructor:
	public Diccionario() {
		palabras = new HashMap<String, String>();
		palabras.put("Comer", "Eat");
		palabras.put("Matar", "Kill");
		palabras.put("Joder", "Fuck");
		palabras.put("Cagar", "Poop");
		palabras.put("Asesino", "Murder");
		palabras.put("Fantasma", "Ghost");
		palabras.put("Videojuego", "Videogame");
		palabras.put("Leon", "Lion");
		palabras.put("Raton", "Mouse");
		palabras.put("Teclado", "Keyboard");
		palabras.put("Avispa", "Wasp");
		palabras.put("Musculo", "Muscle");
	}// Fin Constructor

	// Métodos:
	public String consulta(String palabra) {
		// Entorno:
		String devolver;

		// Algoritmo:
		devolver = null;
		String nueva = palabra.substring(0, 1).toUpperCase();
		nueva += palabra.substring(1).toLowerCase();
		if (this.palabras.get(nueva) != null) {
			devolver = this.palabras.get(nueva);
		} // Fin Si

		return devolver;
	}// Fin Función
}
