package pe.gob.munisantanita.talleres.endpoint.secciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.SeccionFixed;

@Repository
public interface SeccionFixedRepository extends JpaRepository<SeccionFixed, Long> {
}
