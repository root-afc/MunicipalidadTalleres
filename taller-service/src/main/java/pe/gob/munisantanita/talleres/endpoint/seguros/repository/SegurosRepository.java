package pe.gob.munisantanita.talleres.endpoint.seguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.estudiante.entity.Estudiante;
import pe.gob.munisantanita.talleres.endpoint.seguros.entity.Seguro;

@Repository
public interface SegurosRepository extends JpaRepository<Seguro, Long> {

}
