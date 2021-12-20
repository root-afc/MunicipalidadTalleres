package pe.gob.munisantanita.talleres.endpoint.talleres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.TallerAll;

import java.util.List;

public interface TalleresRepositoryAll  extends JpaRepository<TallerAll, Long> {
    @Query(value = "EXECUTE dbo.usp_talleres", nativeQuery = true)
    List<TallerAll> lista();
    @Query(value = "EXECUTE dbo.usp_talleresActualizar :nidSeccion", nativeQuery = true)
    List<TallerAll> byid(@Param("nidSeccion") Integer nidSeccion);
}
