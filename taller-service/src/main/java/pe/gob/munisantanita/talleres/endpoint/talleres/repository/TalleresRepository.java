package pe.gob.munisantanita.talleres.endpoint.talleres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Seccion;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.Taller;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.TallerContenido;

import java.util.List;

@Repository
public interface TalleresRepository extends JpaRepository<Taller, Long> {

    /*@Query("select SC from TallerContenido AS SC where SC.taller_id = ?1")
    List<TallerContenido> findByIdTaller(int id);*/

    @Query("SELECT SC from TallerContenido AS SC WHERE SC.taller_id = ?1 AND SC.tipo = ?2")
    List<TallerContenido> finByIdTallerTipo(int id, int idContenido);



}
