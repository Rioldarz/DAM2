import java.util.LinkedList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Partido {
	// Atributos:
	private LinkedList<Equipo> equipos;
	private Jugador mejorMvp;
	private LinkedList<Short> mejores5PuntuacionesMvp;

	// Constructores:
	public Partido() {
		this.equipos = new LinkedList<Equipo>();
		this.mejores5PuntuacionesMvp = new LinkedList<Short>();
	}// Fin Constructor

	public Partido(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
		this.mejores5PuntuacionesMvp = new LinkedList<Short>();
		this.setMejorMvp();
		this.setMejores5PuntuacionesMvp(mejores5PuntuacionesMvp);
	}// Fin Constructor

	// Métodos:
	public LinkedList<Equipo> getEquipos() {
		return equipos;
	}// Fin Función

	public void setEquipos(Equipo equipete) {
		this.equipos.add(equipete);
	}// Fin Procedimiento

	public Jugador getMejorMvp() {
		return this.mejorMvp;
	}// Fin Función

	public void setMejorMvp() {
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		Collection<Jugador> e1 = this.equipos.get(0).getJugadores();
		Collection<Jugador> e2 = this.equipos.get(1).getJugadores();

		Iterator<Jugador> i1 = e1.iterator();
		while (i1.hasNext()) {
			jugadores.add(i1.next());
		} // Fin Mientras

		Iterator<Jugador> i2 = e2.iterator();
		while (i1.hasNext()) {
			jugadores.add(i2.next());
		} // Fin Mientras

		Collections.sort(jugadores, new OrdenaJugadores());

		this.mejorMvp = jugadores.get(0);
	}// Fin Procedimiento

	public LinkedList<Short> getMejores5PuntuacionesMvp() {
		return mejores5PuntuacionesMvp;
	}// Fin Función

	public void setMejores5PuntuacionesMvp(LinkedList<Short> mejores5PuntuacionesMvp) {
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		Collection<Jugador> e1 = this.equipos.get(0).getJugadores();
		Collection<Jugador> e2 = this.equipos.get(1).getJugadores();

		Iterator<Jugador> i1 = e1.iterator();
		while (i1.hasNext()) {
			jugadores.add(i1.next());
		} // Fin Mientras

		Iterator<Jugador> i2 = e2.iterator();
		while (i1.hasNext()) {
			jugadores.add(i2.next());
		} // Fin Mientras

		Collections.sort(jugadores, new OrdenaJugadores());

		for (int i = 0; i < 5; i++) {
			this.mejores5PuntuacionesMvp.add(jugadores.get(i).getMvp());
		}//Fin Para
	}// Fin Procedimiento

}
