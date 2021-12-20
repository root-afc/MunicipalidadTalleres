package pe.gob.munisantanita.talleres.endpoint.matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.matriculas.entity.MatriculaDetalle;

import java.util.List;

@Repository
public interface MatriculasDetallesRepository extends JpaRepository<MatriculaDetalle, Long> {

    @Query("SELECT M FROM MatriculaDetalle AS M WHERE M.matricula_id = :id")
    List<MatriculaDetalle> findByMatricula_id(@Param("id") long id);
}
