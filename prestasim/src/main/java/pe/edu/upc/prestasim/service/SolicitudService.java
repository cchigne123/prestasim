package pe.edu.upc.prestasim.service;

import java.util.List;

import pe.edu.upc.prestasim.beans.Requests;
import pe.edu.upc.prestasim.beans.RequestTaxes;

public interface SolicitudService {

	List<RequestTaxes> registerLoanRequest(Requests solicitud);
	List<Requests> obtainLoanRequests(int idusuario);
	Requests obtainLoanRequestOptions(Integer idsolicitud);

}
