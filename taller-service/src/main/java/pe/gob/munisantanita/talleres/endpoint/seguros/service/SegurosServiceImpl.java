package pe.gob.munisantanita.talleres.endpoint.seguros.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.munisantanita.talleres.endpoint.seguros.entity.Seguro;
import pe.gob.munisantanita.talleres.endpoint.seguros.repository.SegurosRepository;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;

import java.util.List;


@Service
public class SegurosServiceImpl implements SegurosService {

    @Autowired
    private SegurosRepository repository;

    @Override
    public Seguro save(Seguro object) {
        return repository.save(object);
    }

    @Override
    public Seguro update(Seguro object) throws ResourceFieldsException {
        if(object.getId() <= 0) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria es requerido"}});
        repository.findById(object.getId()).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion no existe"}} ));
        return repository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Seguro findById(Long id) throws ResourceFieldsException {
        if(id <= 0) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria es requerido"}});
        return repository.findById(id).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria no existe"}} ));
    }

    @Override
    public List<Seguro> findAll() {
        return repository.findAll();
    }


}
