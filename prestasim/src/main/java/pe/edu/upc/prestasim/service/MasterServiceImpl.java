package pe.edu.upc.prestasim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.prestasim.beans.PaymentRanks;
import pe.edu.upc.prestasim.beans.LoanTypes;
import pe.edu.upc.prestasim.dao.MasterDao;

@Service
public class MasterServiceImpl implements MasterService {

	@Autowired
	private MasterDao masterDao;

	@Override
	public List<PaymentRanks> obtainPaymentRanks() {
		return masterDao.obtainPaymentRanks();
	}

	@Override
	public List<LoanTypes> obtainLoanTypes() {
		return masterDao.obtainLoanTypes();
	}

}
