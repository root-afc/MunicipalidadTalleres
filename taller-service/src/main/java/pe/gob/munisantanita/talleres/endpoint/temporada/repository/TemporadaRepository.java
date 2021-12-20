package pe.gob.munisantanita.talleres.endpoint.temporada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.temporada.entity.Temporada;

@Repository
public interface TemporadaRepository extends JpaRepository<Temporada, Long> {
}
