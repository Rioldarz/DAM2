import java.util.LinkedList;

public class aEjercicio8 {
	public static void main(String[] args) throws Exception {
		// Entorno:
		Equipo eq1, eq2;
		LinkedList<Jugador> jugadores;
		LinkedList<Equipo> equipos;
		Partido partidete;

		// Algoritmo:
		jugadores = new LinkedList<>();
		for (int i = 0; i < 11; i++) {
			if (i < 4) {
				if (i == 2) {
					jugadores.add(new Jugador("Defensa", (byte) i, (byte) (i * 2), (byte) (i * 3), (byte) 1));
				} else {
					jugadores.add(new Jugador("Defensa", (byte) i, (byte) (i * 2), (byte) (i * 3), (byte) 0));
				} // Fin Si
			} else if (i < 11) {
				if (i == 8) {
					jugadores.add(new Jugador("Delantero", (byte) i, (byte) (i * 2), (byte) (i * 3), (byte) 1));
				} else {
					jugadores.add(new Jugador("Delantero", (byte) i, (byte) (i * 2), (byte) (i * 3), (byte) 0));
				} // Fin Si
			} else {
				jugadores.add(new Jugador("Portero", (byte) 12, (byte) 3, (byte) 1, (byte) 0, (byte) 5));
			} // Fin Si
		} // Fin Para
		eq1 = new Equipo("España", jugadores);

		jugadores = new LinkedList<>();
		for (int i = 0; i < 11; i++) {
			if (i < 4) {
				if (i == 2) {
					jugadores.add(new Jugador("Defensa", (byte) i, (byte) (i * 3), (byte) (i * 2), (byte) 1));
				} else {
					jugadores.add(new Jugador("Defensa", (byte) i, (byte) (i * 3), (byte) (i * 2), (byte) 0));
				} // Fin Si
			} else if (i < 11) {
				if (i == 8) {
					jugadores.add(new Jugador("Delantero", (byte) i, (byte) (i * 3), (byte) (i * 2), (byte) 1));
				} else {
					jugadores.add(new Jugador("Delantero", (byte) i, (byte) (i * 3), (byte) (i * 2), (byte) 0));
				} // Fin Si
			} else {
				jugadores.add(new Jugador("Portero", (byte) 9, (byte) 7, (byte) 0, (byte) 0, (byte) 8));
			} // Fin Si
		} // Fin Para
		eq2 = new Equipo("Francia", jugadores);

		equipos = new LinkedList<Equipo>();
		equipos.add(eq1);
		equipos.add(eq2);
		partidete = new Partido(equipos);

		Jugador muestra = partidete.getMejorMvp();
		System.out.println("Tipo: " + muestra.getTipo() + "\n" + "Pases: " + muestra.getPases() + "\n"
				+ "Recuperaciones: " + muestra.getRecuperaciones() + "\n" + "Goles: " + muestra.getGoles() + "\n"
				+ "Paradas: " + muestra.getParadas() + "\n" + "Tarjetas rojas: " + muestra.getTarjetasRojas() + "\n"
				+ "Mvp: " + muestra.getMvp() + "\n");
		LinkedList<Short> jugui = partidete.getMejores5PuntuacionesMvp();
		for (int i = 0; i < jugui.size(); i++) {
			System.out.println(jugui.get(i));
		} // Fin Para
	}// Fin Programa
}
