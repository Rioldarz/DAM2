import java.util.HashMap;

public class GestionaAnfibios {
	// Atributos:
	private HashMap<String, Pokemon> diccionario;

	// Constructores:
	public GestionaAnfibios() {
		// Entorno:
		Pokemon pokimones;

		// Algoritmo:
		diccionario = new HashMap<String, Pokemon>();

		pokimones = new Pokemon("Hace blublublu", "Te da un guantazo mojado con toda la mano abierta");
		diccionario.put("Agua", pokimones);

		pokimones = new Pokemon("Hace piupiupiu", "Te da un llamarazo que te deja fritísimo");
		diccionario.put("Fuego", pokimones);

		pokimones = new Pokemon("Hace rombombom", "Te provoca un terremoto que te deja abierto en 5 partes");
		diccionario.put("Tierra", pokimones);

		pokimones = new Pokemon("Hace fssfsfsfssss", "Te sopla tan fuerte que te deja sordo, te hincha y te mata");
		diccionario.put("Aire", pokimones);
	}// Fin Constructor

	// Métodos:
	public HashMap<String, Pokemon> getDiccionario() {
		return this.diccionario;
	}// Fin Función

	public void aniadirAnfibio(String tipo, Pokemon datos) {
		this.diccionario.put(tipo.substring(0, 1).toUpperCase() + tipo.substring(1).toLowerCase(), datos);
	}// Fin Procedimiento

	public void muestraTipo(String tipo) {
		if (this.diccionario.get(tipo.substring(0, 1).toUpperCase() + tipo.substring(1).toLowerCase()) != null) {
			System.out.println("Del tipo: " + tipo.substring(0, 1).toUpperCase() + tipo.substring(1).toLowerCase());
			System.out.println("Tiene de descripción: " + this.diccionario
					.get(tipo.substring(0, 1).toUpperCase() + tipo.substring(1).toLowerCase()).getDescripcion());
			System.out.println("Tiene de habilidad: " + this.diccionario
					.get(tipo.substring(0, 1).toUpperCase() + tipo.substring(1).toLowerCase()).getHabilidad());
		} else {
			System.out.println("Ese tipo de anfibio no existe");
		} // Fin Si
	}// Fin Procedimiento

}
