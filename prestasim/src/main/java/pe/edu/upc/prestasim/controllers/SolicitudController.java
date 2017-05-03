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
import pe.edu.upc.prestasim.beans.Requests;
import pe.edu.upc.prestasim.service.SolicitudService;
import pe.edu.upc.prestasim.utils.CodeResult;
import pe.edu.upc.prestasim.utils.Constants;

@RestController
@RequestMapping(value="/usuarios/{id}/solicitudes")
public class SolicitudController {

	@Autowired
	private SolicitudService solicService;

	@RequestMapping(method = RequestMethod.POST, produces = Constants.APPLICATIONJSON)
    public @ResponseBody Response regSolicitud(@PathVariable("id") Integer iduser, @RequestBody Requests solicitud) {
		Response response = new Response();
		try {
			solicitud.setRegister_date(new Date());
			solicitud.setId_user(iduser);
			solicitud.setOptions(solicService.registerLoanRequest(solicitud));
			response.setRequest(solicitud);
			response.setCoderesult(CodeResult.OK.getCode());
		} catch (Exception e){
			System.out.println(e.getMessage() + " >> " + CodeResult.GENERIC_ERROR.getMessage());
			response.setCoderesult(CodeResult.GENERIC_ERROR.getCode());
			response.setMsgresult(CodeResult.GENERIC_ERROR.getMessage());
			response.setStatus(CodeResult.GENERIC_ERROR.getStatus());
		}
		return response;
    }

	@RequestMapping(method = RequestMethod.GET, produces = Constants.APPLICATIONJSON)
    public @ResponseBody Response obtainSolicitudes(@PathVariable("id") Integer iduser) {
		Response response = new Response();
		try {
			response.setRequests(solicService.obtainLoanRequests(iduser));
			response.setCoderesult(CodeResult.OK.getCode());
		} catch (Exception e){
			System.out.println(e.getMessage() + " >> " + CodeResult.GENERIC_ERROR.getMessage());
			response.setCoderesult(CodeResult.GENERIC_ERROR.getCode());
			response.setMsgresult(CodeResult.GENERIC_ERROR.getMessage());
			response.setStatus(CodeResult.GENERIC_ERROR.getStatus());
		}
		return response;
    }

	@RequestMapping(value="/{idsolicitud}", method = RequestMethod.GET, produces = Constants.APPLICATIONJSON)
    public @ResponseBody Response obtainOpcioneSolicitud(@PathVariable("id") Integer iduser, @PathVariable("idsolicitud") Integer idsol) {
		Response response = new Response();
		try {
			Requests sol = solicService.obtainLoanRequestOptions(idsol);
			if(sol.getId_user().equals(iduser)){
				response.setRequest(solicService.obtainLoanRequestOptions(idsol));
				response.setCoderesult(CodeResult.OK.getCode());
			} else {
				response.setCoderesult(CodeResult.FORBIDDEN_REQUEST_ERROR.getCode());
				response.setMsgresult(CodeResult.FORBIDDEN_REQUEST_ERROR.getMessage());
				response.setStatus(CodeResult.FORBIDDEN_REQUEST_ERROR.getStatus());
			}
		} catch (Exception e){
			System.out.println(e.getMessage() + " >> " + CodeResult.GENERIC_ERROR.getMessage());
			response.setCoderesult(CodeResult.GENERIC_ERROR.getCode());
			response.setMsgresult(CodeResult.GENERIC_ERROR.getMessage());
			response.setStatus(CodeResult.GENERIC_ERROR.getStatus());
		}
		return response;
    }

}
