package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.controller.ControllerCliente;
import com.model.Cliente;
import com.vista.ViewCliente;

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

	public static Cliente buscarUsuario(String nombre) {
		Cliente cliente, salida;
		ControllerCliente controller = new ControllerCliente();
		List<Cliente> lista;

		lista = controller.recogerClientes();
		salida = null;

		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			cliente = (Cliente) iterator.next();
			if (cliente.getNombre().equals(nombre)) {
				salida = cliente;
				break;
			} // Fin Si
		} // Fin Para
		return salida;
	}// Fin Función

	public static void main(String[] args) throws IOException {
		// Entorno:
		Cliente cliente;
		byte opc;
		Scanner sc = new Scanner(System.in);
		String datos;
		int edad;
		ControllerCliente controller = new ControllerCliente();
		boolean esSalir = false;

		// Algoritmo:
		do {
			menu();
			opc = sc.nextByte();

			switch (opc) {
			case 1:
				cliente = new Cliente();

				System.out.print("¿Qué nombre desea dar de alta?: ");
				datos = recogerDatos();
				cliente.setNombre(datos);

				System.out.print("¿Qué edad desea darle a " + cliente.getNombre() + "?: ");
				edad = sc.nextInt();
				cliente.setEdad(edad);

				System.out.print("¿Qué ciudad desea darle a " + cliente.getNombre() + "?: ");
				datos = recogerDatos();
				cliente.setCiudad(datos);

				System.out.print("¿Qué nombre de padre desea darle a " + cliente.getNombre() + "?: ");
				datos = recogerDatos();
				cliente.setPadre(datos);

				System.out.print("¿Qué nombre de madre desea darle a " + cliente.getNombre() + "?: ");
				datos = recogerDatos();
				cliente.setMadre(datos);

				controller.alta(cliente);
				break;
			case 2:
				cliente = new Cliente();

				System.out.print("¿A quién desea modificar? Nombre: ");
				datos = recogerDatos();

				cliente = buscarUsuario(datos);

				System.out.print("¿Desea cambiarle la edad?(S/N): ");
				datos = sc.next();
				if (datos.charAt(0) == 's' || datos.charAt(0) == 'S') {
					System.out.print("¿Qué edad desea darle a " + cliente.getNombre() + "?: ");
					edad = sc.nextInt();
					cliente.setEdad(edad);
				} // Fin Si

				System.out.print("¿Desea cambiarle la ciudad?(S/N): ");
				datos = sc.next();
				if (datos.charAt(0) == 's' || datos.charAt(0) == 'S') {
					System.out.print("¿Qué ciudad desea darle a " + cliente.getNombre() + "?: ");
					datos = recogerDatos();
					cliente.setCiudad(datos);
				} // Fin Si

				System.out.print("¿Desea cambiarle el padre?(S/N): ");
				datos = sc.next();
				if (datos.charAt(0) == 's' || datos.charAt(0) == 'S') {
					System.out.print("¿Qué nombre de padre desea darle a " + cliente.getNombre() + "?: ");
					datos = recogerDatos();
					cliente.setPadre(datos);
				} // Fin Si

				System.out.print("¿Desea cambiarle la madre?(S/N): ");
				datos = sc.next();
				if (datos.charAt(0) == 's' || datos.charAt(0) == 'S') {
					System.out.print("¿Qué nombre de madre desea darle a " + cliente.getNombre() + "?: ");
					datos = recogerDatos();
					cliente.setMadre(datos);
				} // Fin Si

				controller.modificar(cliente);
				break;
			case 3:
				cliente = new Cliente();

				System.out.print("¿A quién desea eliminar? Nombre: ");
				datos = recogerDatos();

				cliente.setNombre(datos);
				controller.eliminar(cliente);
				break;
			case 4:
				controller.verClientes();
				break;
			case 5:
				System.out.print("¿A quién desea buscar? Nombre: ");
				datos = recogerDatos();

				cliente = buscarUsuario(datos);
				ViewCliente vc = new ViewCliente();
				vc.verCliente(cliente);
				break;
			case 9:
				System.out.println("Hasta pronto!");
				esSalir = true;
			}// Fin Según Sea
			System.out.println();
		} while (!esSalir);
	}// Fin Programa

}
