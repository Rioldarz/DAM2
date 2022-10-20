
public class Alumno {
	// Atributos:
	String nombre;
	Integer posicion;
	Float notaMedia;
	String foto;
	String dni;

	// Constructores:
	public Alumno() {
		this.nombre = "Sin nombre";
		this.posicion = null;
		this.notaMedia = null;
		this.foto = null;
		this.dni = "Sin DNI";
	}// Fin Constructor

	public Alumno(String nombre, Float notaMedia, String dni) {
		this.nombre = nombre;
		this.posicion = null;
		this.notaMedia = notaMedia;
		this.foto = null;
		this.dni = dni;
	}// Fin Constructor

	public Alumno(String nombre, Integer posicion, Float notaMedia, String dni, String foto) {
		this.nombre = nombre;
		this.posicion = posicion;
		this.notaMedia = notaMedia;
		this.foto = foto;
		this.dni = dni;
	}// Fin Constructor

	// Métodos:
	public String getNombre() {
		return nombre;
	}// Fin Función

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}// Fin Procedimiento

	public Integer getPosicion() {
		return posicion;
	}// Fin Función

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}// Fin Procedimiento

	public Float getNotaMedia() {
		return notaMedia;
	}// Fin Función

	public void setNotaMedia(Float notaMedia) {
		this.notaMedia = notaMedia;
	}// Fin Procedimiento

	public String getFoto() {
		return this.foto;
	}// Fin Función

	public void setFoto(String foto) {
		this.foto = foto;
	}// Fin Procedimiento

	public String getDni() {
		return dni;
	}// Fin Función

	public void setDni(String dni) {
		this.dni = dni;
	}// Fin Procedimiento

}
