package pe.gob.munisantanita.talleres.endpoint.ubigeo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.ubigeo.entity.UbigeoDepartamento;
import pe.gob.munisantanita.talleres.endpoint.ubigeo.entity.UbigeoDistrito;
import pe.gob.munisantanita.talleres.endpoint.ubigeo.entity.UbigeoProvincia;

import java.util.List;

@Repository
public interface UbigeoRepository extends JpaRepository<UbigeoDepartamento, Long> {


    //@Query("SELECT P FROM UbigeoDepartamento AS D INNER JOIN UbigeoProvincia AS P ON D.id = P.departamento.id WHERE P.departamento.id = :id")
    @Query("SELECT P FROM UbigeoProvincia AS P WHERE P.departamento_id = :id")
    List<UbigeoProvincia> findByIdDepartamento(@Param("id") String id);

    @Query("SELECT D FROM UbigeoDistrito AS D WHERE D.provincia_id = :id")
    List<UbigeoDistrito> findByIdProvincia(@Param("id") String id);
}
