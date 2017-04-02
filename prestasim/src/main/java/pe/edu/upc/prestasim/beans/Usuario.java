package pe.edu.upc.prestasim.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Usuario {

	private Integer idusuario;
	private String nombre;
	private Integer dni;
	private String clave;
	private String telefono;
	private String email;
	private Date fecnacimiento;
	private Integer idrangoingreso;
	private String autorizacion;

	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFecnacimiento() {
		return fecnacimiento;
	}
	public void setFecnacimiento(Date fecnacimiento) {
		this.fecnacimiento = fecnacimiento;
	}
	public int getIdrangoingreso() {
		return idrangoingreso;
	}
	public void setIdrangoingreso(Integer idrangoingreso) {
		this.idrangoingreso = idrangoingreso;
	}
	public String getAutorizacion() {
		return autorizacion;
	}
	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}

	@Override
	public String toString() {
		return "Usuario: {"
		+ "Nombre: " + this.nombre + ", DNI: " + this.dni
		+ ", Email: " + this.email + ", Nacimiento: " + this.fecnacimiento
		+ ", RangoIngreso: " + this.idrangoingreso + ", Autorizacion: " + this.autorizacion + "}";
	}
}
