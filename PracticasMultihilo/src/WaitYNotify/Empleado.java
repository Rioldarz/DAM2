package WaitYNotify;

public class Empleado extends Thread{
	//Atributos:
	private String nombre;
	private Saludo saludo;
	private boolean esJefe;

	
	//Constructores:
	public Empleado(String nombre, Saludo saludo, boolean esJefe) {
//		super();
		this.nombre = nombre;
		this.saludo = saludo;
		this.esJefe = esJefe;
	}//Fin Constructor


	
	
	//Métodos:
	@Override
	public void run() {
		System.out.println(nombre + " llegó.");
		
		if (esJefe) {
			saludo.saludoJefe(nombre);
		}else {
			saludo.saludoEmpleado(nombre);
		}//Fin Si
	}//Fin Procedimiento
}
