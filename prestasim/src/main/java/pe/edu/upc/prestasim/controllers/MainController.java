package pe.edu.upc.prestasim.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.prestasim.beans.Response;
import pe.edu.upc.prestasim.beans.Users;
import pe.edu.upc.prestasim.service.MasterService;
import pe.edu.upc.prestasim.service.UsuarioService;
import pe.edu.upc.prestasim.utils.CodeResult;
import pe.edu.upc.prestasim.utils.Constants;

import java.nio.charset.CoderResult;

@RestController
public class MainController {

	@Autowired
	private UsuarioService userService;

	@Autowired
	private MasterService masterService;

	@RequestMapping(value="/login", method = RequestMethod.POST, produces = Constants.APPLICATIONJSON)
    public @ResponseBody Response login(@RequestBody Users user) {
		Response response = new Response();
		try {
			user = userService.authenticateUser(user);
			response.setStatus(CodeResult.OK.getStatus());
			response.setCoderesult(CodeResult.OK.getCode());
			response.setMsgresult(CodeResult.OK.getMessage());
			response.setUser(user);
			if(user == null){
				response.setCoderesult(CodeResult.LOGIN_ERROR.getCode());
				response.setMsgresult(CodeResult.LOGIN_ERROR.getMessage());
				response.setStatus(CodeResult.LOGIN_ERROR.getStatus());
			}
		} catch (Exception e){
			System.out.println(e.getMessage() + " >> " + CodeResult.GENERIC_ERROR.getMessage());
			response.setCoderesult(CodeResult.GENERIC_ERROR.getCode());
			response.setMsgresult(CodeResult.GENERIC_ERROR.getMessage());
			response.setStatus(CodeResult.GENERIC_ERROR.getStatus());
		}
		return response;
    }

	@RequestMapping(value="/paymentRanks", method = RequestMethod.GET, produces = Constants.APPLICATIONJSON)
    public @ResponseBody Response paymentRanks() {
		Response response = new Response();
		try {
			response.setPaymentRanks(masterService.obtainPaymentRanks());
			response.setCoderesult(CodeResult.OK.getCode());
		} catch (Exception e){
			System.out.println(e.getMessage() + " >> " + CodeResult.GENERIC_ERROR.getMessage());
			response.setCoderesult(CodeResult.GENERIC_ERROR.getCode());
			response.setMsgresult(CodeResult.GENERIC_ERROR.getMessage());
			response.setStatus(CodeResult.GENERIC_ERROR.getStatus());
		}
		return response;
    }

	@RequestMapping(value="/loanTypes", method = RequestMethod.GET, produces = Constants.APPLICATIONJSON)
    public @ResponseBody Response loanTypes() {
		Response response = new Response();
		try {
			response.setLoanTypes(masterService.obtainLoanTypes());
			response.setCoderesult(CodeResult.OK.getCode());
		} catch (Exception e){
			System.out.println(e.getMessage() + " >> " + CodeResult.GENERIC_ERROR.getMessage());
			response.setCoderesult(CodeResult.GENERIC_ERROR.getCode());
			response.setMsgresult(CodeResult.GENERIC_ERROR.getMessage());
			response.setStatus(CodeResult.GENERIC_ERROR.getStatus());
		}
		return response;
    }

}
