package WaitYNotify;

public class Saludo {
	// Atributos:
	private boolean haLlegadoJefe;

	// Constructores:
	public Saludo() {
		this.haLlegadoJefe = false;
	}// Fin Constructor

	// Métodos:
	public synchronized void saludoEmpleado(String nombre) {
		try {
			if (!this.haLlegadoJefe) {
				wait();
				System.out.println("\n" + nombre.toUpperCase() + "-: Buenos días jefe.");	
			}else {
				System.out.println("\n" + nombre.toUpperCase() + "-: Disculpas por el retraso.");
			}//Fin Si
			
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} // Fin try
	}// Fin Procedimiento

	public synchronized void saludoJefe(String nombre) {
		System.out.println("\n******" + nombre.toUpperCase() + "-: Buenos días empleados. ******");
		this.haLlegadoJefe = true;
		notifyAll();
	}// Fin Procedimiento
}
