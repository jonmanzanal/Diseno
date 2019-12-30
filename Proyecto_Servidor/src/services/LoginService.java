package services;

import data.Usuario;
import db.GestorBD;

public class LoginService {
private static LoginService instance;
	
	private LoginService() { }
	
	public static LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}
		
		return instance;
	}

	public Usuario login(String email, String password) {
		Usuario user = GestorBD.getInstance().getUsuario(email);
		
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}
}
