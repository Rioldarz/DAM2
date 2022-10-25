package TestDebug;

public class Alumno {
	String nombre;
	int edad;
	double altura;
	
	public Alumno() {
		
	}
	
	public Alumno(String nombre1, int edad1, double altura1) {
		this.nombre = nombre1;
		this.edad = edad1;
		this.altura = altura1;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public String toString() {
		return getNombre()+" "+getEdad()+" "+getAltura();
	

}
}