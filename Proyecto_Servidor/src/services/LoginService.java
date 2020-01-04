package services;

import data.Usuario;
import db.GestorBD;
import google.ServiceLocatorGoogle;




public class LoginService {
private static LoginService instance;
public static void  main(String[] args) {
	ServiceLocatorGoogle servicegoogle = new ServiceLocatorGoogle();
	servicegoogle.setService(args[0], args[1], args[2]);
	//ConexionGoogle v=new ConexionGoogle(servicegoogle);
	//return v;
}



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
	public Usuario registro(String email) {
		return null;
		//String[]args= {"127.0.0.1","1099","Google"};
		//ConexionGoogle v =main(args);
		//Usuario user=v.registrarUsuario(email);
		//GestorBD.getInstance().store(user);
		//return user;
	}
}
