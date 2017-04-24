package pe.edu.upc.prestasim.service;

import pe.edu.upc.prestasim.beans.Users;

public interface UsuarioService {

	boolean registerUser(Users user);
	Users obtainUser(int idusuario);
	Users authenticateUser(Users user);
	boolean updateUser(Users user);

}
