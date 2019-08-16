package aate.gob.pe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import aate.gob.pe.model.Rol;
import aate.gob.pe.model.RolMenu;

public interface IRolRepo extends JpaRepository<Rol, Integer> {
	
	@Query("from RolMenu rm where rm.rol.ROLCOD = :idRol")
	List<RolMenu> listarMenuPorRol(@Param("idRol") Integer idRol);
}
