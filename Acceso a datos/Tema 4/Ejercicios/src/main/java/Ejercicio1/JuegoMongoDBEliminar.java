package Ejercicio1;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

//5
public class JuegoMongoDBEliminar {
	@SuppressWarnings({ "resource", "rawtypes" })
	public static void main(String[] args) {
		MongoClient mc = new MongoClient("localhost", 27017);
		MongoDatabase db = mc.getDatabase("Miguel_Angel");

		db.getCollection("Juegos").deleteMany(new Document("genero", "Roguelike"));

		FindIterable<Document> iterDoc = db.getCollection("Juegos").find();
		Iterator it = iterDoc.iterator();
		while (it.hasNext()) {
			Document findDoc = (Document) it.next();
			System.out.println(findDoc.toJson());
		}
	}
}
