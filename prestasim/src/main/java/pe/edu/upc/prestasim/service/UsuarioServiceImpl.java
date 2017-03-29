package pe.edu.upc.prestasim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.prestasim.beans.Usuario;
import pe.edu.upc.prestasim.dao.UsuarioDao;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao userDao;
	
	@Override
	public boolean registerUser(Usuario user) {
		return (0 < userDao.regUser(user));
	}

}
