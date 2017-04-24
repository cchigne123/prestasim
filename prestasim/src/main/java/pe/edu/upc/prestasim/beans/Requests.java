package pe.edu.upc.prestasim.beans;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Requests {

	private Integer id_request;
	private Integer id_user;
	private Double amount;
	private Integer installments;
	private Date register_date;
	private Integer id_loan_type;
	private List<RequestTaxes> options;

	private String loanTypeName;

	public Integer getId_request() {
		return id_request;
	}
	public void setId_request(Integer idsolicitud) {
		this.id_request = idsolicitud;
	}
	public Integer getId_user() {
		return id_user;
	}
	public void setId_user(Integer idusuario) {
		this.id_user = idusuario;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double monto) {
		this.amount = monto;
	}
	public Integer getInstallments() {
		return installments;
	}
	public void setInstallments(Integer plazo) {
		this.installments = plazo;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date fecsolicitud) {
		this.register_date = fecsolicitud;
	}
	public Integer getId_loan_type() {
		return id_loan_type;
	}
	public void setId_loan_type(Integer idtipoprestamo) {
		this.id_loan_type = idtipoprestamo;
	}
	public List<RequestTaxes> getOptions() {
		return options;
	}
	public void setOptions(List<RequestTaxes> opciones) {
		this.options = opciones;
	}
	public String getLoanTypeName() {
		return loanTypeName;
	}
	public void setLoanTypeName(String nomtipoprestamo) {
		this.loanTypeName = nomtipoprestamo;
	}

}
