
public class Pokemon {
	// Atributos:
	private String descripcion;
	private String habilidad;

	// Constructores:
	public Pokemon() {
	} // Fin constructor

	public Pokemon(String desc, String hab) {
		this.descripcion = desc;
		this.habilidad = hab;
	}// Fin Constructor

	// Métodos:
	public String getDescripcion() {
		return this.descripcion;
	}// Fin Función

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}// Fin Procedimiento

	public String getHabilidad() {
		return habilidad;
	}// Fin Función

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}// Fin Procedimiento

}
