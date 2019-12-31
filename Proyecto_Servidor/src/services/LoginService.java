package services;

import data.Usuario;
import db.GestorBD;
import google.ConexionGoogle;
import google.RMISErviceLocatorGoogle;

public class LoginService {
private static LoginService instance;
ConexionGoogle v=new ConexionGoogle(new RMISErviceLocatorGoogle());
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
		v.login(email,password);
		return user;
		} else {
			return null;
		}
	}
}
