package pe.edu.upc.prestasim.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Users {

	private Integer id_user;
	private String name;
	private String dni;
	private String password;
	private String phone_number;
	private String email;
	private String birth_date;
	private Integer id_payment_rank;
	private String authorization;

	public int getId_user() {
		return id_user;
	}
	public void setId_user(Integer idusuario) {
		this.id_user = idusuario;
	}
	public String getName() {
		return name;
	}
	public void setName(String nombre) {
		this.name = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String clave) {
		this.password = clave;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String telefono) {
		this.phone_number = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String fecnacimiento) {
		this.birth_date = fecnacimiento;
	}
	public int getId_payment_rank() {
		return id_payment_rank;
	}
	public void setId_payment_rank(Integer idrangoingreso) {
		this.id_payment_rank = idrangoingreso;
	}
	public String getAuthorization() {
		return authorization;
	}
	public void setAuthorization(String autorizacion) {
		this.authorization = autorizacion;
	}

	@Override
	public String toString() {
		return "Usuario: {"
		+ "Nombre: " + this.name + ", DNI: " + this.dni
		+ ", Email: " + this.email + ", Nacimiento: " + this.birth_date
		+ ", RangoIngreso: " + this.id_payment_rank
		+ ", Autorizacion: " + this.authorization + ", Telefono: " + this.phone_number + "}";
	}
}
