package pe.edu.upc.prestasim.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class LoanTypes {

	private int id_loan_type;
	private String name;

	public int getId_loan_type() {
		return id_loan_type;
	}
	public void setId_loan_type(int idtipoprestamo) {
		this.id_loan_type = idtipoprestamo;
	}
	public String getName() {
		return name;
	}
	public void setName(String nombre) {
		this.name = nombre;
	}

}
