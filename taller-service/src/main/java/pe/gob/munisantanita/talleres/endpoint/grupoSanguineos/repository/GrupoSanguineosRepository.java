package pe.gob.munisantanita.talleres.endpoint.grupoSanguineos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.grupoSanguineos.entity.GrupoSanguineo;

@Repository
public interface GrupoSanguineosRepository extends JpaRepository<GrupoSanguineo, Long> {

}
