package premote;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IPago extends Remote {
	public boolean pago(String nombre, float aBid) throws RemoteException;
	
}
