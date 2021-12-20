package pe.gob.munisantanita.talleres.endpoint.matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.matriculas.entity.Matricula;

@Repository
public interface MatriculasRepository extends JpaRepository<Matricula, Long> {

    @Query("SELECT M FROM Matricula AS M INNER JOIN Estudiante AS E ON E.id = M.estudiante.id WHERE M.Id = :id AND E.dni = :dni ")
    Matricula findByIdAndDni(@Param("id") Long id, @Param("dni") String dni);

}
