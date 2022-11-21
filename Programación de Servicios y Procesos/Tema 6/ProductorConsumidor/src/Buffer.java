/**
 * Almacén de datos sin sincronización
 * @author Miguel Angel Rodríguez Dalí
 */
public class Buffer {
	private int contenido;
	
	/**
	 * Obtiene contenido del buffer
	 * @return contenido del buffer
	 */
	public int get() {
		return this.contenido;
	}//Fin Función
	
	/**
	 * Inserta un valor en el buffer
	 * @param value Valor para insertar
	 */
	public void put(int value) {
		this.contenido = value;
	}//Fin Procedimiento
}
