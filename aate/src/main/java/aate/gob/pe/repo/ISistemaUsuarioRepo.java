package aate.gob.pe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aate.gob.pe.model.SistemaUsuario;

//@Repository
public interface ISistemaUsuarioRepo extends JpaRepository<SistemaUsuario, Integer> {
	
	@Query(value = "SELECT USUSISCOD, USUCOD, SISCOD FROM ACSE_TV_USUARIO_SISTEMA WHERE USUCOD = :usucod AND SISCOD = siscod", nativeQuery = true)
	List<Object[]> buscarSistemaUsuario(@Param("usucod") int usucod, @Param("siscod") int siscod);
	
}
