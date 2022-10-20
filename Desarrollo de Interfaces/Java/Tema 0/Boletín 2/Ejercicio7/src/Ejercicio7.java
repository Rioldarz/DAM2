import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio7 {
	public static ArrayList<String> insertaColores() {
		ArrayList<String> colores = new ArrayList<String>(9);
		colores.add("verde");
		colores.add("rojo");
		colores.add("azul");
		colores.add("amarillo");
		colores.add("naranja");
		colores.add("rosa");
		colores.add("negro");
		colores.add("blanco");
		colores.add("morado");
		return colores;
	}// Fin Función

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Entorno:
		ArrayList<String> lista = new ArrayList<String>(8);
		ArrayList<String> colores = insertaColores();
		Scanner sc = new Scanner(System.in);

		// Algoritmo:
		do {
			System.out.print("Introduzca palabra: ");
			lista.add(sc.next());
		} while (lista.size() < 8);

		System.out.println(lista);

		Collection<String> col = colores;
		Iterator<String> it = col.iterator();
		while (it.hasNext()) {
			String color = it.next();
			for (byte i = 0; i < lista.size(); i++) {
				if (lista.get(i).equalsIgnoreCase(color)) {
					String temp = lista.get(i);
					lista.remove(i);
					lista.add(0, temp);
				} // Fin Si
			} // Fin Para
		} // Fin Mientras

		System.out.println(lista);

//		for(Colores color: Colores.values()){
//		for (byte i = 0; i < lista.size(); i++) {
//			if (lista.get(i).equalsIgnoreCase(color.toString())) {
//				String temp = lista.get(i);
//				lista.remove(i);
//				lista.add(0, temp);
//			}//Fin Si	
//		}//Fin Para
//	}//Fim Para
//	
//	System.out.println(lista);
	}// Fin Programa
}
