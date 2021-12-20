package pe.gob.munisantanita.talleres.endpoint.horarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.horarios.entity.Horario;

import java.util.List;

@Repository
public interface HorariosRepository extends JpaRepository<Horario, Long> {

}
