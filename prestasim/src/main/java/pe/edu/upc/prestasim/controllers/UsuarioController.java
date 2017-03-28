package pe.edu.upc.prestasim.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.prestasim.utils.Constants;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {

	@RequestMapping(value="/", method = RequestMethod.GET, produces = Constants.APPLICATIONJSON)
    public String dummyMessage() {
		return "Hello Dummy Guy!";
    }
	
	@RequestMapping(value="/{name}", method = RequestMethod.GET, produces = Constants.APPLICATIONJSON)
    public String dummyMessageName(@PathVariable("name") String name) {
		return "Hello " + name + " !";
    }
	
}
