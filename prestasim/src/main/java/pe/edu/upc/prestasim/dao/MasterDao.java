package pe.edu.upc.prestasim.dao;

import java.util.List;

import pe.edu.upc.prestasim.beans.RangoIngreso;
import pe.edu.upc.prestasim.beans.TipoPrestamo;

public interface MasterDao {

	List<RangoIngreso> obtainPaymentRanks();
	List<TipoPrestamo> obtainLoanTypes();

}