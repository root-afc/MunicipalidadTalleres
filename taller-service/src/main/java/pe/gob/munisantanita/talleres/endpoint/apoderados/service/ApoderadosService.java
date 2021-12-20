package pe.gob.munisantanita.talleres.endpoint.apoderados.service;

import pe.gob.munisantanita.talleres.endpoint.apoderados.entity.Apoderado;
import pe.gob.munisantanita.talleres.endpoint.estudiante.entity.Estudiante;
import pe.gob.munisantanita.talleres.global.services.IAbstractService;


public interface ApoderadosService extends IAbstractService<Apoderado, Long> {
    Apoderado findByIdEstudiante(Long estudiante_id);
    Apoderado findByDni(String dni);
}
