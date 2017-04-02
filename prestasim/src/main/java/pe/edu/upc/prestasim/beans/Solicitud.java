package pe.edu.upc.prestasim.beans;

import java.util.Date;

public class Solicitud {

	private int idsolicitud;
	private int idusuario;
	private int idtasa;
	private Double monto;
	private int plazo;
	private Date fecsolicitud;
	private int cuotainicial;
	private String montocuota;

	public int getIdsolicitud() {
		return idsolicitud;
	}
	public void setIdsolicitud(int idsolicitud) {
		this.idsolicitud = idsolicitud;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public int getIdtasa() {
		return idtasa;
	}
	public void setIdtasa(int idtasa) {
		this.idtasa = idtasa;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public int getPlazo() {
		return plazo;
	}
	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}
	public Date getFecsolicitud() {
		return fecsolicitud;
	}
	public void setFecsolicitud(Date fecsolicitud) {
		this.fecsolicitud = fecsolicitud;
	}
	public int getCuotainicial() {
		return cuotainicial;
	}
	public void setCuotainicial(int cuotainicial) {
		this.cuotainicial = cuotainicial;
	}
	public String getMontocuota() {
		return montocuota;
	}
	public void setMontocuota(String montocuota) {
		this.montocuota = montocuota;
	}

}
