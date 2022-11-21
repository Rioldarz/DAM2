/**
 * Esta clase representa al Consumidor
 * @author Miguel Angel Rodríguez Dalí
 */
public class Consumidor extends Thread{
	private Buffer almacen;
	private int dormir;
	
	/**
	 * Constructor del consumidor
	 * @param almacen Buffer de donde se obtienen los recursos
	 * @param dormir Tiempo que dormirá el consumidor
	 */
	public Consumidor(Buffer almacen, int dormir) {
		this.almacen = almacen;
		this.dormir = dormir;
	}//Fin Constructor
	
	//Métodos:
	@Override
	public void run() {
		int valor = 0;
		for (int i = 0; i < 10; i++) {
			valor = almacen.get();
			System.out.println("Consumidor saca " + valor);
			try {
				sleep(dormir);
			}catch (InterruptedException e) {
				System.out.println("Error en el consumidor: " + e.toString());
			}//Fin try
		}//Fin Para
	}//Fin Procedimiento
}
