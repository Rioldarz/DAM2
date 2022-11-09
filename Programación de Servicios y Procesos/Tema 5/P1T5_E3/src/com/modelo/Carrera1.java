package com.modelo;

import java.util.Scanner;

public class Carrera1 {
	//Atributos:
	long tiempoActual, tiempoActual2, tiempoFinal, tiempoDespuesCarrera;
	int random, distancia;
	
	//Métodos:
	public void carrera(String nombreEquipo, Atleta a1, Atleta a2, Atleta a3, Atleta a4) throws InterruptedException{
		synchronized(this){
			this.tiempoActual = System.currentTimeMillis();
			
			corredorCorriendo(a1);
			wait();
			
			System.out.println("Sigue el atleta siguiente: ");
			corredorCorriendo(a2);
			notify();
			wait();
			notify();
			
			System.out.println("Sigue el atleta siguiente: ");
			corredorCorriendo(a3);
			notify();
			wait();
			notify();
			
			System.out.println("Sigue el atleta siguiente: ");
			corredorCorriendo(a3);
			System.out.println("¡¡FIN DE LA CARRERA PARA EL EQUIPO " + nombreEquipo + "!!");
			
			this.tiempoActual2 = System.currentTimeMillis();
			this.tiempoFinal = this.tiempoActual2-this.tiempoActual;
			
			System.out.println("Y ha terminado la carrera entera en: " + this.tiempoFinal + " segundos.");
			notify();
			wait();
			notify();
			System.out.println("Sigue el atleta siguiente: ");
		}//Fin synchronized
	}//Fin Procedimiento
	
	public void cambiarJugador() throws InterruptedException{
		Scanner sc = new Scanner(System.in);
		Thread.sleep(2000);
		
		synchronized(this) {
			System.out.println("El jugador releva");
			Thread.sleep(1000);
			notify();
			wait();
			
			System.out.println("El jugador releva");
			Thread.sleep(1000);
			notify();
			wait();
			
			System.out.println("El jugador releva");
			Thread.sleep(1000);
			notify();
			wait();
		}//Fin synchronized
	}//Fin Procedimiento
	
	public int generaAleatorio(int min, int max) {
		this.random = (int)Math.floor(Math.random()*(max-min+1)+min);
		return this.random;
	}//Fin Función
	
	public void corredorCorriendo(Atleta a1) throws InterruptedException{
		this.distancia = 0;
		this.tiempoActual = System.currentTimeMillis();
		
		System.out.println("Comienza el atleta " + a1.getNombre());
		while(this.distancia<generaAleatorio(9, 11)) {
			Thread.sleep(1000);
			this.distancia++;
			System.out.println("El corredor " + a1.getNombre() + " recorrió " + this.distancia);
		}//Fin Mientras
		
		this.tiempoDespuesCarrera = System.currentTimeMillis();
		System.out.println("El atleta " + a1.getNombre() + " acabó el tramo en: " + (this.tiempoDespuesCarrera-this.tiempoActual) + " segundos.");
	}//Fin Procedimiento
}
