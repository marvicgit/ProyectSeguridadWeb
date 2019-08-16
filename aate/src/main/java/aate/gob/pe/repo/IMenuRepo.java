package aate.gob.pe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aate.gob.pe.model.Menu;
import aate.gob.pe.model.RolMenu;

public interface IMenuRepo extends JpaRepository<Menu,Integer> {

	@Query("from Menu u where u.sistema.SISCOD = :idSistema")
	List<Menu> listarPorIdSistema(@Param("idSistema")Integer idSistema);
	
	
}
