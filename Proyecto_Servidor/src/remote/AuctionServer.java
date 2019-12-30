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
		System.out.println(" * RemoteFaçade login: " + email + " / " + password);
		this.state = LoginService.getInstance().login(email, password);
		
		return state != null;
	}

	@Override
	public List<VueloDTO> getVuelos() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean makeBid(long aArticle, float aBid) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}
