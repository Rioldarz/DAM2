package com.pruebas;

import static com.mongodb.client.model.Projections.exclude;
import static com.mongodb.client.model.Projections.include;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Sorts.ascending;

import java.util.Iterator;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

public class MuestraTodoInicial {
	@SuppressWarnings({ "rawtypes", "resource" })
	public static void main(String[] args) {
		MongoClient mc = new MongoClient("localhost", 27017);
		MongoDatabase db = mc.getDatabase("practica4");

		// No queremos mostrar el id, y sí mostrar todos los juegos por ascendente de
		// precios
		Bson projection = fields(exclude("_id"));
		FindIterable<Document> iterDoc = db.getCollection("Videojuegos").find().projection(projection)
				.sort(ascending("precio(euro)"));

		Iterator it = iterDoc.iterator();
		while (it.hasNext()) {
			Document findDoc = (Document) it.next();
			System.out.println(findDoc.toJson());
		}
	}
}
