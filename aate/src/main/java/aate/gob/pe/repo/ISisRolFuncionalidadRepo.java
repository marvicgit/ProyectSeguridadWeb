package aate.gob.pe.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import aate.gob.pe.DTO.SisRolFuncionalidadDTO;
import aate.gob.pe.model.SisRolFuncionalidad;

public interface ISisRolFuncionalidadRepo extends JpaRepository<SisRolFuncionalidad,Integer> {

	
	  @Query(value = "select distinct new aate.gob.pe.DTO.SisRolFuncionalidadDTO(srf.SISROLFUNCOD, s,r,f) from SisRolFuncionalidad srf join srf.rol r join srf.funcionalidad f join Sistema s on s.SISCOD = srf.SISCOD ")
	  List<SisRolFuncionalidadDTO> listaSistemaRolFun();
	  
	 /* @Transactional
	 * 
	 * @Modifying
	 * 
	 * @Query(value =
	 * "delete from RolMenuFuncionalidad fun where fun.ROLMENFUNCOD in ( select rmf.ROLMENFUNCOD from RolMenuFuncionalidad rmf "
	 * +
	 * "join rmf.rolMenu rm join rm.menu m join m.sistema s join rm.rol r join rmf.funcionalidad f "
	 * + "where s.SISCOD = :siscod and r.ROLCOD = :rolcod and f.FUNCOD = :funcod )")
	 * void eliminarRolMenFunc(@Param("siscod") Integer siscod, @Param("rolcod")
	 * Integer rolcod, @Param("funcod") Integer funcod);
	 * 
	 * @Query(value =
	 * "select rmf.ROLMENFUNCOD from RolMenuFuncionalidad rmf join rmf.rolMenu rm join rm.menu m join m.sistema s join rm.rol r join rmf.funcionalidad f where s.SISCOD = :siscod and r.ROLCOD = :rolcod"
	 * ) List<Integer> buscarIdRolMenuFunxSistema(@Param("siscod") Integer
	 * siscod, @Param("rolcod") Integer rolcod);
	 */
	
}
