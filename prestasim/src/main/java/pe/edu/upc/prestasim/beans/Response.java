package pe.edu.upc.prestasim.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Response {

	private String coderesult;
	private String msgresult;
	private String status;
	private Users user;
	private List<PaymentRanks> paymentRanks;
	private List<LoanTypes> loanTypes;
	private Requests request;
	private List<Requests> requests;

	public String getCoderesult() {
		return coderesult;
	}
	public void setCoderesult(String coderesult) {
		this.coderesult = coderesult;
	}
	public String getMsgresult() {
		return msgresult;
	}
	public void setMsgresult(String msgresult) {
		this.msgresult = msgresult;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users usuario) {
		this.user = usuario;
	}
	public List<PaymentRanks> getPaymentRanks() {
		return paymentRanks;
	}
	public void setPaymentRanks(List<PaymentRanks> rangosIngreso) {
		this.paymentRanks = rangosIngreso;
	}
	public List<LoanTypes> getLoanTypes() {
		return loanTypes;
	}
	public void setLoanTypes(List<LoanTypes> tiposPrestamo) {
		this.loanTypes = tiposPrestamo;
	}
	public Requests getRequest() {
		return request;
	}
	public void setRequest(Requests solicitud) {
		this.request = solicitud;
	}
	public List<Requests> getRequests() {
		return requests;
	}
	public void setRequests(List<Requests> solicitudes) {
		this.requests = solicitudes;
	}

}
