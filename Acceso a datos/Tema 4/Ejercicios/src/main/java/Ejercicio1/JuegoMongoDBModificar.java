package Ejercicio1;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

//4
public class JuegoMongoDBModificar {
	@SuppressWarnings({ "resource", "rawtypes" })
	public static void main(String[] args) {
		MongoClient mc = new MongoClient("localhost", 27017);
		MongoDatabase db = mc.getDatabase("Miguel_Angel");

		db.getCollection("Juegos").updateOne(new Document("titulo", "Dead Cells"),
				new Document("$set", new Document("titulo", "Dead Cells (Switch)")));
		
		FindIterable<Document> iterDoc = db.getCollection("Juegos").find();
		Iterator it = iterDoc.iterator();
		while(it.hasNext()) {
			Document findDoc = (Document) it.next();
			System.out.println(findDoc.toJson());
		}
	}
}
