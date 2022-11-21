/**
 * @author Miguel Angel Rodríguez Dalí
 */
public class Main {

	public static void main(String[] args) {
		final int DORMIR_PRODCUTOR = 1000, DORMIR_CONSUMIDOR = 2000;
		
		Buffer almacen = new Buffer();
		Productor productor = new Productor(almacen, DORMIR_PRODCUTOR);
		Consumidor consumidor = new Consumidor(almacen, DORMIR_CONSUMIDOR);
		
		productor.start();
		consumidor.start();
	}//Fin Programa

}
