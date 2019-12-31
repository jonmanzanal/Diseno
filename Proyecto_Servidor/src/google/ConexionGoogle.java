package google;

import java.rmi.RemoteException;

import data.Usuario;


public class ConexionGoogle implements IGatewayLogin{
	public RMISErviceLocatorGoogle serviceLocator;

	public ConexionGoogle(RMISErviceLocatorGoogle serviceLocator) {
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
		// TODO Auto-generated method stub
		return null;
	}

}
