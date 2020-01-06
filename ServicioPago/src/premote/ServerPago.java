package premote;

import java.rmi.Naming;



public class ServerPago {
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		
		try {
			IPago remoteFacade = Pago.getInstance();			
			Naming.rebind(name, remoteFacade);
			System.out.println(" * ServicioPago server '" + name + "' started!!");
		} catch (Exception ex) {
			System.err.println(" # ServicioPago Server Exception: " + ex.getMessage());
			ex.printStackTrace();
		}

	}
}
