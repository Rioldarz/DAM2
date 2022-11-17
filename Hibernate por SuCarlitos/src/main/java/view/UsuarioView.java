package view;

import controllers.UsuarioController;
import models.Usuario;

public class UsuarioView {

	public static void main (String [] args) {
		UsuarioController uc = new UsuarioController();
		 uc.createUsuario("Alvaro", "Maricon", "Parque");
		
	}
	
}
