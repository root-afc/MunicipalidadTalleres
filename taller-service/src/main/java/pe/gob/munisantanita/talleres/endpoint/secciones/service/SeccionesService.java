package pe.gob.munisantanita.talleres.endpoint.secciones.service;

import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Filtro;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Seccion;
import pe.gob.munisantanita.talleres.global.services.IAbstractService;

import java.util.List;

public interface SeccionesService extends IAbstractService<Seccion, Long> {
    List<Seccion> filter(Filtro filtro);
    List<Seccion> findByIdCategoria(int id);
    void setSeccionById(Long id);
}
