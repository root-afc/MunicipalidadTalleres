package pe.gob.munisantanita.talleres.endpoint.lugares.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.lugares.entity.Lugar;

@Repository
public interface LugaresRepository extends JpaRepository<Lugar, Long> {

}
