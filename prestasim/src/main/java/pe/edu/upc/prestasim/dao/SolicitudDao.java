package pe.edu.upc.prestasim.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.edu.upc.prestasim.beans.Solicitud;
import pe.edu.upc.prestasim.beans.SolicitudTasaInteres;
import pe.edu.upc.prestasim.beans.TasaInteres;

public interface SolicitudDao {

	List<TasaInteres> obtainTaxForRequest(Solicitud solicitud);
	int regLoanRequest(Solicitud solicitud);
	int regLoanRequestTax(SolicitudTasaInteres soltasint);
	List<Solicitud> obtainLoanRequests(@Param("idusuario") Integer idusuario);
	List<SolicitudTasaInteres> obtainLoanRequestOptions(@Param("idsolicitud") Integer idsolicitud);
	Solicitud obtainLoanRequestById(@Param("idsolicitud") Integer idsolicitud);

}
