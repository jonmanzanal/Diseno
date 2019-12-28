package data;

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Vuelo {

	private long idvu;
	private long idavion;
	private Aerolinea aerolinea;
	private Aeropuerto aeropuerto;

	private Set<Reserva> reserva = new HashSet<Reserva>();

	public Vuelo() {
		super();
		this.idvu = 0;
		this.idavion = 0;
		this.aerolinea = null;
		this.aeropuerto = null;
	}

	public long getId_vu() {
		return idvu;
	}

	public void setId_vu(long id_vu) {
		this.idvu = id_vu;
	}

	public long getId_avion() {
		return idavion;
	}

	public void setId_avion(long id_avion) {
		this.idavion = id_avion;
	}

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}

	public Aeropuerto getAeropuerto() {
		return aeropuerto;
	}

	public void setAeropuerto(Aeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}

	public Set<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(Set<Reserva> reserva) {
		this.reserva = reserva;
	}

}