package pe.edu.upc.prestasim.service;

import java.util.List;

import pe.edu.upc.prestasim.beans.PaymentRanks;
import pe.edu.upc.prestasim.beans.LoanTypes;

public interface MasterService {

	List<PaymentRanks> obtainPaymentRanks();
	List<LoanTypes> obtainLoanTypes();

}
