package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import controllers.UsuarioController;

public class Main {
	public static void menu() {
		System.out.println("¿Qué desea hacer?:");
		System.out.println("\t1. Dar de alta a usuario");
		System.out.println("\t2. Modificar usuario");
		System.out.println("\t3. Eliminar usuario");
		System.out.println("\t4. Muestra usuarios");
		System.out.println("\t5. Buscar usuario");
		System.out.println("\t9. Salir");
		System.out.print("Opción: ");
	}// Fin Procedimiento

	public static String recogerDatos() throws IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		return teclado.readLine();
	}// Fin Función

	public static String salidaBonita(String[] cad) {
		String salidaBonita = "";

		for (String a : cad) {
			a = a.substring(9);
			a = a.substring(0, a.length() - 1);

			String[] vector;
			vector = a.split(", ");

			for (int i = 0; i < vector.length; i++) {
				vector[i] = vector[i].substring(vector[i].indexOf("=") + 1);
			} // Fin Para

			salidaBonita += "\n";
			salidaBonita += "ID: " + vector[0] + "\n";
			salidaBonita += "Nombre: " + vector[1] + "\n";
			salidaBonita += "Apellido: " + vector[2] + "\n";
			salidaBonita += "Ciudad: " + vector[3] + "\n";
		} // Fin Para

		return salidaBonita;
	}// Fin Función

	public static void main(String[] args) throws IOException {
		// Entorno:
		UsuarioController uc;
		byte opc;
		boolean esSalir;
		Scanner sc = new Scanner(System.in);

		// Algoritmo:
		uc = new UsuarioController();
		esSalir = false;

		do {
			menu();
			opc = sc.nextByte();

			switch (opc) {
			case 1:
				String[] datos;
				datos = new String[3];

				System.out.print("¿Qué nombre desea dar de alta?: ");
				datos[0] = recogerDatos();

				System.out.print("¿Qué apellido desesa darle a " + datos[0] + "?: ");
				datos[1] = recogerDatos();

				System.out.print("¿Qué ciudad desea darle a " + datos[0] + " " + datos[1] + "?: ");
				datos[2] = recogerDatos();

				uc.createUsuario(datos[0], datos[1], datos[2]);
				break;
			case 2:
				int id;
				datos = new String[1];

				System.out.print("¿Qué id tiene a quien desea modificar?: ");
				id = sc.nextInt();

				if (uc.getUsuario(id) != "Error al actualizar el usuario") {
					System.out.print("¿Qué nombre le desea poner?: ");
					datos[0] = recogerDatos();

					uc.updateUsuario(id, datos[0]);
				} else {
					System.out.println("No existe nadie con ese id.");
				} // Fin Si
				break;
			case 3:
				System.out.print("¿Qué id desea eliminar?: ");
				id = sc.nextInt();

				if (uc.getUsuario(id) != "Error al actualizar el usuario") {
					uc.deleteUsuario(id);
				} else {
					System.out.println("No existe nadie con ese id.");
				} // Fin Si
				break;
			case 4:
//				uc.getUsuarios();
				System.out.println(salidaBonita(uc.getUsuarios()));
				break;
			case 5:
				System.out.print("¿Qué id desea buscar?: ");
				id = sc.nextInt();

				if (uc.getUsuario(id) != "Error al actualizar el usuario") {
					String[] temp = new String[1];
					temp[0] = uc.getUsuario(id);
					System.out.println(salidaBonita(temp));
				} else {
					System.out.println("No existe nadie con ese id.");
				} // Fin Si
				break;
			case 9:
				System.out.println("Hasta pronto!");
				esSalir = true;
			}// Fin Según Sea
			System.out.println();
		} while (!esSalir);
	}

}
