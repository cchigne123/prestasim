package pe.edu.upc.prestasim.service;

import pe.edu.upc.prestasim.beans.Users;
import pe.edu.upc.prestasim.utils.CodeResult;

public interface UsuarioService {

	CodeResult registerUser(Users user);
	Users obtainUser(int idusuario);
	Users authenticateUser(Users user);
	boolean updateUser(Users user);

}
