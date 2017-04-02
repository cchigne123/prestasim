package pe.edu.upc.prestasim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.prestasim.beans.RangoIngreso;
import pe.edu.upc.prestasim.beans.TipoPrestamo;
import pe.edu.upc.prestasim.dao.MasterDao;

@Service
public class MasterServiceImpl implements MasterService {

	@Autowired
	private MasterDao masterDao;

	@Override
	public List<RangoIngreso> obtainPaymentRanks() {
		return masterDao.obtainPaymentRanks();
	}

	@Override
	public List<TipoPrestamo> obtainLoanTypes() {
		return masterDao.obtainLoanTypes();
	}

}
