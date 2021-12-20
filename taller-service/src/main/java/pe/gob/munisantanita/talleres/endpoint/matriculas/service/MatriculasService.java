package pe.gob.munisantanita.talleres.endpoint.matriculas.service;

import pe.gob.munisantanita.talleres.endpoint.matriculas.entity.Matricula;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;
import pe.gob.munisantanita.talleres.global.services.IAbstractService;

public interface MatriculasService extends IAbstractService<Matricula, Long> {
    Matricula findByIdAndDni(Long id, String dni) throws ResourceFieldsException;
}
