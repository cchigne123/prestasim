package pe.edu.upc.prestasim.service;

import java.util.List;

import pe.edu.upc.prestasim.beans.RangoIngreso;
import pe.edu.upc.prestasim.beans.TipoPrestamo;

public interface MasterService {

	List<RangoIngreso> obtainPaymentRanks();
	List<TipoPrestamo> obtainLoanTypes();

}
