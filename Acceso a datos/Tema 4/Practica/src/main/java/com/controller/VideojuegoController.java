package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.model.Videojuego;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class VideojuegoController {
	MongoClient mc = new MongoClient("localhost", 27017);
	MongoDatabase db = mc.getDatabase("practica4");

	public String createVideojuegos(Videojuego[] juegos) throws ParseException {
		// Entorno:
		Document vj;
		SimpleDateFormat formatter;
		LinkedList<Document> vjs;

		// Algoritmo:
		formatter = new SimpleDateFormat("dd-MM-yyyy");
		vjs = new LinkedList<Document>();

		for (Videojuego j : juegos) {
			vj = new Document().append("_id", new ObjectId());
			String[] datos = j.datosSeparados();

			for (byte i = 0; i < datos.length; i++) {
				switch (i) {
				case 0:
					if (datos[i] != null) {
						vj.append("titulo", datos[i]);
					} // Fin Si
					break;
				case 1:
					if (datos[i] != null) {
						vj.append("fecha_lanzamiento", formatter.parseObject(datos[i]));
					} // Fin Si
					break;
				case 2:
					if (datos[i] != null) {
						vj.append("diseniador", datos[i]);
					} // Fin Si
					break;
				case 3:
					if (datos[i] != null) {
						vj.append("modo", datos[i]);
					} // Fin Si
					break;
				case 4:
					if (datos[i] != null) {
						vj.append("plataforma", datos[i]);
					} // Fin Si
					break;
				case 5:
					if (datos[i] != null) {
						vj.append("desarrollador", datos[i]);
					} // Fin Si
					break;
				case 6:
					if (datos[i] != null) {
						vj.append("premio", datos[i]);
					} // Fin Si
					break;
				case 7:
					if (datos[i] != null) {
						vj.append("genero", datos[i]);
					} // Fin Si
					break;
				case 8:
					if (datos[i] != null) {
						vj.append("serie", datos[i]);
					} // Fin Si
					break;
				case 9:
					if (datos[i] != null) {
						vj.append("nominacion", datos[i]);
					} // Fin Si
					break;
				case 10:
					if (datos[i] != null) {
						vj.append("distribuidor", datos[i]);
					} // Fin Si
					break;
				case 11:
					if (datos[i] != null) {
						vj.append("precio(euro)", Float.parseFloat(datos[i]));
					} // Fin Si
					break;
				}// Fin Según Sea
			} // Fin Para

			vjs.add(vj);
		} // Fin Para

		db.getCollection("videojuegos").insertMany(vjs);

		return "Videojuego guardado en la base de datos";
	}// Fin Función

}
