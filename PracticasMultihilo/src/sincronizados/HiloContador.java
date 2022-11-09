package sincronizados;

public class HiloContador extends Thread {
	// Atributos:
	private int id;
	private Counter counter;
	private int n;

	// Constructor:
	public HiloContador(int id, int n, Counter counter) {
//		super();
		this.id = id;
		this.counter = counter;
		this.n = n;
	}// Fin Constructor

	// Métodos:
	@Override
	public void run() {
		if (this.counter.isSincronizado()) {
			this.counter.mostrarNumerosSincronizado(id, n);
		}else {
			this.counter.mostrarNumerosNoSincronizado(id, n);
		}//Fin Si
	}//Fin Procedimiento
}
