package pe.edu.upc.prestasim.beans;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Solicitud {

	private Integer idsolicitud;
	private Integer idusuario;
	private Double monto;
	private Integer plazo;
	private Date fecsolicitud;
	private Integer idtipoprestamo;
	private List<SolicitudTasaInteres> opciones;

	private String nomtipoprestamo;

	public Integer getIdsolicitud() {
		return idsolicitud;
	}
	public void setIdsolicitud(Integer idsolicitud) {
		this.idsolicitud = idsolicitud;
	}
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Integer getPlazo() {
		return plazo;
	}
	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}
	public Date getFecsolicitud() {
		return fecsolicitud;
	}
	public void setFecsolicitud(Date fecsolicitud) {
		this.fecsolicitud = fecsolicitud;
	}
	public Integer getIdtipoprestamo() {
		return idtipoprestamo;
	}
	public void setIdtipoprestamo(Integer idtipoprestamo) {
		this.idtipoprestamo = idtipoprestamo;
	}
	public List<SolicitudTasaInteres> getOpciones() {
		return opciones;
	}
	public void setOpciones(List<SolicitudTasaInteres> opciones) {
		this.opciones = opciones;
	}
	public String getNomtipoprestamo() {
		return nomtipoprestamo;
	}
	public void setNomtipoprestamo(String nomtipoprestamo) {
		this.nomtipoprestamo = nomtipoprestamo;
	}

}
