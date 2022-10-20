import java.util.Scanner;

public class Ejecutable {

	public static void menuPrincipal() {
		System.out.println("1.-  Crear Alumno.");
		System.out.println("2.-  Modificar Alumno.");
		System.out.println("3.-  Eliminar Alumno.");
		System.out.println("4.-  Mostrar lista de Alumnos.");
		System.out.println("5.-  Búsqueda Avanzada.");
		System.out.println("6.-  Guardar datos.");
		System.out.println("7.-  Borrar todos los datos.");
		System.out.println("8.-  Recuperar el último elemento borrado.");
		System.out.println("9.-  Cambiar ruta.");
		System.out.println("10.-  Salir.");
		System.out.print("Elija una opción: ");
	}// Fin Procedimiento

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Entorno:
		Scanner sc = new Scanner(System.in);
		GestionaAlumnos principal = new GestionaAlumnos();
		int opcion = 0;
		boolean esSalir = false;
		Alumno alu;
		String datosAlumno = "";

		// Algoritmo:
		do {
			menuPrincipal();

			try {
				opcion = Integer.parseInt(sc.next());
			} catch (NumberFormatException nfe) {
				opcion = 0;
			} // Fin try

			switch (opcion) {
			case 1: {
				alu = new Alumno();
				int posicion = 0;
				float media = -1;

				do {
					System.out.print("Introduzca el nombre del alumno: ");
					datosAlumno = sc.next();
				} while (datosAlumno.isEmpty());
				alu.setNombre(datosAlumno);

				do {
					System.out.print("Introduzca la posición del alumno >0: ");
					try {
						posicion = Integer.parseInt(sc.next());
					} catch (NumberFormatException nfe) {
						System.out.println("No ha introducido un número correcto.");
						posicion = 0;
					} // Fin try
				} while (posicion < 0);
				alu.setPosicion(posicion);

				do {
					System.out.print("Introduzca la nota media del alumno >=0: ");
					try {
						media = Float.parseFloat(sc.next());
					} catch (NumberFormatException nfe) {
						System.out.println("No ha introducido un formato numérico correcto.");
						media = -1;
					} // Fin try
				} while (media < 0);
				alu.setNotaMedia(media);

				datosAlumno = "";
				do {
					System.out.print("Introduzca la ruta completa de la foto: ");
					datosAlumno = sc.next();
				} while (datosAlumno.isEmpty());
				alu.setFoto(datosAlumno);

				datosAlumno = "";
				do {
					System.out.print("Introduzca el DNI del alumno: ");
					datosAlumno = sc.next();
				} while (datosAlumno.isEmpty());
				alu.setDni(datosAlumno);

				principal.crearAlumno(alu);

				break;
			} // Crear Alumno
			case 2: {
				datosAlumno = "";
				do {
					System.out.print("¿Qué alumno desea modificar? (DNI): ");
					datosAlumno = sc.next();
				} while (datosAlumno.isEmpty());

				String dniOriginal = datosAlumno;
				alu = principal.busquedaAvanzada(datosAlumno);
				do {
					System.out.print("¿Desea modificarle el nombre? (S/N): ");
					datosAlumno = sc.next();
				} while (!datosAlumno.equalsIgnoreCase("s") && !datosAlumno.equalsIgnoreCase("n"));
				if (datosAlumno.equalsIgnoreCase("s")) {
					datosAlumno = "";
					do {
						System.out.print("¿Qué nombre desea ponerle?: ");
						datosAlumno = sc.next();
					} while (datosAlumno.isEmpty());

					alu.setNombre(datosAlumno);
				} // Fin Si

				do {
					System.out.print("¿Desea modificarle la posición? (S/N): ");
					datosAlumno = sc.next();
				} while (!datosAlumno.equalsIgnoreCase("s") && !datosAlumno.equalsIgnoreCase("n"));
				if (datosAlumno.equalsIgnoreCase("s")) {
					datosAlumno = "";
					int posicion = 0;

					do {
						System.out.print("¿Qué posición desea ponerle? >0: ");
						datosAlumno = sc.next();
						try {
							posicion = Integer.parseInt(datosAlumno);
						} catch (NumberFormatException nfe) {
							System.out.println("No ha introducido un número válido");
							posicion = 0;
						} // Fin try
					} while (posicion <= 0);

					alu.setPosicion(posicion);
				} // Fin Si

				do {
					System.out.print("¿Desea modificarle la nota media? (S/N): ");
					datosAlumno = sc.next();
				} while (!datosAlumno.equalsIgnoreCase("s") && !datosAlumno.equalsIgnoreCase("n"));
				if (datosAlumno.equalsIgnoreCase("s")) {
					datosAlumno = "";
					float notaMedia = -1;

					do {
						System.out.print("¿Qué nota media desea ponerle? >=0: ");
						datosAlumno = sc.next();
						try {
							notaMedia = Float.parseFloat(datosAlumno);
						} catch (NumberFormatException nfe) {
							System.out.println("No ha introducido un número válido");
							notaMedia = -1;
						} // Fin try
					} while (notaMedia < 0);

					alu.setNotaMedia(notaMedia);
				} // Fin Si

				do {
					System.out.print("¿Desea modificarle la foto? (S/N): ");
					datosAlumno = sc.next();
				} while (!datosAlumno.equalsIgnoreCase("s") && !datosAlumno.equalsIgnoreCase("n"));
				if (datosAlumno.equalsIgnoreCase("s")) {
					datosAlumno = "";

					do {
						System.out.print("¿Qué foto desea ponerle? >=0: ");
						datosAlumno = sc.next();
					} while (datosAlumno.isEmpty());

					alu.setFoto(datosAlumno);
				} // Fin Si

				do {
					System.out.print("¿Desea modificarle el DNI? (S/N): ");
					datosAlumno = sc.next();
				} while (!datosAlumno.equalsIgnoreCase("s") && !datosAlumno.equalsIgnoreCase("n"));
				if (datosAlumno.equalsIgnoreCase("s")) {
					datosAlumno = "";

					do {
						System.out.print("¿Qué DNI desea ponerle? >=0: ");
						datosAlumno = sc.next();
					} while (datosAlumno.isEmpty());

					alu.setDni(datosAlumno);
				} // Fin Si

				principal.eliminarAlumno(principal.busquedaAvanzada(dniOriginal));
				principal.crearAlumno(alu);
				break;
			} // Modificar Alumno
			case 3: {
				datosAlumno = "";
				do {
					System.out.print("¿A qué alumno desea elimiar (dni): ");
					datosAlumno = sc.next();
				} while (datosAlumno.isEmpty());

				alu = principal.busquedaAvanzada(datosAlumno);
				principal.eliminarAlumno(alu);

				break;
			} // Eliminar Alumno
			case 4: {
				System.out.println(principal.listadoAlumnos());
				break;
			} // Mostrar lista de Alumnos
			case 5: {
				datosAlumno = "";
				do {
					System.out.print("Introduzca el DNI de quien desea conseguir: ");
					datosAlumno = sc.next();
				} while (datosAlumno.isEmpty());
				alu = principal.busquedaAvanzada(datosAlumno);

				System.out.println("Nombre: " + alu.getNombre() + "\n");
				System.out.println("Posición: " + alu.getPosicion() + "\n");
				System.out.println("Nota Media: " + alu.getNombre() + "\n");
				System.out.println("DNI: " + alu.getDni() + "\n");
				System.out.println("Imagen: " + alu.getFoto() + "\n");
				break;
			} // Búsqueda Avanzada
			case 6: {
				if (principal.guardarDatosActuales()) {
					System.out.println("Guardados existosamente");
				} else {
					System.out.println("No se han guardado los datos");
				} // Fin Si
				break;
			} // Guardar datos
			case 7: {
				principal.borrarTodosLosDatos();
				break;
			} // Borrar todos los datos
			case 8: {
				alu = principal.recuperarUltimoElementoBorrado();
				principal.crearAlumno(alu);
				break;
			} // Recuperar el último elemento borrado
			case 9: {
				datosAlumno = "";
				do {
					System.out.print("Introduzca la nueva ruta: ");
					datosAlumno = sc.next();
				} while (datosAlumno.isEmpty());
				principal.setRuta(datosAlumno);
				break;
			} // Salir
			case 10: {
				esSalir = true;
				break;
			} // Salir
			default:
				System.out.println("No ha introducido un número válido.");
			}// Fin Según Sea
		} while (opcion > 0 && opcion < 9 || esSalir == false);

	}// Fin Programa
}
