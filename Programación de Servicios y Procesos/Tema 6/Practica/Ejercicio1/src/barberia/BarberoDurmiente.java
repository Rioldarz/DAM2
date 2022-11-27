package barberia;

public class BarberoDurmiente {

	public static void main(String[] args) {
		Barbero b = new Barbero(false);
		for (int i = 0; i < 7; i++) {
			Cliente c = new Cliente(i + 1, b);
			c.start();
		} // Fin Para
	}// Fin Programa
}

class Barbero {
	// Atributos
	private boolean sillaOcupada = false;
	private boolean pelando;
	private boolean barberoDormido = true;

	// Constructor
	public Barbero(boolean pelando) {
		this.pelando = pelando;
	}// Fin Constructor

	// Métodos:
	public synchronized void pillarSitio(int nCliente) {
		while (sillaOcupada) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // Fin try
		} // Fin Mientras
		sillaOcupada = true;
		System.out.println("El cliente: " + nCliente + " ha ocupado la silla");
	}// Fin Procedimiento

	public synchronized void dejarSitio(int nCliente) {
		while (esPelando()) {
			try {
				wait();
			} catch (InterruptedException e) {
			} // Fin try
		} // Fin Mientras
		System.out.println("El cliente: " + nCliente + " deja libre la silla");
		sillaOcupada = false;
		notifyAll();
	}// Fin Procedimiento

	public synchronized void empezar(int nCliente) {
		barberoDormido = true;
		System.out.println("El cliente: " + nCliente + " despierta al barbero");
		notifyAll();

		while (esPelando()) {
			barberoDormido = false;
			System.out.println("El barbero esta pelando." + " El cliente: " + nCliente + " espera.");

			try {
				wait();
			} catch (InterruptedException e) {
			} // Fin try
		} // Fin Mientras

		this.setPelando(true); // el barbero empieza y cuando deje de pelar se pondr� a pelar a otro cliente
		System.out.println("El barbero esta empezando a cortar los pelos al cliente: " + nCliente);
		notifyAll();
	}// Fin Procedimiento

	public synchronized void acabar(int nCliente) {
		barberoDormido = true;
		this.setPelando(false);
		System.out.println("El barbero ha acabado el pelado del cliente: " + nCliente);
		notifyAll();
		barberoDormido = false;
		System.out.println("Barbero se duerme.");
	}// Fin Procedimiento

	public boolean esPelando() {
		return pelando;
	}// Fin Función

	public void setPelando(boolean pelando) {
		this.pelando = pelando;
	}// Fin Procedimiento

}

class Cliente extends Thread {
	// Atributos:
	private Barbero b;
	private int nCliente;

	// Constructores:
	public Cliente(int nCliente, Barbero b) {
		this.b = b;
		this.nCliente = nCliente;
	}// Fin Consctructor

	@Override
	public void run() {
		try {
			b.pillarSitio(nCliente);
			b.empezar(nCliente);
			sleep(1000);
			b.acabar(nCliente);
			b.dejarSitio(nCliente);
		} catch (InterruptedException e) {
		} // Fin try
	}// Fin Procedimiento
}
