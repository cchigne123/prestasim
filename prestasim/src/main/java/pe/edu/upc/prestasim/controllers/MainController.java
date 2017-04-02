package pe.edu.upc.prestasim.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.prestasim.beans.Response;
import pe.edu.upc.prestasim.beans.Usuario;
import pe.edu.upc.prestasim.service.UsuarioService;
import pe.edu.upc.prestasim.utils.CodeResult;
import pe.edu.upc.prestasim.utils.Constants;

@RestController
public class MainController {

	@Autowired
	private UsuarioService userService;

	@RequestMapping(value="/login", method = RequestMethod.POST, produces = Constants.APPLICATIONJSON)
    public @ResponseBody Response login(@RequestBody Usuario user) {
		Response response = new Response();
		try {
			user = userService.authenticateUser(user);
			response.setStatus(CodeResult.OK.getStatus());
			response.setCoderesult(CodeResult.OK.getCode());
			response.setMsgresult(CodeResult.OK.getMessage());
			response.setUsuario(user);
			if(user == null){
				response.setCoderesult(CodeResult.LOGIN_ERROR.getCode());
				response.setMsgresult(CodeResult.LOGIN_ERROR.getMessage());
				response.setStatus(CodeResult.LOGIN_ERROR.getStatus());
			}
		} catch (Exception e){
			response.setCoderesult(CodeResult.GENERIC_ERROR.getCode());
			response.setMsgresult(e.getMessage() + " >> " + CodeResult.GENERIC_ERROR.getMessage());
			response.setStatus(CodeResult.GENERIC_ERROR.getStatus());
		}
		return response;
    }

}
