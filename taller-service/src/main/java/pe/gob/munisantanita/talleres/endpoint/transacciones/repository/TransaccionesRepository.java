package pe.gob.munisantanita.talleres.endpoint.transacciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.transacciones.entity.Transaccion;

@Repository
public interface TransaccionesRepository extends JpaRepository<Transaccion, Long> {

}
