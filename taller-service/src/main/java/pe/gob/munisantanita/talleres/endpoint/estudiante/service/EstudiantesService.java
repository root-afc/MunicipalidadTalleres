package pe.gob.munisantanita.talleres.endpoint.estudiante.service;

import pe.gob.munisantanita.talleres.endpoint.estudiante.entity.ApoderadoEstudiante;
import pe.gob.munisantanita.talleres.endpoint.estudiante.entity.Estudiante;
import pe.gob.munisantanita.talleres.global.services.IAbstractService;


public interface EstudiantesService extends IAbstractService<Estudiante, Long> {

    //ApoderadoEstudiante findByIdApoderado(int estudiante);
    Estudiante findByDni(String dni);
}
