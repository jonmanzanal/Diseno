package remote;

import java.rmi.Naming;

import es.deusto.ingenieria.sd.auctions.server.remote.IRemoteFacade;

public class ServiceLocator {
	private IAuction service;

	public void setService(String ip, String port, String serverName) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		try {		
			String URL = "//" + ip + ":" + port + "/" + serverName;
			this.service = (IAuction) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote fa�ade: " + ex);
		}		
	}

	public IAuction getService() {
		return this.service;
	}
}

