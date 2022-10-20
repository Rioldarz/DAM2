
public class aAjedrez {
	public static void main(String[] args) {
		// Entorno:
		Ajedrez jugador1, jugador2;

		// Algoritmo:
		jugador1 = new Ajedrez();
		jugador2 = new Ajedrez();

		System.out.println("Jugador 1 tiene " + jugador1.getCapturas() + " capturas :\n" + jugador1.toString() + "\n");
		System.out.println("Jugador 2 tiene " + jugador2.getCapturas() + " capturas :\n" + jugador2.toString() + "\n");

		System.out.println("Siendo sus puntuaciones totales:");
		System.out.println("Jugador 1 = " + jugador1.conseguirTotalPuntos());
		System.out.println("Jugador 2 = " + jugador2.conseguirTotalPuntos() + "\n");

		System.out.print("El resultado es: ");
		if (jugador1.conseguirTotalPuntos() > jugador2.conseguirTotalPuntos()) {
			System.out.println("¡Gana el jugador 1!");
		} else if (jugador1.conseguirTotalPuntos() < jugador2.conseguirTotalPuntos()) {
			System.out.println("¡Gana el jugador 2!");
		} else {
			System.out.println("¡EMPATE!");
		} // Fin Si
	}// Fin Programa
}
