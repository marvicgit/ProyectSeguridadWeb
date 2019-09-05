package aate.gob.pe.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import aate.gob.pe.DTO.SisRolFuncionalidadDTO;
import aate.gob.pe.model.RolMenuFuncionalidad;

public interface IRolMenuFuncionalidadRepo extends JpaRepository<RolMenuFuncionalidad,Integer> {

	@Query(value = "select distinct new aate.gob.pe.DTO.SisRolFuncionalidadDTO(s,r,f) from RolMenuFuncionalidad rmf join rmf.rolMenu rm join rm.menu m join m.sistema s join rm.rol r join rmf.funcionalidad f")
	List<SisRolFuncionalidadDTO> listaSistemaRolFun();
	
	@Transactional
	@Modifying
	@Query(value = "delete from RolMenuFuncionalidad fun where fun.ROLMENFUNCOD in ( select rmf.ROLMENFUNCOD from RolMenuFuncionalidad rmf "
				 + "join rmf.rolMenu rm join rm.menu m join m.sistema s join rm.rol r join rmf.funcionalidad f "
			     + "where s.SISCOD = :siscod and r.ROLCOD = :rolcod and f.FUNCOD = :funcod )")
	void eliminarRolMenFunc(@Param("siscod") Integer siscod, @Param("rolcod") Integer rolcod, @Param("funcod") Integer funcod);
	
}
