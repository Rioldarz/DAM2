/**
 * Almacén de datos sin sincronización
 * 
 * @author Miguel Angel Rodríguez Dalí
 */
public class Buffer {
	private int contenido;
	private boolean disponible = false;

	/**
	 * Obtiene contenido del buffer
	 * 
	 * @return contenido del buffer
	 */
	public synchronized int get() {
		// Mientras el buffer no esté disponible
		while (disponible == false) {
			try {
				// Me espero a que produzcan
				wait();
			} catch (InterruptedException e) {
			} // Fin try
		} // Fin Mientras
			// Cuando vuelve a estar disponible, notifico que lo está
		disponible = false;
		notify();
		return this.contenido;
	}// Fin Función

	/**
	 * Inserta un valor en el buffer
	 * 
	 * @param value Valor para insertar
	 */
	public synchronized void put(int value) {
		// Mientras el buffer esté disponible
		while (disponible == true) {
			try {
				wait();
			} catch (InterruptedException e) {
			} // Fin try
		} // Fin Mientras
			// Cuando vuelve a estar disponible, notifico que lo está
		contenido = value;
		disponible = true;
		notify();
	}// Fin Procedimiento
}
