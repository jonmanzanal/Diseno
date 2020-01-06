package premote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;






public class Pago extends UnicastRemoteObject implements IPago {

private static Pago instance;
	/**
	 * 
	 */
public static Pago getInstance() {
	if (instance == null) {
		try {
		
			instance = new Pago();
		} catch (Exception ex) {
			System.err.println("# Error creating RemoteFacade: " + ex);
		}
	}
	
	return instance;
}
	private static final long serialVersionUID = 1L;
	private Pago() throws RemoteException {
		super();		
	}
	@Override
	public boolean pago(String nombre, float aBid) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	

	

}
