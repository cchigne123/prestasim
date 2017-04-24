package pe.edu.upc.prestasim.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.prestasim.beans.Entities;
import pe.edu.upc.prestasim.beans.Requests;
import pe.edu.upc.prestasim.beans.RequestTaxes;
import pe.edu.upc.prestasim.beans.Taxes;
import pe.edu.upc.prestasim.dao.MasterDao;
import pe.edu.upc.prestasim.dao.SolicitudDao;

@Service
public class SolicitudServiceImpl implements SolicitudService {

	@Autowired
	private SolicitudDao solicDao;

	@Autowired
	private MasterDao masterDao;

	@Override
	public List<RequestTaxes> registerLoanRequest(Requests solicitud) {
		List<RequestTaxes> options = new ArrayList<>();
		List<Entities> entities = new ArrayList<>();
		List<Taxes> taxes = solicDao.obtainTaxForRequest(solicitud);
		if(taxes != null && !taxes.isEmpty() && solicDao.regLoanRequest(solicitud) > 0){
			for(Taxes tax : taxes){
				if(!entities.contains(tax.getId_entity())){
					entities.add(masterDao.obtainEntityDetails(tax.getId_entity()));
				}
				RequestTaxes soltasint = new RequestTaxes();
				soltasint.setId_request(solicitud.getId_request());
				soltasint.setId_tax(tax.getId_tax());
				soltasint.setInstallment_amount((solicitud.getAmount() + ((tax.getTax()/12)*solicitud.getInstallments()*
						solicitud.getAmount())/100)/solicitud.getInstallments());
				soltasint.setInitial_payment((solicitud.getAmount() * tax.getInitial_payment())/100);
				soltasint.setEntityName(entities.get(entities.indexOf(new Entities(tax.getId_entity()))).getName());
				options.add(soltasint);
				solicDao.regLoanRequestTax(soltasint);
			}
		}
		return options;
	}

	@Override
	public List<Requests> obtainLoanRequests(int idusuario) {
		return solicDao.obtainLoanRequests(idusuario);
	}

	@Override
	public Requests obtainLoanRequestOptions(Integer idsolicitud) {
		Requests sol = solicDao.obtainLoanRequestById(idsolicitud);
		if(sol != null){
			sol.setOptions(solicDao.obtainLoanRequestOptions(idsolicitud));
		}
		return sol;
	}

}
