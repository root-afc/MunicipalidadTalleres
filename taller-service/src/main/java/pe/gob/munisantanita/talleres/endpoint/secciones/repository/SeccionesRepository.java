package pe.gob.munisantanita.talleres.endpoint.secciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Seccion;

import java.util.List;

@Repository
public interface SeccionesRepository extends JpaRepository<Seccion, Long> {

    @Query("SELECT S from Seccion AS S INNER JOIN Taller AS T ON (T.id = S.taller.id) WHERE T.categoria.id = :categoria_id AND S.estado = 1 ORDER BY S.maximo DESC")
    List<Seccion> findByIdCategoria(@Param("categoria_id") long categoria_id);



    @Query("SELECT S from Seccion AS S WHERE S.estado = 1")
    List<Seccion> findAll();

    @Modifying
    @Query(value = "UPDATE secciones SET inscritos = LAST_INSERT_ID(inscritos + 1) where id = :id", nativeQuery = true)
    void setSeccionById(@Param("id") Long id);


}
