package db;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import data.Aerolinea;
import data.Aeropuerto;
import data.Paypal;
import data.Reserva;
import data.Usuario;
import data.Visa;
import data.Vuelo;




public class Main {
	private static Main instance = null;
	private static PersistenceManager persistentManager=null;
	private PersistenceManagerFactory pmf = null;
	 
	private Main() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");		
	}
	
	private void initializeData() {
		System.out.println(" * Initializing data base");
		//Create Sample data
		Set<Reserva> lires = new HashSet<>();
		Set<String> pas = new HashSet<>();
		Set<Vuelo> vu = new HashSet<>();
		Date fecha = new Date();
		String f = "12/03/2013";
		DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
		try {
			fecha = format.parse(f);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		pas.add("Jesus");
		pas.add("Marcos");
		Aeropuerto a = new Aeropuerto();
		Aerolinea ar = new Aerolinea();
		Vuelo v = new Vuelo();
		v.setAerolinea(ar);
		v.setAeropuerto(a);
		v.setId_avion(1);
		v.setId_vu(1);
		v.setReserva(lires);
		vu.add(v);
		a.setCiudad("Bilbao");
		a.setIdaero("BIB");
		a.setNombre("Loiu");
		a.setPais("Spain");
		a.setVuelos(vu);

		v.setAerolinea(ar);
		Paypal p = new Paypal();
		p.setUsuario("Jon");
		Visa vi = new Visa();
		vi.setCvc(123);
		vi.setFecha_caduc(fecha);
		vi.setNum_tarjeta(1234);
		Usuario u = new Usuario();
		u.setAeropuertopordefecto(a);
		u.setApellidos("Manzanal");
		u.setEmail("jes");
		u.setTiporedsocial(1);
		u.setReserva(lires);

		Reserva r = new Reserva();
		r.setFecha(fecha);
		r.setImporte(100);
		r.setLista_pasajeros(pas);
		r.setMetodo(p);
		r.setNum_asientos(1);
		r.setUsuario(u);
		r.setVuelo(v);
		lires.add(r);

		ar.setId_aer("HH");
		ar.setNombre("Iberia");
		ar.setVuelo(vu);
		
		try {
			//Store users in DB
			Main.getInstance().store(u);
			Main.getInstance().store(r);
			
		} catch (Exception ex) {
			System.out.println(" $ Error initializing data: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	public void store(Usuario user) {
		Main.getInstance().storeObjectInDB(user);	
	}
	public void store(Reserva r) {
		Main.getInstance().storeObjectInDB(r);	
	}
	public void storeObjectInDB(Object object) {
		Transaction transaction = null;
		
		try {
			System.out.println("Store object");
			persistentManager = pmf.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();

			persistentManager.makePersistent(object);

			transaction.commit();
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			persistentManager.close();
		}
	}
	public static Main getInstance() {
		if (instance == null) {
			instance = new Main();
			instance.initializeData();
		}		
		
		return instance;
	}
	
	public Usuario getUsuario()
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		
	

		
		

		// Select data using a Query
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			// Usuario
			Query<?> usuQuery = persistentManager.newQuery("SELECT FROM " + Usuario.class.getName());

			for (Usuario usuario : (List<Usuario>) usuQuery.executeList()) {
				System.out.println("- Selected product from db: " + usuario.getId_usu());
				System.out.println("- Deleted product from db: " + usuario.getId_usu());
				persistentManager.deletePersistent(usuario);				
			}
			// Vuelo
			Query<?> vuQuery = persistentManager.newQuery("SELECT FROM " + Vuelo.class.getName());

			for (Vuelo vuelo : (List<Vuelo>) vuQuery.executeList()) {
				System.out.println("- Selected product from db: " + vuelo.getId_vu());
				System.out.println("- Deleted product from db: " + vuelo.getId_vu());
				persistentManager.deletePersistent(vuelo);				
			}
			// Paypal
			Query<?> paQuery = persistentManager.newQuery("SELECT FROM " + Paypal.class.getName());

			for (Paypal paypal : (List<Paypal>) paQuery.executeList()) {
				System.out.println("- Selected product from db: " + paypal.getUsuario());
				System.out.println("- Deleted product from db: " + paypal.getUsuario());
				persistentManager.deletePersistent(paypal);				
			}
			// Visa
			Query<?> viQuery = persistentManager.newQuery("SELECT FROM " + Visa.class.getName());

			for (Visa visa : (List<Visa>) viQuery.executeList()) {
				System.out.println("- Selected product from db: " + visa.getNum_tarjeta());
				System.out.println("- Deleted product from db: " + visa.getNum_tarjeta());
				persistentManager.deletePersistent(visa);				
			}
			// Reserva
			Extent<Reserva> reserExtent = persistentManager.getExtent(Reserva.class);

			for (Reserva reserva : reserExtent) {
				System.out.println("  -> " + reserva);
				System.out.println("- Deleted inventory from db: ");
				persistentManager.deletePersistent(reserva);				
			}

			transaction.commit();
		} catch (Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
		// Update
		try {
			Usuario usuario = persistentManager.getObjectById(Usuario.class, u.getEmail());
			usuario.setAeropuertopordefecto(null);
		} finally {
			persistentManager.close();
		}

	}
}
