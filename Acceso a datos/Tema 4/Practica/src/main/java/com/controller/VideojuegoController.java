package com.controller;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.exclude;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import static com.mongodb.client.model.Sorts.ascending;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.model.Videojuego;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

public class VideojuegoController {
	MongoClient mc = new MongoClient("localhost", 27017);
	MongoDatabase db = mc.getDatabase("practica4");

	public void createVideojuegos(Videojuego[] juegos) throws ParseException {
		// Entorno:
		Document vj;
		SimpleDateFormat formatter;
		LinkedList<Document> vjs;

		// Algoritmo:
		formatter = new SimpleDateFormat("dd-MM-yyyy");
		vjs = new LinkedList<Document>();

		for (Videojuego j : juegos) {
			vj = new Document().append("_id", j.getId());
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

		System.out.println("Videojuego guardado en la base de datos");
	}// Fin Función

	public void updateVideojuego(String titulo, String[] mods) throws ParseException {
		// Entorno:
		SimpleDateFormat formatter;

		// Algoritmo:
		formatter = new SimpleDateFormat("dd-MM-yyyy");

		for (byte i = 0; i < mods.length; i++) {
			switch (i) {
			case 0:
				if (mods[i] != null) {
					db.getCollection("videojuegos").updateOne(new Document("titulo", titulo),
							new Document("$set", new Document("titulo", mods[0])));
					titulo = mods[0];
				} // Fin Si
				break;
			case 1:
				if (mods[i] != null) {
					db.getCollection("videojuegos").updateOne(new Document("titulo", titulo),
							new Document("$set", new Document("fecha_lanzamiento", formatter.parseObject(mods[1]))));
				} // Fin Si
				break;
			case 2:
				if (mods[i] != null) {
					db.getCollection("videojuegos").updateOne(new Document("titulo", titulo),
							new Document("$set", new Document("diseniador", mods[2])));
				} // Fin Si
				break;
			case 3:
				if (mods[i] != null) {
					db.getCollection("videojuegos").updateOne(new Document("titulo", titulo),
							new Document("$set", new Document("modo", mods[3])));
				} // Fin Si
				break;
			case 4:
				if (mods[i] != null) {
					db.getCollection("videojuegos").updateOne(new Document("titulo", titulo),
							new Document("$set", new Document("plataforma", mods[4])));
				} // Fin Si
				break;
			case 5:
				if (mods[i] != null) {
					db.getCollection("videojuegos").updateOne(new Document("titulo", titulo),
							new Document("$set", new Document("desarrollador", mods[5])));
				} // Fin Si
				break;
			case 6:
				if (mods[i] != null) {
					db.getCollection("videojuegos").updateOne(new Document("titulo", titulo),
							new Document("$set", new Document("premio", mods[6])));
				} // Fin Si
				break;
			case 7:
				if (mods[i] != null) {
					db.getCollection("videojuegos").updateOne(new Document("titulo", titulo),
							new Document("$set", new Document("genero", mods[7])));
				} // Fin Si
				break;
			case 8:
				if (mods[i] != null) {
					db.getCollection("videojuegos").updateOne(new Document("titulo", titulo),
							new Document("$set", new Document("serie", mods[8])));
				} // Fin Si
				break;
			case 9:
				if (mods[i] != null) {
					db.getCollection("videojuegos").updateOne(new Document("titulo", titulo),
							new Document("$set", new Document("nominacion", mods[9])));
				} // Fin Si
				break;
			case 10:
				if (mods[i] != null) {
					db.getCollection("videojuegos").updateOne(new Document("titulo", titulo),
							new Document("$set", new Document("distribuidor", mods[9])));
				} // Fin Si
				break;
			case 11:
				if (mods[i] != null) {
					db.getCollection("videojuegos").updateOne(new Document("titulo", titulo),
							new Document("$set", new Document("precio(euro)", Float.parseFloat(mods[i]))));
				} // Fin Si
				break;
			}// Fin Según Sea
		} // Fin Para

		System.out.println("Videojuego modificado en la base de datos");
	}// Fin Función

	public void deleteVideojuego(String titulo) {
		// Entorno:
		// Algoritmo:
		db.getCollection("videojuegos").deleteOne(new Document("titulo", titulo));

		System.out.println("Videojuego eliminado en la base de datos");
	}// Fin Función

	public void deleteVideojuegos() {
		db.getCollection("videojuegos").drop();
		;

		System.out.println("Se han eliminado todos los videojuegos en la base de datos");
	}// Fin Procedimiento

	@SuppressWarnings("rawtypes")
	public void buscaVideojuego(String nombre) {
		Bson projection = fields(exclude("_id"), include("titulo"));
		FindIterable<Document> iterDoc = db.getCollection("videojuegos").find(eq("titulo", nombre))
				.projection(projection).sort(ascending("titulo"));

		Iterator it = iterDoc.iterator();

		if (!it.hasNext()) {
			System.out.println("No existe ningún juego con ese nombre.");
		} // Fin Si

		while (it.hasNext()) {
			Document findDoc = (Document) it.next();
			System.out.println(findDoc.toJson());
		} // Fin Mientras
	}// Fin Procedimiento

	@SuppressWarnings("rawtypes")
	public void mostrarTodos() {
		Bson projection = fields(exclude("_id"));

		FindIterable<Document> iterDoc = db.getCollection("videojuegos").find().projection(projection)
				.sort(ascending("titulo"));
		Iterator it = iterDoc.iterator();
		while (it.hasNext()) {
			Document findDoc = (Document) it.next();
			System.out.println(findDoc.toJson());
		} // Fin Mientras
	}// Fin Procedimiento
}
