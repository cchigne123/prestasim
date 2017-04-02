package pe.edu.upc.prestasim.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Response {

	private String coderesult;
	private String msgresult;
	private String status;
	private Usuario usuario;
	private List<RangoIngreso> rangosIngreso;
	private List<TipoPrestamo> tiposPrestamo;

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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<RangoIngreso> getRangosIngreso() {
		return rangosIngreso;
	}
	public void setRangosIngreso(List<RangoIngreso> rangosIngreso) {
		this.rangosIngreso = rangosIngreso;
	}
	public List<TipoPrestamo> getTiposPrestamo() {
		return tiposPrestamo;
	}
	public void setTiposPrestamo(List<TipoPrestamo> tiposPrestamo) {
		this.tiposPrestamo = tiposPrestamo;
	}

}
