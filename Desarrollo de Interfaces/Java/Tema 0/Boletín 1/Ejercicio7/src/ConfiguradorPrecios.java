
public class ConfiguradorPrecios {
	// Atributos
	private float anchoBandera, altoBandera;
	private boolean escudo;
	private String localidadEnvio;

	// Constructores
	public ConfiguradorPrecios(float ancho, float alto, boolean escudo, String localidad) {
		this.anchoBandera = ancho;
		this.altoBandera = alto;
		this.escudo = escudo;
		this.localidadEnvio = localidad;
	}// Fin Constructor

	// Metodos
	public float precioBandera() {
		return this.anchoBandera * this.altoBandera / 100;
	}// Fin Función

	public float precioEscudo() {
		// Entorno:
		float precio;

		// Algoritmo:
		precio = 0;
		if (this.escudo) {
			precio = 375;
		} // Fin Si

		return precio / 100;
	}// Fin Función

	public float gastoEnvio() {
		// Entorno:
		float precio;

		// Algoritmo:
		precio = 0;
		if (!this.localidadEnvio.equalsIgnoreCase("SEVILLA")) {
			precio = 425;
		} // Fin Si

		return precio / 100;
	}// Fin Función

	public float calculaPrecioTotal() {
		// Entorno:
		float precio;

		// Algoritmo:
		precio = precioBandera() + precioEscudo() + gastoEnvio();
		return precio;
	}// Fin Función
}
