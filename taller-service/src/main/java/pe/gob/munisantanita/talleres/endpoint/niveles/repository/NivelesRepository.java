package pe.gob.munisantanita.talleres.endpoint.niveles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.niveles.entity.Nivel;

@Repository
public interface NivelesRepository extends JpaRepository<Nivel, Long> {

}
