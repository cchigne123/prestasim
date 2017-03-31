package pe.edu.upc.prestasim.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
		try {
			if(userService.registerUser(user)){
				response.setStatus(CodeResult.OK.getStatus());
				response.setMsgresult(CodeResult.OK.getMessage());
			} else {
				response.setCoderesult(CodeResult.REGISTER_ERROR.getCode());
				response.setMsgresult(CodeResult.REGISTER_ERROR.getMessage());
				response.setStatus(CodeResult.REGISTER_ERROR.getStatus());
			}
		} catch (Exception e){
			response.setCoderesult(CodeResult.GENERIC_ERROR.getCode());
			response.setMsgresult(e.getMessage() + " >> " + CodeResult.GENERIC_ERROR.getMessage());
			response.setStatus(CodeResult.GENERIC_ERROR.getStatus());
		}
		
		return response;
    }
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = Constants.APPLICATIONJSON)
    public @ResponseBody Response obtainUser(@PathVariable("id") Integer id) {
		Response response = new Response();
		try {
			response.setUsuario(userService.obtainUser(id));
		} catch (Exception e){
			response.setCoderesult(CodeResult.GENERIC_ERROR.getCode());
			response.setMsgresult(e.getMessage() + " >> " + CodeResult.GENERIC_ERROR.getMessage());
			response.setStatus(CodeResult.GENERIC_ERROR.getStatus());
		}
		return response;
    }
	
}
