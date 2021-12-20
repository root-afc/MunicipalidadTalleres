package pe.gob.munisantanita.talleres.endpoint.lugares.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.munisantanita.talleres.endpoint.lugares.entity.Lugar;
import pe.gob.munisantanita.talleres.endpoint.lugares.repository.LugaresRepository;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;

import java.util.List;

@Service
public class LugaresServiceImpl implements LugaresService {

    @Autowired
    private LugaresRepository repository;

    @Override
    public Lugar save(Lugar object) {
        return repository.save(object);
    }

    @Override
    public Lugar update(Lugar object) throws ResourceFieldsException {
        if(object.getId() <= 0) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria es requerido"}});
        repository.findById(object.getId()).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion no existe"}} ));
        return repository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Lugar findById(Long id) throws ResourceFieldsException {
        if(id <= 0) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria es requerido"}});
        return repository.findById(id).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria no existe"}} ));
    }

    @Override
    public List<Lugar> findAll() {
        return repository.findAll();
    }
}
