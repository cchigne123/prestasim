package pe.edu.upc.prestasim.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TipoPrestamo {

	private int idtipoprestamo;
	private String nombre;

	public int getIdtipoprestamo() {
		return idtipoprestamo;
	}
	public void setIdtipoprestamo(int idtipoprestamo) {
		this.idtipoprestamo = idtipoprestamo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
