package gremote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;





public class Google extends UnicastRemoteObject implements IGoogle {
private static List<DatosG> usuarios=new ArrayList<DatosG>();
private static Google instance;
	/**
	 * 
	 */
public static Google getInstance() {
	if (instance == null) {
		try {
			usuarios.add(new DatosG("jese","jost"));
			usuarios.add(new DatosG("jesi","josy"));
			usuarios.add(new DatosG("jesu","josu"));
			usuarios.add(new DatosG("jesa","josi"));
			instance = new Google();
		} catch (Exception ex) {
			System.err.println("# Error creating RemoteFacade: " + ex);
		}
	}
	
	return instance;
}
	private static final long serialVersionUID = 1L;
	private Google() throws RemoteException {
		super();		
	}
	@Override
	public boolean login(String aEmail, String aPassword) throws RemoteException {
		for (DatosG object : usuarios) {
			if(object.getContrasena() == aPassword && object.getEmail()== aEmail) {
				return true;
			}
		}
		return false;
	}

	@Override
	public DatosG registro(String email) throws RemoteException {
		System.out.println("google");
		for (DatosG usuario : usuarios) {
			if(usuario.getEmail() == email) {
				return usuario;
			}
		}
		return null;
	}

}
