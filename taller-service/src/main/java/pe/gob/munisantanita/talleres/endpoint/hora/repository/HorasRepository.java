package pe.gob.munisantanita.talleres.endpoint.hora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.hora.entity.Hora;

@Repository
public interface HorasRepository extends JpaRepository<Hora, Long> {

}
