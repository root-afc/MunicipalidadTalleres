package pe.gob.munisantanita.talleres.endpoint.niveles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.munisantanita.talleres.endpoint.niveles.entity.Nivel;
import pe.gob.munisantanita.talleres.endpoint.niveles.repository.NivelesRepository;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;

import java.util.List;

@Service
public class NivelesServiceImpl implements NivelesService {

    @Autowired
    private NivelesRepository repository;

    @Override
    public Nivel save(Nivel object) {
       //return repository.save(object);
        return null;
    }

    @Override
    public Nivel update(Nivel object) throws ResourceFieldsException {
        /*if(object.getId() <= 0) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria es requerido"}});
        repository.findById(object.getId()).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion no existe"}} ));
        return repository.save(object);*/
        return null;
    }

    @Override
    public void deleteById(Long id) {
        //repository.deleteById(id);
    }

    @Override
    public Nivel findById(Long id) throws ResourceFieldsException {
        if(id == null) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria es requerido"}});
        return repository.findById(id).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria no existe"}} ));
    }

    @Override
    public List<Nivel> findAll() {
        return repository.findAll();
    }
}
