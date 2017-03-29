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
@RequestMapping(value="/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService userService;
	
	@RequestMapping(method = RequestMethod.POST, produces = Constants.APPLICATIONJSON)
    public @ResponseBody Response registerUser(@RequestBody Usuario user) {
		Response response = new Response();
		if(userService.registerUser(user)){
			response.setStatus(CodeResult.OK.getStatus());
			response.setMsgresult(CodeResult.OK.getMessage());
		} else {
			response.setCoderesult(CodeResult.GENERIC_ERROR.getCode());
			response.setMsgresult(CodeResult.GENERIC_ERROR.getMessage());
			response.setStatus(CodeResult.GENERIC_ERROR.getStatus());
		}
		return response;
    }
	
}
