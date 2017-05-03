package pe.edu.upc.prestasim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.prestasim.beans.Users;
import pe.edu.upc.prestasim.dao.UsuarioDao;
import pe.edu.upc.prestasim.utils.CodeResult;

import java.nio.charset.CoderResult;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao userDao;

	@Override
	public CodeResult registerUser(Users user) {
		Users userOnDb = userDao.obtainUserByDni(user.getDni());
		if(userOnDb != null){
			return CodeResult.ALREADY_REGISTERED_USER;
		}
		if(0 >= userDao.regUser(user)){
			return CodeResult.REGISTER_ERROR;
		}
		return CodeResult.OK;
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
