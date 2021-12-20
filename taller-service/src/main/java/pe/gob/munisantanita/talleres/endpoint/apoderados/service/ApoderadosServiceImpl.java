package pe.gob.munisantanita.talleres.endpoint.apoderados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.munisantanita.talleres.endpoint.apoderados.entity.Apoderado;
import pe.gob.munisantanita.talleres.endpoint.apoderados.repository.ApoderadosRepository;
import pe.gob.munisantanita.talleres.endpoint.estudiante.entity.Estudiante;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;
import java.util.List;

@Service
public class ApoderadosServiceImpl implements ApoderadosService {

    @Autowired
    private ApoderadosRepository repository;

    @Override
    public Apoderado save(Apoderado object) {
        return repository.save(object);
    }

    @Override
    public Apoderado update(Apoderado object) throws ResourceFieldsException {
        if(object.getId() <= 0) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria es requerido"}});
        repository.findById(object.getId()).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion no existe"}} ));
        return repository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Apoderado findById(Long id) throws ResourceFieldsException {
        if(id <= 0) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria es requerido"}});
        return repository.findById(id).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria no existe"}} ));
    }

    @Override
    public List<Apoderado> findAll() {
        return repository.findAll();
    }

    @Override
    public Apoderado findByIdEstudiante(Long estudiante_id){
        return repository.findByIdEstudiante(estudiante_id);
    }

    @Override
    public Apoderado findByDni(String dni) {
        return repository.findByDni(dni);
    }
}
