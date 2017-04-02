package pe.edu.upc.prestasim.beans;

public class Entidad {

	private int identidad;
	private String nombre;
	private String nomcontacto;
	private String email;
	private String telefono;

	public int getIdentidad() {
		return identidad;
	}
	public void setIdentidad(int identidad) {
		this.identidad = identidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNomcontacto() {
		return nomcontacto;
	}
	public void setNomcontacto(String nomcontacto) {
		this.nomcontacto = nomcontacto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + identidad;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entidad other = (Entidad) obj;
		if (identidad != other.identidad)
			return false;
		return true;
	}

}
