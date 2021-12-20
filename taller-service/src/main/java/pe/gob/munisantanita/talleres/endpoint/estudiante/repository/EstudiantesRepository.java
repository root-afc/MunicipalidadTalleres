package pe.gob.munisantanita.talleres.endpoint.estudiante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.apoderados.entity.Apoderado;
import pe.gob.munisantanita.talleres.endpoint.estudiante.entity.Estudiante;

@Repository
public interface EstudiantesRepository extends JpaRepository<Estudiante, Long> {

    /*@Query("SELECT AP FROM ApoderadoEstudiante AS AP WHERE AP.estudiante.id = :estudiante")
    Apoderado findByIdApoderado(@Param("estudiante") int estudiante);*/

    @Query("SELECT E FROM Estudiante AS E WHERE E.dni = :dni ")
    Estudiante findByDni(@Param("dni") String dni);

}
