package pe.gob.munisantanita.talleres.endpoint.talleres.service;

import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Filtro;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Seccion;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.Taller;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.TallerContenido;
import pe.gob.munisantanita.talleres.global.services.IAbstractService;

import java.util.List;

public interface TalleresService extends IAbstractService<Taller, Long> {
    List<TallerContenido> finByIdTallerTipo(int id, int idContenido);

}
