package aate.gob.pe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aate.gob.pe.model.Usuario;

//@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {
	
	//Usuario findOneByNombre(String username);
	
	@Query(value = "select u from Usuario u WHERE u.USULOG = :username")
	Usuario buscarUsuarioxLogin(String username);
	
	@Query(value = "select * from ACSE_TM_USUARIO WHERE TRIM(USUDNI)= :dni", nativeQuery = true)
	List<Object[]> dniFindAll(@Param("dni") String dni);
	
	@Query(value = "select * from ACSE_TM_USUARIO WHERE TRIM(USULOG)= :login", nativeQuery = true)
	List<Object[]> loginFindAll(@Param("login") String login);
	
	@Query(value = "select * from ACSE_TM_USUARIO WHERE TRIM(USUDNI)= :dni AND TRIM(USULOG)= :login AND TRIM(USUPAS)= :password", nativeQuery = true)
	List<Object[]> validaAccesoDNIUsuario(@Param("dni") String dni, @Param("login") String login, @Param("password") String password);
	
	@Query(value = "select * from ACSE_TM_USUARIO WHERE TRIM(USUDNI)= :dni AND TRIM(USUCOR)= :correo AND TRIM(USUPAS)= :password", nativeQuery = true)
	List<Object[]> validaAccesoDNICorreo (@Param("dni") String dni, @Param("correo") String correo, @Param("password") String password);
}
