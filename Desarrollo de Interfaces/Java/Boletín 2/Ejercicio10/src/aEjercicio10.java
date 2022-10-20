import java.util.Scanner;

public class aEjercicio10 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Entorno:
		Diccionario dic;
		Scanner sc;
		String palabra;

		// Algoritmo:
		sc = new Scanner(System.in);
		dic = new Diccionario();
		dic.aniadir("frio", "cold"); // 1
		dic.aniadir("frescura", "cold"); // 2
		dic.aniadir("helado", "cold"); // 3
		dic.aniadir("fresco", "cold"); // 4
		dic.aniadir("biruji", "cold"); // 5
		dic.aniadir("salmon", "salmon"); // 6
		dic.aniadir("gato", "cat"); // 7
		dic.aniadir("perro", "dog"); // 8
		dic.aniadir("pez", "fish"); // 9
		dic.aniadir("negro", "black"); // 10
		dic.aniadir("blanco", "white"); // 11
		dic.aniadir("huevo", "egg"); // 12
		dic.aniadir("marciano", "alien"); // 13
		dic.aniadir("coche", "car"); // 14
		dic.aniadir("motocicleta", "motorbike"); // 15
		dic.aniadir("calor", "heat"); // 16
		dic.aniadir("ardor", "heat"); // 17
		dic.aniadir("ardentia", "heat"); // 18
		dic.aniadir("calorina", "heat"); // 19
		dic.aniadir("opio", "opium"); // 20

		palabra = "";
		do {
			System.out.print("Introduzca la palabra a buscar: ");
			palabra = sc.nextLine();
		} while (palabra.isEmpty());

		System.out.println(dic.buscaSinonimos(palabra));
	}// Fin Programa
}
