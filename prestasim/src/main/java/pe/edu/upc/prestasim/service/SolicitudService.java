package pe.edu.upc.prestasim.service;

import java.util.List;

import pe.edu.upc.prestasim.beans.Solicitud;
import pe.edu.upc.prestasim.beans.SolicitudTasaInteres;

public interface SolicitudService {

	List<SolicitudTasaInteres> registerLoanRequest(Solicitud solicitud);
	List<Solicitud> obtainLoanRequests(int idusuario);
	Solicitud obtainLoanRequestOptions(Integer idsolicitud);

}
