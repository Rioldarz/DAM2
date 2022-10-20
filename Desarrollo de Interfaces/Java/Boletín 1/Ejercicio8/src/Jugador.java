
public class Jugador {
	// Atributos:
	private String tipo;
	private byte pases, recuperaciones, goles, paradas, tarjetasRojas;
	private short mvp;

	// Constructores:
	public Jugador() {
		this.tipo = "";
		this.pases = 0;
		this.recuperaciones = 0;
		this.goles = 0;
		this.paradas = 0;
		this.tarjetasRojas = paradas;
		this.mvp = 0;
	}// Fin Constructor

	public Jugador(String tipo, byte pases, byte recuperaciones, byte goles, byte tarjetasRojas) throws Exception {
		if (tipo.equalsIgnoreCase("defensa") || tipo.equalsIgnoreCase("delantero")
				|| tipo.equalsIgnoreCase("portero")) {
			this.tipo = tipo.substring(0, 1).toUpperCase() + tipo.substring(1).toLowerCase();
			this.pases = pases;
			this.recuperaciones = recuperaciones;
			this.goles = goles;
			this.paradas = 0;
			this.tarjetasRojas = paradas;
			this.setMvp();
		} else {
			throw new Exception("No es un jugador válido");
		} // Fin Si
	}// Fin Constructor

	public Jugador(String tipo, byte pases, byte recuperaciones, byte goles, byte paradas, byte tarjetasRojas)
			throws Exception {
		if (tipo.equalsIgnoreCase("defensa") || tipo.equalsIgnoreCase("delantero")
				|| tipo.equalsIgnoreCase("portero")) {
			this.tipo = tipo.substring(0, 1).toUpperCase() + tipo.substring(1).toLowerCase();
			this.pases = pases;
			this.recuperaciones = recuperaciones;
			this.goles = goles;
			this.paradas = paradas;
			this.tarjetasRojas = paradas;
			this.setMvp();
		} else {
			throw new Exception("No es un jugador válido");
		} // Fin Si
	}// Fin Constructor

	// Métodos:
	public String getTipo() {
		return tipo;
	}// Fin Función

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}// Fin Procedimiento

	public byte getPases() {
		return pases;
	}// Fin Función

	public void setPases(byte pases) {
		this.pases = pases;
	}// Fin Procedimiento

	public byte getRecuperaciones() {
		return recuperaciones;
	}// Fin Función

	public void setRecuperaciones(byte recuperaciones) {
		this.recuperaciones = recuperaciones;
	}// Fin Procedimiento

	public byte getGoles() {
		return goles;
	}// Fin Función

	public void setGoles(byte goles) {
		this.goles = goles;
	}// Fin Procedimiento

	public byte getParadas() {
		return paradas;
	}// Fin Función

	public void setParadas(byte paradas) {
		this.paradas = paradas;
	}// Fin Procedimiento

	public short getMvp() {
		return mvp;
	}// Fin Función

	public void setMvp() {
		if (this.tipo.equalsIgnoreCase("defensa")) {
			this.mvp = (short) (this.goles * 21 + this.pases * 1 + this.recuperaciones * 4 - this.tarjetasRojas * 2);
		} else if (this.tipo.equalsIgnoreCase("delantero")) {
			this.mvp = (short) (this.goles * 31 + this.pases * 1 + this.recuperaciones * 3 - this.tarjetasRojas * 2);
		} else {
			this.mvp = (short) (this.goles * 60 + this.paradas * 5 - this.tarjetasRojas * 2);
		} // Fin Si
	}// Fin Procedimiento

	public byte getTarjetasRojas() {
		return tarjetasRojas;
	}// Fin Función

	public void setTarjetasRojas(byte tarjetasRojas) {
		this.tarjetasRojas = tarjetasRojas;
	}// Fin Procedimiento

}
