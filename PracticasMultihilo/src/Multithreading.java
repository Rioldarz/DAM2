
public class Multithreading {
	public static void main(String[] args) {
		// Entorno:
		MultithreadThing myThing; // , myThing2;

		// Algoritmo:
//		myThing = new MultithreadThing();
//		myThing2 = new MultithreadThing();
//		
//		myThing.start(); //El start es para hacerlo en un hilo nuevo
//		myThing2.start();

		for (int i = 0; i < 5; i++) {
			myThing = new MultithreadThing(i);
			Thread myThread = new Thread(myThing);
//			myThing.start();
			myThread.start();
			
			
			
//			try {
//				myThread.join();
//			} catch (InterruptedException e) {
//			}
		} // Fin Para
//		throw new RuntimeException();
	}// Fin Programa
}
