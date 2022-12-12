package Ejercicio1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class JuegoMongoDB {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws ParseException {
		MongoClient mc = new MongoClient("localhost", 27017);
		MongoDatabase db = mc.getDatabase("Miguel_Angel");

		// Crear fecha en condiciones
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		// Título, género, precio, fecha lanzamiento
		Document juego1 = new Document().append("_id", new ObjectId()).append("titulo", "Dead Cells")
				.append("genero", "Roguelike").append("precio", 24.99)
				.append("fecha_lanzamiento", formatter.parse("06-08-2018"));

		Document juego2 = new Document().append("_id", new ObjectId()).append("titulo", "Metroid")
				.append("genero", "Metroidvania").append("precio", 4.99)
				.append("fecha_lanzamiento", formatter.parse("06-08-1986"));

		Document juego3 = new Document().append("_id", new ObjectId()).append("titulo", "Pokemon Purpura")
				.append("genero", "RPG").append("fecha_lanzamiento", formatter.parse("18-11-2022"));

		List<Document> juegosList = Arrays.asList(juego1, juego2, juego3);
		db.getCollection("Juegos").insertMany(juegosList);

	}
}
