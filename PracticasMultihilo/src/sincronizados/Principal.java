package sincronizados;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		//Entorno:
		boolean sincronizado;
		Counter c;
		HiloContador h1, h2;
		
		//Algoritmo:
		sincronizado = true;
		c = new Counter(sincronizado);
		h1 = new HiloContador(1, 5, c);
		h2 = new HiloContador(2, 10, c);
		
		
		h1.start();
		h2.start();
		h1.join();
		h2.join();
		System.out.println("Fin programa");
	}//Fin Programa

}
