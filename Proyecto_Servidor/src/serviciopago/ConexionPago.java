package serviciopago;

import java.rmi.RemoteException;



public class ConexionPago implements IGatewayPago{
	public ServiceLocatorPago serviceLocator;
	
	public ConexionPago(ServiceLocatorPago serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

	@Override
	public boolean pago(String nombre, float aBid) {
		// TODO Auto-generated method stub
		return false;
	}
	

	

}
