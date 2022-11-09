package sincronizados;

public class Counter {
	// Atributos:
	private boolean sincronizado;

	// Constructor:
	public Counter(boolean sincronizado) {
//		super();
		this.sincronizado = sincronizado;
	}//Fin Constructor


	//Métodos:
	public boolean isSincronizado() {
		return sincronizado;
	}//Fin Función
	
	public synchronized void mostrarNumerosSincronizado(int id, int n) {
		System.out.println("Inicio hilo " + id);
		for (int i = 0; i <= n; i++) {
			System.out.println(i);
		}//Fin Para
		System.out.println("Fin hilo " + id);
	}//Fin Procedimiento
	
	public void mostrarNumerosNoSincronizado(int id, int n) {
		System.out.println("Inicio hilo " + id);
		for (int i = 0; i <= n; i++) {
			System.out.println(i);
		}//Fin Para
		System.out.println("Fin hilo " + id);
	}//Fin Procedimiento
}
