package pe.edu.upc.prestasim.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SolicitudTasaInteres {

	private int idsolicitud;
	private int idtasa;
	private Double montocuota;
	private Double cuotainicial;
	private String nomentidad;

	public int getIdsolicitud() {
		return idsolicitud;
	}
	public void setIdsolicitud(int idsolicitud) {
		this.idsolicitud = idsolicitud;
	}
	public int getIdtasa() {
		return idtasa;
	}
	public void setIdtasa(int idtasa) {
		this.idtasa = idtasa;
	}
	public Double getMontocuota() {
		return montocuota;
	}
	public void setMontocuota(Double montocuota) {
		this.montocuota = montocuota;
	}
	public Double getCuotainicial() {
		return cuotainicial;
	}
	public void setCuotainicial(Double cuotainicial) {
		this.cuotainicial = cuotainicial;
	}
	public String getNomentidad() {
		return nomentidad;
	}
	public void setNomentidad(String nomentidad) {
		this.nomentidad = nomentidad;
	}

}
