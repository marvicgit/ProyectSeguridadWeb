package aate.gob.pe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aate.gob.pe.model.Sistema;

//@Repository
public interface ISistemaRepo extends JpaRepository<Sistema, Integer> {
	
	@Query(value = "SELECT SISCOD, SISNOM, SISDES, SISSIG, SISEST, ESTREG FROM ACSE_TB_SISTEMA WHERE SISSIG = :sigla", nativeQuery = true)
	List<Object[]> siglaFindAll(@Param("sigla") String sigla);
}
