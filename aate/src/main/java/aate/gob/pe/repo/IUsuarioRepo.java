package aate.gob.pe.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import aate.gob.pe.model.Usuario;

//@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {
	
	@Query(value = "select u from Usuario u WHERE u.USULOG = :username")
	Usuario buscarUsuarioxLogin(String username);
}
