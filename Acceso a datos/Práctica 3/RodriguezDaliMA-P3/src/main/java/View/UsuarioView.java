package View;


import java.util.List;

import controllers.UsuarioController;
import models.Usuario;

public class UsuarioView {
	
	public static void main(String[] args) {
		//String usuario = new UsuarioController().createUsuario("Carlos", "Acuña", "Sevilla");
		//String usuario = new UsuarioController().deleteUsuario(2);
		//String usuario = new UsuarioController().updateUsuario(1, "Jose");
		//String usuario = new UsuarioController().getUsuario(1);
		UsuarioController uc = new UsuarioController();
		uc.getUsuarios();
			
		
	}

}
