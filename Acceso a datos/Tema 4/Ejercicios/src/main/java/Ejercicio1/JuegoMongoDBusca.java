package Ejercicio1;

import static com.mongodb.client.model.Filters.eq;
//import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Projections.exclude;
import static com.mongodb.client.model.Projections.include;
import static com.mongodb.client.model.Projections.fields;
//import static com.mongodb.client.model.Sorts.*;
import static com.mongodb.client.model.Sorts.ascending;

import java.util.Iterator;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
//2
public class JuegoMongoDBusca {
	@SuppressWarnings({ "resource", "rawtypes" })
	public static void main(String[] args) {
		MongoClient mc = new MongoClient("localhost", 27017);
		MongoDatabase db = mc.getDatabase("Miguel_Angel");

		// Recoger todos los juegos con el género Roguelike mostrando lo que queremos con include
//		Bson projection = fields(exclude("_id"));
		Bson projection = fields(exclude("_id"), include("titulo"));
		FindIterable<Document> iterDoc = db.getCollection("Juegos").find(eq("genero", "Roguelike"))
				.projection(projection).sort(ascending("titulo"));

		Iterator it = iterDoc.iterator();
		while (it.hasNext()) {
			Document findDoc = (Document) it.next();
			System.out.println(findDoc.toJson());
		}

	}
}
