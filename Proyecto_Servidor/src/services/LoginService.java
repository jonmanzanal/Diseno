package services;

import data.Usuario;
import db.GestorBD;
import google.ConexionGoogle;
import google.GoogleMain;
import google.ServiceLocatorGoogle;




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
		ConexionGoogle go= GoogleMain.Loko();
		boolean google=go.login(email,password);
		if (user != null) {
		if(google) {
			return user;
		}
		return null;
		
		} else {
			return null;
		}
	}
	public Usuario registro(String email) {
		System.out.println("registro");
		ConexionGoogle go= GoogleMain.Loko();
		Usuario user=go.registrarUsuario(email);
		GestorBD.getInstance().store(user);
		
		
		if (user != null) {
			
			return user;
			
			} else {
				return null;
			}
	}
}
