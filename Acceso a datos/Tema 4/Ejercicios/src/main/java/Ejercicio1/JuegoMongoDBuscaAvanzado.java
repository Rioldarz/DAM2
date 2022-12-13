package Ejercicio1;

import java.util.Iterator;

import com.mongodb.MongoClient;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoDatabase;
//3
public class JuegoMongoDBuscaAvanzado {
	@SuppressWarnings({ "rawtypes", "resource" })
	public static void main(String[] args) {
		MongoClient mc = new MongoClient("localhost", 27017);
		MongoDatabase db = mc.getDatabase("Miguel_Angel");

		DistinctIterable<String> juego = db.getCollection("Juegos").distinct("genero", String.class);

		Iterator it = juego.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
