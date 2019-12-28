package main;

import controller.ReservaController;
import gui.Ventana;
import remote.ServiceLocator;

public class Main {

	public static void main(String[] args) {
		ServiceLocator serviceLocator = new ServiceLocator();
		serviceLocator.setService(args[0], args[1], args[2]);
		
		ReservaController reservaController = new ReservaController(serviceLocator);
		Ventana loginDialog = new Ventana(reservaController);			
		loginDialog.login();
		
				
				
	}

}
