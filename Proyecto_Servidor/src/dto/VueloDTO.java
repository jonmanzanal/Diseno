package dto;

import java.io.Serializable;
import java.util.Date;

public class VueloDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idvu;
	private String hora_salida;
	private String hora_llegada;
	private Date fecha;
	private double importe;
	
	public long getIdvu() {
		return idvu;
	}
	public void setIdvu(long idvu) {
		this.idvu = idvu;
	}
	public String getHora_salida() {
		return hora_salida;
	}
	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}
	public String getHora_llegada() {
		return hora_llegada;
	}
	public void setHora_llegada(String hora_llegada) {
		this.hora_llegada = hora_llegada;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	
	
}
