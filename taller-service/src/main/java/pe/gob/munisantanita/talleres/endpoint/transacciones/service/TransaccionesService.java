package pe.gob.munisantanita.talleres.endpoint.transacciones.service;

import pe.gob.munisantanita.talleres.endpoint.transacciones.entity.Operacion;
import pe.gob.munisantanita.talleres.endpoint.transacciones.entity.Transaccion;
import pe.gob.munisantanita.talleres.global.services.IAbstractService;

import java.io.IOException;

public interface TransaccionesService extends IAbstractService<Transaccion, Long> {

    Object constancia(Operacion constancia);

}
