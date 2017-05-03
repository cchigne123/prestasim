package pe.edu.upc.prestasim.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.prestasim.beans.Response;
import pe.edu.upc.prestasim.beans.Users;
import pe.edu.upc.prestasim.service.UsuarioService;
import pe.edu.upc.prestasim.utils.CodeResult;
import pe.edu.upc.prestasim.utils.Constants;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService userService;

	@RequestMapping(method = RequestMethod.POST, produces = Constants.APPLICATIONJSON)
    public @ResponseBody Response registerUser(@RequestBody Users user) {
		Response response = new Response();
		CodeResult codeResult = null;
		try {
			System.out.println(user.toString());
			codeResult = userService.registerUser(user);
			if(CodeResult.OK.equals(codeResult)){
				response.setUser(user);
			}
		} catch (Exception e){
			System.out.println(e.getMessage() + " >> " + CodeResult.GENERIC_ERROR.getMessage());
			codeResult = CodeResult.GENERIC_ERROR;
		}
		response.setCoderesult(codeResult.getCode());
		response.setMsgresult(codeResult.getMessage());
		response.setStatus(codeResult.getStatus());
		return response;
    }

	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = Constants.APPLICATIONJSON)
    public @ResponseBody Response obtainUser(@PathVariable("id") Integer id) {
		Response response = new Response();
		try {
			response.setUser(userService.obtainUser(id));
			if(null == response.getUser()){
				response.setStatus(CodeResult.INEXISTENT_USER_ERROR.getStatus());
				response.setMsgresult(CodeResult.INEXISTENT_USER_ERROR.getMessage());
				response.setCoderesult(CodeResult.INEXISTENT_USER_ERROR.getCode());
			} else {
				response.setStatus(CodeResult.OK.getStatus());
				response.setMsgresult(CodeResult.OK.getMessage());
				response.setCoderesult(CodeResult.OK.getCode());
			}
		} catch (Exception e){
			System.out.println(e.getMessage() + " >> " + CodeResult.GENERIC_ERROR.getMessage());
			response.setCoderesult(CodeResult.GENERIC_ERROR.getCode());
			response.setMsgresult(CodeResult.GENERIC_ERROR.getMessage());
			response.setStatus(CodeResult.GENERIC_ERROR.getStatus());

		}
		return response;
    }

	@RequestMapping(method = RequestMethod.PUT, produces = Constants.APPLICATIONJSON)
    public @ResponseBody Response updateUser(@RequestBody Users user) {
		Response response = new Response();
		try {
			response.setStatus(CodeResult.OK.getStatus());
			response.setMsgresult(CodeResult.OK.getMessage());
			response.setCoderesult(CodeResult.OK.getCode());
			if(!userService.updateUser(user)){
				response.setCoderesult(CodeResult.UPDATE_ERROR.getCode());
				response.setMsgresult(CodeResult.UPDATE_ERROR.getMessage());
				response.setStatus(CodeResult.UPDATE_ERROR.getStatus());
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
