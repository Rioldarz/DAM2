import java.util.ArrayList;
import java.util.Random;

public class Mesas {
	// Atributos:
	private ArrayList<Byte> mesas;

	// Constructores:
	public Mesas() {
		this.mesas = new ArrayList<Byte>();
		Random aleatorio = new Random();

		for (int i = 0; i < 10; i++) {
			byte temp = (byte) aleatorio.nextInt(5);
			this.mesas.add(temp);
		} // Fin Para
	}// Fin Constructor

	// Métodos:
	public String generaSalida() {
		String salida;
		salida = "---------------------------------------------------------------------------------------------------\n";
		salida += "|Mesa nº	|	1|	2|	3|	4|	5|	6|	7|	8|	9|	10|\n";
		salida += "---------------------------------------------------------------------------------------------------\n";
		salida += "|Ocupación	|	";

		for (int i = 0; i < mesas.size() - 1; i++) {
			salida += mesas.get(i) + "|\t";
		} // Fin Para
		salida += " " + mesas.get(9) + "|";

		salida += "\n";
		salida += "---------------------------------------------------------------------------------------------------\n";

		return salida;
	}// Fin Función

	public String insertaGrupo(byte grupo) {
		String salida = "";
		byte i = 0;

		while (i < 10 && mesas.get(i) != 0) {
			i++;
		} // Fin Mientras

		if (i < 10 && grupo <= 4 && mesas.get(i) == 0) {
			byte temp = mesas.get(i);
			mesas.remove(i);
			mesas.add(i, (byte) (temp + grupo));
			salida = "Por favor, siéntese en la mesa número " + (i + 1);
		} else if (grupo > 4) {
			salida = "Lo siento, no admitimos grupos de " + grupo + ", haga grupos de 4 "
					+ "personas como máximo e intente de nuevo";
		} else {
			i = 0;

			while (i < 10 && mesas.get(i) + grupo > 4) {
				i++;
			} // Fin Mientras

			if (i < 10) {
				byte temp = mesas.get(i);
				mesas.remove(i);
				mesas.add(i, (byte) (temp + grupo));
				salida = "Por favor, siéntese en la mesa número " + (i + 1);
			} else {
				salida = "Lo siento, en estos momentos no queda sitio";
			} // Fin Si
		} // Fin Si

		return salida;
	}//Fin Función
}
