package pe.gob.munisantanita.talleres.endpoint.ubigeo.service;

import pe.gob.munisantanita.talleres.endpoint.ubigeo.entity.UbigeoDepartamento;
import pe.gob.munisantanita.talleres.endpoint.ubigeo.entity.UbigeoDistrito;
import pe.gob.munisantanita.talleres.endpoint.ubigeo.entity.UbigeoProvincia;
import pe.gob.munisantanita.talleres.global.services.IAbstractService;

import java.util.List;

public interface UbigeoService extends IAbstractService<UbigeoDepartamento, Long> {

    List<UbigeoProvincia> findByIdDepartamento(String id);
    List<UbigeoDistrito> findByIdProvincia(String id);
}
