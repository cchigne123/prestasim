package pe.edu.upc.prestasim.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class RequestTaxes {

	private int id_request;
	private int id_tax;
	private Double installment_amount;
	private Double initial_payment;
	private String entityName;

	public int getId_request() {
		return id_request;
	}
	public void setId_request(int idsolicitud) {
		this.id_request = idsolicitud;
	}
	public int getId_tax() {
		return id_tax;
	}
	public void setId_tax(int idtasa) {
		this.id_tax = idtasa;
	}
	public Double getInstallment_amount() {
		return installment_amount;
	}
	public void setInstallment_amount(Double montocuota) {
		this.installment_amount = montocuota;
	}
	public Double getInitial_payment() {
		return initial_payment;
	}
	public void setInitial_payment(Double cuotainicial) {
		this.initial_payment = cuotainicial;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String nomentidad) {
		this.entityName = nomentidad;
	}

}
