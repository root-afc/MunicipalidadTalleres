package pe.gob.munisantanita.talleres.endpoint.estudiante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.munisantanita.talleres.endpoint.estudiante.entity.ApoderadoEstudiante;
import pe.gob.munisantanita.talleres.endpoint.estudiante.entity.Estudiante;
import pe.gob.munisantanita.talleres.endpoint.estudiante.repository.EstudiantesRepository;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;

import java.util.List;


@Service
public class EstudiantesServiceImpl implements EstudiantesService {

    @Autowired
    private EstudiantesRepository repository;

    @Override
    public Estudiante save(Estudiante object) {
        Estudiante estudiante = repository.findByDni(object.getDni());
        if(estudiante != null) estudiante.setId(estudiante.getId());
        estudiante = repository.save(estudiante);
        return estudiante; //repository.save(object);
    }

    @Override
    public Estudiante update(Estudiante object) throws ResourceFieldsException {
        if(object.getId() <= 0) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria es requerido"}});
        repository.findById(object.getId()).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion no existe"}} ));
        return repository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Estudiante findById(Long id) throws ResourceFieldsException {
        if(id <= 0) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria es requerido"}});
        return repository.findById(id).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria no existe"}} ));
    }

    @Override
    public List<Estudiante> findAll() {
        return repository.findAll();
    }

    @Override
    public Estudiante findByDni(String dni) {
        return repository.findByDni(dni);
    }


}
