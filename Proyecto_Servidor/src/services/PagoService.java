package services;

import data.Usuario;
import db.GestorBD;
import google.ConexionGoogle;
import google.GoogleMain;
import serviciopago.ConexionPago;
import serviciopago.PagoMain;

public class PagoService {
private static PagoService instance;
	

	private PagoService() { }
	
	public static PagoService getInstance() {
		if (instance == null) {
			
			instance = new PagoService();
		}
		
		return instance;
	}
	public boolean pago(String nombre, float aBid) {
		ConexionPago pa= PagoMain.servicio();
		boolean pago=pa.pago(nombre, aBid);
		
	
		
		return pago;
		
		
		
		
	}
}
