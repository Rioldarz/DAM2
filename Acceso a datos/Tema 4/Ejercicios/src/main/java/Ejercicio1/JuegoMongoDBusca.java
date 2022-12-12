package Ejercicio1;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

public class JuegoMongoDBusca {
	public static void main(String[] args) {
		MongoClient mc = new MongoClient("localhost", 27017);
		MongoDatabase db = mc.getDatabase("Miguel_Angel");

		//Recoger todos los juegos con el género Roguelike
		FindIterable<Document> iterDoc = db.getCollection("Juegos").find(eq("genero", "Roguelike"));

	}
}
