package WaitYNotify;

public class Principal {
	public static void main(String[] args) {
		//Entorno:
		Saludo s = new Saludo();
		Empleado e1, e2, e3, jefe;
		
		//Algoritmo:
		e1 = new Empleado("Pepe", s, false);
		e2 = new Empleado("José", s, false);
		e3 = new Empleado("Pedro", s, false);
		jefe = new Empleado("JEFE", s, true);
		
		e1.start();
		e2.start();
		e3.start();
		jefe.start();
	}//Fin Programa
}
