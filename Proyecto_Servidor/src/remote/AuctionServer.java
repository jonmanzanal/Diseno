package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dto.VueloDTO;




public class AuctionServer  extends UnicastRemoteObject implements IAuction {
	private static final long serialVersionUID = 1L;
	private static AuctionServer instance;
	

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
		// TODO Auto-generated method stub
		return false;
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
