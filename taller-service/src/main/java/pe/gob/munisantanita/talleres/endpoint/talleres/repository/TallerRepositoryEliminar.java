package pe.gob.munisantanita.talleres.endpoint.talleres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.TallerEliminar;


public interface TallerRepositoryEliminar extends JpaRepository<TallerEliminar, Long> {
    @Modifying
    @Transactional
    @Query(value = "update secciones set estado = 0 where id = :id", nativeQuery = true)
    void eliminarSeccion(@Param("id") int id);
}
