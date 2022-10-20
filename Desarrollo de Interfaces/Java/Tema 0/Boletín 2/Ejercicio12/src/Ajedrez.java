import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class Ajedrez {
	// Atributos:
	private HashMap<String, Byte> piezas;
	private byte capturas;

	// Constructores:
	public Ajedrez() {
		// Entorno:
		Random numerete = new Random();
		this.piezas = new HashMap<String, Byte>();

		// Algoritmo:
		this.capturas = (byte) numerete.nextInt(16);
		generaPiezas(capturas);
	}// Fin Constructor

	// Métodos:
	public byte getCapturas() {
		return this.capturas;
	}// Fin Función

	private void generaPiezas(byte num) {
		Random numero = new Random();
		byte damas, torres, alfiles, caballos, peones;

		do {
			damas = (byte) numero.nextInt(2);
			torres = (byte) numero.nextInt(3);
			alfiles = (byte) numero.nextInt(3);
			caballos = (byte) numero.nextInt(3);
			peones = (byte) numero.nextInt(9);
		} while (damas + torres + alfiles + caballos + peones != this.capturas);

		this.piezas.put("Dama", damas);
		this.piezas.put("Torre(s)", torres);
		this.piezas.put("Alfil(es)", alfiles);
		this.piezas.put("Caballo(s)", caballos);
		this.piezas.put("Peón(es)", peones);
	}// Fin Procedimiento

	public byte conseguirTotalPuntos() {
		// Entorno:
		Collection<Byte> col = piezas.values();
		byte salida = 0;
		byte noDeberiaExistir = 0;

		// Algoritmo:
		for (Iterator<Byte> iterator = col.iterator(); iterator.hasNext();) {
			if (noDeberiaExistir == 0) {
				salida += iterator.next() * 9;
			} else if (noDeberiaExistir == 1) {
				salida += iterator.next() * 5;
			} else if (noDeberiaExistir == 2) {
				salida += iterator.next() * 3;
			} else if (noDeberiaExistir == 3) {
				salida += iterator.next() * 2;
			} else {
				salida += iterator.next();
			} // Fin Si
			noDeberiaExistir++;
		} // Fin Para

		return salida;
	}// Fin Función

	@Override
	public String toString() {
		// Entorno:
		String salida, formato[];
		byte i = 0;

		// Algoritmo:
		salida = this.piezas.toString();
		salida = salida.replace("{", "");
		salida = salida.replace("}", "");
		salida = salida.replaceAll(",", "");
		salida = salida.replaceAll(" ", ":");
		salida = salida.replaceAll("=", " ");
		formato = salida.split(":");

		salida = "";
		for (i = 0; i < formato.length - 1; i++) {
			salida += formato[i] + ", ";
		} // Fin Para
		salida += formato[i];

		return salida;
	}// Fin Función
}