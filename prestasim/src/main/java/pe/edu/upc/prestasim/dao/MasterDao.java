package pe.edu.upc.prestasim.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.edu.upc.prestasim.beans.Entities;
import pe.edu.upc.prestasim.beans.PaymentRanks;
import pe.edu.upc.prestasim.beans.LoanTypes;

public interface MasterDao {

	List<PaymentRanks> obtainPaymentRanks();
	List<LoanTypes> obtainLoanTypes();
	Entities obtainEntityDetails(@Param("id_entity") Integer identidad);

}
