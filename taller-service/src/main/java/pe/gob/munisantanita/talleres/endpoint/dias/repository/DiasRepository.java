package pe.gob.munisantanita.talleres.endpoint.dias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.dias.entity.Dia;

@Repository
public interface DiasRepository extends JpaRepository<Dia, Long> {

}
