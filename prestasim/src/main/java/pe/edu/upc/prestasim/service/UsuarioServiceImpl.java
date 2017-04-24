package pe.edu.upc.prestasim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.prestasim.beans.Users;
import pe.edu.upc.prestasim.dao.UsuarioDao;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao userDao;

	@Override
	public boolean registerUser(Users user) {
		return (0 < userDao.regUser(user));
	}

	@Override
	public Users obtainUser(int idusuario) {
		return userDao.obtainUser(idusuario);
	}

	@Override
	public Users authenticateUser(Users user) {
		return userDao.authUser(user);
	}

	@Override
	public boolean updateUser(Users user) {
		return (0 < userDao.updateUser(user));
	}

}
