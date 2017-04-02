package pe.edu.upc.prestasim.dao;

import org.apache.ibatis.annotations.Param;

import pe.edu.upc.prestasim.beans.Usuario;

public interface UsuarioDao {

	int regUser(Usuario usuario);
	Usuario obtainUser(@Param("idusuario")int idusuario);
	Usuario authUser(Usuario user);
	int updateUser(Usuario usuario);

}
