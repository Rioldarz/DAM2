
public class Funciones {

	public static boolean esCapicua(long x) {
		return x == voltea(x);
	}// Fin Función

	public static Boolean esPrimo(long n) {
		// Entorno:
		boolean salida = true;

		// Algoritmo
		if (n < 2) {
			salida = false;
		} else {
			for (long i = n / 2; i >= 2; i--) {
				if (n % i == 0) {
					salida = false;
				} // Fin Si
			} // Fin Para
		} // Fin Si
		return salida;
	}// Fin Función

	public static int siguientePrimo(int x) {
		while (!esPrimo(++x))
			;
		return x;
	}// Fin Función

	public static double potencia(int base, int exponente) {
		if (exponente == 0) {
			return 1;
		} else if (exponente < 0) {
			return 1 / potencia(base, -exponente);
		} // Fin Si

		int n = 1;
		for (int i = 0; i < Math.abs(exponente); i++) {
			n = n * base;
		} // Fin Para

		return n;
	}// Fin Función

	public static int digitos(long x) {
		// Entorno:
		int n = 0;

		if (x < 0) {
			x = -x;
		} else if (x == 0) {
			return 1;
		} else {
			while (x > 0) {
				x = x / 10;
				n++;
			} // Fin Mientras
		} // Fin Si
		return n;
	}// Fin Función

	public static int digitoN(long x, int n) {
		x = voltea(x);

		while (n-- > 0) {
			x = x / 10;
		}//Fin Mientras

		return (int) (x % 10);
	}// Fin Función

	public static int posicionDeDigito(long x, int d) {
		//Entorno:
		int i, salida = -1;

		for (i = 0; (i < digitos(x)) && (digitoN(x, i) != d); i++) ;

		if (i != digitos(x)) {
			salida = i;
		}//Fin Si
		return salida;
	}// Fin Función

	public static long quitaPorDetras(long x, int n) {
		return x / (long) potencia(10, n);
	}// Fin Función

	public static long quitaPorDelante(long x, int n) {
		x = pegaPorDetras(x, 1);
		x = voltea(quitaPorDetras(voltea(x), n));
		x = quitaPorDetras(x, 1);
		return x;
	}// Fin Función

	public static long pegaPorDetras(long x, int d) {
		return juntaNumeros(x, d);
	}// Fin Función

	public static long pegaPorDelante(long x, int d) {
		return juntaNumeros(d, x);
	}// Fin Función

	public static long trozoDeNumero(long x, int inicio, int fin) {
		int longitud = digitos(x);
		x = quitaPorDelante(x, inicio);
		x = quitaPorDetras(x, longitud - fin - 1);
		return x;
	}// Fin Función

	public static long juntaNumeros(long x, long y) {
		return x * (long) potencia(10, digitos(y)) + y;
	}// Fin Función

	private static long voltea(long x) {
		//Entorno:
		long volteado = 0;
		
		//Algoritmo:
		if (x < 0) {
			return -voltea(-x);
		}//Fin Si

		while (x > 0) {
			volteado = (volteado * 10) + (x % 10);
			x = x / 10;
		}//Fin Mientras

		return volteado;
	}// Fin Función
}
