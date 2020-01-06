package controller;

import java.rmi.RemoteException;
import java.util.List;


import remote.ServiceLocator;

public class ReservaController {
	public ServiceLocator serviceLocator;

	public ReservaController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public boolean login(String email, String password) {
		try {
			return this.serviceLocator.getService().login(email, password);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
			return false;
		}
	}

	public boolean registro(String email) {
		try {
			return this.serviceLocator.getService().registro(email);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
			return false;
		}
	}
	
	public boolean pago(String nombre,float bid){
		
		try {
			return this.serviceLocator.getService().pago(nombre,bid);
		} catch (RemoteException e) {
			System.err.println("# Error making a bid: " + e);
			return false;
		}
	}

	
	/*public List<VueloDTO> getCategories() {
		try {
			return this.serviceLocator.getService().getCategories();
		} catch (RemoteException e) {
			System.err.println("# Error getting all categories: " + e);
			return null;
		}
	}
	
	*/
}
