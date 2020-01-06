package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;


import data.Usuario;
import dto.VueloDTO;
import services.LoginService;





public class AuctionServer  extends UnicastRemoteObject implements IAuction {
	private static final long serialVersionUID = 1L;
	private static AuctionServer instance;
	public Usuario state;
	public Usuario state1;


	private AuctionServer() throws RemoteException {
		super();		
	}
	
	public static AuctionServer getInstance() {
		if (instance == null) {
			try {
				instance = new AuctionServer();
			} catch (Exception ex) {
				System.err.println("# Error creating RemoteFacade: " + ex);
			}
		}
		
		return instance;
	}

	@Override
	public boolean login(String aEmail, String aPassword) throws RemoteException {
		System.out.println(" * RemoteFaçade login: " + aEmail + " / " + aPassword);
		this.state = LoginService.getInstance().login(aEmail, aPassword);
		
		return state != null;
	}

	@Override
	public List<VueloDTO> getVuelos() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pago(String nombre, float aBid) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registro(String aEmail) throws RemoteException {
		System.out.println("remote registro");
		this.state1 = LoginService.getInstance().registro(aEmail);
		
		return state1 != null;
	}
}
