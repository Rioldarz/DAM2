import java.util.LinkedList;

public class ArrayRealExtendido extends ArrayReal {
	// Atributos
	double[] array;

	// Constructor
	public ArrayRealExtendido(LinkedList<Double> vector) {
		super(vector);
	}// Fin Constructor

	// Métodos
	public double media() {
		// Entorno:
		double media;

		// Algoritmo:
		media = 0;
		for (int i = 0; i < super.getDoblesito().length; i++) {
			media += super.getDoblesito()[i];
		} // Fin Para
		media = media / super.getDoblesito().length;

		return media;
	}// Fin Función

}
