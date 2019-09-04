package aate.gob.pe.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import aate.gob.pe.DTO.SistemaRolDTO;
import aate.gob.pe.model.RolMenu;

public interface IRolMenuRepo extends JpaRepository<RolMenu,Integer> {
	
	@Query(value = "select distinct new aate.gob.pe.DTO.SistemaRolDTO(rm.id, s.id, r.ROLNOM) from RolMenu rm join rm.menu m join m.sistema s join rm.rol r")
	List<SistemaRolDTO> buscarSistemaRol();
	
}
