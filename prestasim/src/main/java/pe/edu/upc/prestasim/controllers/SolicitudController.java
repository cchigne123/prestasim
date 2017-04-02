package pe.edu.upc.prestasim.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.prestasim.beans.Response;
import pe.edu.upc.prestasim.beans.Solicitud;
import pe.edu.upc.prestasim.service.SolicitudService;
import pe.edu.upc.prestasim.utils.CodeResult;
import pe.edu.upc.prestasim.utils.Constants;

@RestController
@RequestMapping(value="/usuarios/{id}/solicitudes")
public class SolicitudController {

	@Autowired
	private SolicitudService solicService;

	@RequestMapping(method = RequestMethod.POST, produces = Constants.APPLICATIONJSON)
    public @ResponseBody Response regSolicitud(@PathVariable("id") Integer iduser, @RequestBody Solicitud solicitud) {
		Response response = new Response();
		try {
			solicitud.setFecsolicitud(new Date());
			solicitud.setIdusuario(iduser);
			solicitud.setOpciones(solicService.registerLoanRequest(solicitud));
			response.setSolicitud(solicitud);
		} catch (Exception e){
			response.setCoderesult(CodeResult.GENERIC_ERROR.getCode());
			response.setMsgresult(e.getMessage() + " >> " + CodeResult.GENERIC_ERROR.getMessage());
			response.setStatus(CodeResult.GENERIC_ERROR.getStatus());
		}
		return response;
    }

	@RequestMapping(method = RequestMethod.GET, produces = Constants.APPLICATIONJSON)
    public @ResponseBody Response obtainSolicitudes(@PathVariable("id") Integer iduser) {
		Response response = new Response();
		try {
			response.setSolicitudes(solicService.obtainLoanRequests(iduser));
		} catch (Exception e){
			response.setCoderesult(CodeResult.GENERIC_ERROR.getCode());
			response.setMsgresult(e.getMessage() + " >> " + CodeResult.GENERIC_ERROR.getMessage());
			response.setStatus(CodeResult.GENERIC_ERROR.getStatus());
		}
		return response;
    }

	@RequestMapping(value="/{idsolicitud}", method = RequestMethod.GET, produces = Constants.APPLICATIONJSON)
    public @ResponseBody Response obtainOpcioneSolicitud(@PathVariable("id") Integer iduser, @PathVariable("idsolicitud") Integer idsol) {
		Response response = new Response();
		try {
			Solicitud sol = solicService.obtainLoanRequestOptions(idsol);
			if(sol.getIdusuario().equals(iduser)){
				response.setSolicitud(solicService.obtainLoanRequestOptions(idsol));
			} else {
				response.setCoderesult(CodeResult.FORBIDDEN_REQUEST_ERROR.getCode());
				response.setMsgresult(CodeResult.FORBIDDEN_REQUEST_ERROR.getMessage());
				response.setStatus(CodeResult.FORBIDDEN_REQUEST_ERROR.getStatus());
			}
		} catch (Exception e){
			response.setCoderesult(CodeResult.GENERIC_ERROR.getCode());
			response.setMsgresult(e.getMessage() + " >> " + CodeResult.GENERIC_ERROR.getMessage());
			response.setStatus(CodeResult.GENERIC_ERROR.getStatus());
		}
		return response;
    }

}
