package google;

import java.rmi.RemoteException;

import data.Usuario;
import externo1.DatosG;


public class ConexionGoogle implements IGatewayLogin{
	public ServiceLocatorGoogle serviceLocator;
	
	public ConexionGoogle(ServiceLocatorGoogle serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	@Override
	public boolean login(String email, String contrasena) {
		try {
			return this.serviceLocator.getService().login(email, contrasena);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
			return false;
		}
	}

	@Override
	public Usuario registrarUsuario(String email) {
		try {
			return (Usuario) this.serviceLocator.getService().registro(email);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
			return null;
		}
		
	}

}
