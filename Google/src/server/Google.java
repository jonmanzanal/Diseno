package server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;



public class Google extends UnicastRemoteObject implements IGoogle {
private List<Usuario> usuarios=new ArrayList<Usuario>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Google() throws RemoteException {
		super();		
	}
	@Override
	public boolean login(String aEmail, String aPassword) throws RemoteException {
		for (Usuario object : usuarios) {
			if(object.getContrasena() == aPassword && object.getEmail()== aEmail) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Usuario registro(String email) throws RemoteException {
		for (Usuario usuario : usuarios) {
			if(usuario.getEmail() == email) {
				return usuario;
			}
		}
		return null;
	}

}
