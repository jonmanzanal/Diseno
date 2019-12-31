package server;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IGoogle extends Remote {
	public boolean login(String aEmail, String aPassword) throws RemoteException;
	public Usuario registro(String email) throws RemoteException;
}
