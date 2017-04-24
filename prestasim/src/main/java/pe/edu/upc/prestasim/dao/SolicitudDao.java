package pe.edu.upc.prestasim.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.edu.upc.prestasim.beans.Requests;
import pe.edu.upc.prestasim.beans.RequestTaxes;
import pe.edu.upc.prestasim.beans.Taxes;

public interface SolicitudDao {

	List<Taxes> obtainTaxForRequest(Requests solicitud);
	int regLoanRequest(Requests solicitud);
	int regLoanRequestTax(RequestTaxes soltasint);
	List<Requests> obtainLoanRequests(@Param("id_user") Integer idusuario);
	List<RequestTaxes> obtainLoanRequestOptions(@Param("id_request") Integer idsolicitud);
	Requests obtainLoanRequestById(@Param("id_request") Integer idsolicitud);

}
