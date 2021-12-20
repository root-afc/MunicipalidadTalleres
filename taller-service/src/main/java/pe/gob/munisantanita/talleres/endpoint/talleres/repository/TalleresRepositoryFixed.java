package pe.gob.munisantanita.talleres.endpoint.talleres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.TallerFixed;

@Repository
public interface TalleresRepositoryFixed extends JpaRepository<TallerFixed, Long> {
}
