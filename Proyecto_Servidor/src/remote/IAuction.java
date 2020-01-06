package remote;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import data.Reserva;
import dto.VueloDTO;

public interface IAuction extends Remote{
	public boolean login(String aEmail, String aPassword) throws RemoteException;
	public boolean registro(String aEmail) throws RemoteException;
	public List<VueloDTO> getVuelos() throws RemoteException;
	public boolean pago(String nombre, float aBid) throws RemoteException;
}
