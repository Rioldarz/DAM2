package com.pruebas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.controller.VideojuegoController;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class CreacionInicial {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws ParseException {
		MongoClient mc = new MongoClient("localhost", 27017);
		MongoDatabase db = mc.getDatabase("practica4");

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		VideojuegoController controlador = new VideojuegoController();
		controlador.deleteVideojuegos();
		
		Document juego1 = new Document().append("_id", new ObjectId())
				.append("titulo", "Dead Cells")
				.append("fecha_lanzamiento", formatter.parse("10-05-2017"))
				.append("diseniador", "Sebastien Benard")
				.append("modo", "Un Jugador")
				.append("plataforma", "Android, Nintendo Switch, PlayStation 4, Xbox One")
				.append("desarrollador", "Motion Twin, Motion Twin Scop ARL")
				.append("premio", "The Game Award For Best Action Game")
				.append("genero", "Roguelike, Metroidvania")
//				.append("serie", "Pokemon")
//				.append("nominacion", "Spike Video Game Award Al Mejor Juego De Rol")
//				.append("distribuidor", "Nintendo, The Pokemon Company, Nintendo of America Inc")
				.append("precio(euro)", 24.99);

		Document juego2 = new Document().append("_id", new ObjectId())
				.append("titulo", "Pokemon Purpura")
				.append("fecha_lanzamiento", formatter.parse("18-11-2022"))
//				.append("diseniador", "Sebastien Benard")
				.append("modo", "Multijugador")
				.append("plataforma", "Nintendo Switch")
				.append("desarrollador", "Game Freak")
//				.append("premio", "The Game Award For Best Action Game")
				.append("genero", "RPG, Aventura")
				.append("serie", "Pokemon")
//				.append("nominacion", "Spike Video Game Award Al Mejor Juego De Rol")
				.append("distribuidor", "Nintendo, The Pokemon Company, Nintendo of America Inc")
				.append("precio(euro)", 59.99);

		Document juego3 = new Document().append("_id", new ObjectId())
				.append("titulo", "Eternal Sonata")
				.append("fecha_lanzamiento", formatter.parse("14-06-2007"))
				.append("diseniador", "Hiroya Hatsushiba, Motoi Sakuraba")
				.append("modo", "Un Jugador, Cooperativo")
				.append("plataforma", "PlayStation 3, Xbox 360")
				.append("desarrollador", "Tri-Crescendo")
//				.append("premio", "The Game Award For Best Action Game")
				.append("genero", "J-RPG")
//				.append("serie", "Pokemon")
				.append("nominacion", "Spike Video Game Award Al Mejor Juego De Rol")
				.append("distribuidor", "Bandai Namco Entertainment")
				.append("precio(euro)", 59.95);

		List<Document> juegosList = Arrays.asList(juego1, juego2, juego3);
		db.getCollection("videojuegos").insertMany(juegosList);
	}

}
