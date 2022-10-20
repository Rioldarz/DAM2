import java.util.LinkedList;

public class ArrayReal implements Recuentos {
	// Atributos
	double[] doblesito;

	// Constructores
	public ArrayReal(LinkedList<Double> vector) {
		doblesito = new double[vector.size()];
		for (short i = 0; i < vector.size(); i++) {
			doblesito[i] = vector.get(i);
		} // Fin Para
	}// Fin Constructor

	// Métodos
	@Override
	public double minimo() {
		// Entorno:
		double minimo;
		short i;

		// Algoritmo:
		minimo = Double.MAX_VALUE;

		for (i = 0; i < doblesito.length; i++) {
			if (doblesito[i] < minimo) {
				minimo = doblesito[i];
			} // Fin Si
		} // Fin Para

		return minimo;
	}// Fin Función

	@Override
	public double maximo() {
		// Entorno:
		double maximo;
		short i;

		// Algoritmo:
		maximo = Double.MIN_VALUE;

		for (i = 0; i < doblesito.length; i++) {
			if (doblesito[i] > maximo) {
				maximo = doblesito[i];
			} // Fin Si
		} // Fin Para

		return maximo;
	}// Fin Función

	@Override
	public double sumatorio() {
		// Entorno:
		double sumatorio;
		short i;

		// Algoritmo:
		sumatorio = 0;

		for (i = 0; i < doblesito.length; i++) {
			sumatorio += doblesito[i];
		} // Fin Para

		return sumatorio;
	}// Fin Función
}
