package serviciopago;

import services.LoginService;

public class PagoMain {
	public static void main(String[] args) {
		ServiceLocatorPago serviceLocator = new ServiceLocatorPago();
		serviceLocator.setService(args[0], args[1], args[2]);
		ConexionPago co = new ConexionPago(serviceLocator);
		
		
		
		
		//boolean js = conexion.login("borra","txotxo");
		//LoginController loginController = new LoginController(serviceLocator);
		//Inicio inicio = new Inicio(loginController);			
		//Google g=new Google(loginController);
		//inicio.setVisible(true);
		
			
				
	}
	
	public static ConexionPago servicio() {
		ServiceLocatorPago serviceLocator = new ServiceLocatorPago();
		serviceLocator.setService("127.0.0.1","1099","ServicioPago");
		ConexionPago co = new ConexionPago(serviceLocator);
		
		return co;
	}
	
	

	
}
