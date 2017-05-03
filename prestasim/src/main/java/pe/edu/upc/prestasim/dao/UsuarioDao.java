package pe.edu.upc.prestasim.dao;

import org.apache.ibatis.annotations.Param;

import pe.edu.upc.prestasim.beans.Users;

public interface UsuarioDao {

	int regUser(Users usuario);
	Users obtainUser(@Param("id_user") int idusuario);
	Users authUser(Users user);
	int updateUser(Users usuario);
	Users obtainUserByDni(@Param("dni") String dni);

}
