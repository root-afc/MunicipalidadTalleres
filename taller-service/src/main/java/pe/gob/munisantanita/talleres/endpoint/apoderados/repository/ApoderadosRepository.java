package pe.gob.munisantanita.talleres.endpoint.apoderados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.apoderados.entity.Apoderado;
import pe.gob.munisantanita.talleres.endpoint.estudiante.entity.Estudiante;

@Repository
public interface ApoderadosRepository extends JpaRepository<Apoderado, Long> {

    @Query("SELECT A FROM Apoderado AS A WHERE A.estudiante.id = :estudiante_id")
    Apoderado findByIdEstudiante(@Param("estudiante_id") Long estudiante_id);


    @Query("SELECT A FROM Apoderado AS A WHERE A.dni = :dni ")
    Apoderado findByDni(@Param("dni") String dni);

}
