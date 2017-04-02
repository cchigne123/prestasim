package pe.edu.upc.prestasim.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.prestasim.beans.Entidad;
import pe.edu.upc.prestasim.beans.Solicitud;
import pe.edu.upc.prestasim.beans.SolicitudTasaInteres;
import pe.edu.upc.prestasim.beans.TasaInteres;
import pe.edu.upc.prestasim.dao.MasterDao;
import pe.edu.upc.prestasim.dao.SolicitudDao;

@Service
public class SolicitudServiceImpl implements SolicitudService {

	@Autowired
	private SolicitudDao solicDao;

	@Autowired
	private MasterDao masterDao;

	@Override
	public List<SolicitudTasaInteres> registerLoanRequest(Solicitud solicitud) {
		List<SolicitudTasaInteres> options = new ArrayList<>();
		List<Entidad> entities = new ArrayList<>();
		List<TasaInteres> taxes = solicDao.obtainTaxForRequest(solicitud);
		if(taxes != null && !taxes.isEmpty() && solicDao.regLoanRequest(solicitud) > 0){
			for(TasaInteres tax : taxes){
				if(!entities.contains(tax.getIdentidad())){
					entities.add(masterDao.obtainEntityDetails(tax.getIdentidad()));
				}
				SolicitudTasaInteres soltasint = new SolicitudTasaInteres();
				soltasint.setIdsolicitud(solicitud.getIdsolicitud());
				soltasint.setIdtasa(tax.getIdtasa());
				soltasint.setMontocuota((solicitud.getMonto() + ((tax.getTasa()/12)*solicitud.getPlazo()*
						solicitud.getMonto())/100)/solicitud.getPlazo());
				soltasint.setCuotainicial((solicitud.getMonto() * tax.getCuotainicial())/100);
				soltasint.setNomentidad(entities.get(entities.indexOf(new Entidad(tax.getIdentidad()))).getNombre());
				options.add(soltasint);
				solicDao.regLoanRequestTax(soltasint);
			}
		}
		return options;
	}

	@Override
	public List<Solicitud> obtainLoanRequests(int idusuario) {
		return solicDao.obtainLoanRequests(idusuario);
	}

	@Override
	public Solicitud obtainLoanRequestOptions(Integer idsolicitud) {
		Solicitud sol = solicDao.obtainLoanRequestById(idsolicitud);
		if(sol != null){
			sol.setOpciones(solicDao.obtainLoanRequestOptions(idsolicitud));
		}
		return sol;
	}

}
