import java.util.Comparator;

public class OrdenaJugadores implements Comparator<Jugador> {

	@Override
	public int compare(Jugador o1, Jugador o2) {
//		return o1.getMvp() - o2.getMvp();
		return o2.getMvp() - o1.getMvp();
	}// Fin Función

}
