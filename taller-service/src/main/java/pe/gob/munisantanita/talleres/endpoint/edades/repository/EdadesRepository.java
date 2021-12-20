package pe.gob.munisantanita.talleres.endpoint.edades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.edades.entity.Edad;

@Repository
public interface EdadesRepository extends JpaRepository<Edad, Long> {

}
