package pe.edu.upc.prestasim.beans;

import java.util.Date;
import java.util.List;

public class Solicitud {

	private int idsolicitud;
	private int idusuario;
	private Double monto;
	private int plazo;
	private Date fecsolicitud;
	private int idtipoprestamo;
	private List<SolicitudTasaInteres> opciones;

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
	public int getIdtipoprestamo() {
		return idtipoprestamo;
	}
	public void setIdtipoprestamo(int idtipoprestamo) {
		this.idtipoprestamo = idtipoprestamo;
	}
	public List<SolicitudTasaInteres> getOpciones() {
		return opciones;
	}
	public void setOpciones(List<SolicitudTasaInteres> opciones) {
		this.opciones = opciones;
	}

}
