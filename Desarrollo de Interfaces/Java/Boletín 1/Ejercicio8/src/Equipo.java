import java.util.LinkedList;

public class Equipo {
	// Atributos:
	private String equipo;
	private LinkedList<Jugador> jugadores;

	// Constructores:
	public Equipo() {
		this.jugadores = new LinkedList<Jugador>();
	}// Fin Constructor

	public Equipo(String equipo) {
		this.jugadores = new LinkedList<Jugador>();
		this.equipo = equipo;
	}// Fin Constructor

	public Equipo(String equipo, LinkedList<Jugador> jugadores) {
		this.jugadores = new LinkedList<Jugador>();
		this.equipo = equipo;
		this.jugadores = jugadores;
	}// Fin Constructor

	// Métodos:
	public String getEquipo() {
		return equipo;
	}// Fin Función

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}// Fin Procedimiento

	public LinkedList<Jugador> getJugadores() {
		return jugadores;
	}// Fin Función

	public void setJugadores(Jugador jugadorsete) {
		this.jugadores.add(jugadorsete);
	}// Fin Procedimiento

}
