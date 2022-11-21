/**
 * Esta clase es el productor
 * @author Miguel Angel Rodríguez Dalí
 */
public class Productor extends Thread{
	private Buffer almacen;
	private int dormir;
	
	/**
	 * Constructor del productor
	 * @param almacen Buffer donde se producen los recursos
	 * @param dormir Tiempo que dormirá el productor
	 */
	public Productor(Buffer almacen, int dormir) {
		this.almacen = almacen;
		this.dormir = dormir;
	}//Fin Constructor
	
	//Métodos:
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			almacen.put(i);
			System.out.println("Productor pone " + i);
			try {
				sleep(this.dormir);
			} catch (Exception e) {
				System.out.println("Error en el productor: " + e.toString());
			}//Fin try
		}//Fin Para
	}//Fin Procedimiento
}
