package pe.edu.upc.prestasim.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Taxes {

	private int id_tax;
	private int id_entity;
	private int id_loan_type;
	private int age_limit;
	private Double min_sallary;
	private int tax;
	private int initial_payment;

	public int getId_tax() {
		return id_tax;
	}
	public void setId_tax(int idtasa) {
		this.id_tax = idtasa;
	}
	public int getId_entity() {
		return id_entity;
	}
	public void setId_entity(int identidad) {
		this.id_entity = identidad;
	}
	public int getId_loan_type() {
		return id_loan_type;
	}
	public void setId_loan_type(int idtipoprestamo) {
		this.id_loan_type = idtipoprestamo;
	}
	public int getAge_limit() {
		return age_limit;
	}
	public void setAge_limit(int edadtope) {
		this.age_limit = edadtope;
	}
	public Double getMin_sallary() {
		return min_sallary;
	}
	public void setMin_sallary(Double ingresomin) {
		this.min_sallary = ingresomin;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tasa) {
		this.tax = tasa;
	}
	public int getInitial_payment() {
		return initial_payment;
	}
	public void setInitial_payment(int cuotainicial) {
		this.initial_payment = cuotainicial;
	}

}
