package pe.gob.munisantanita.talleres.endpoint.edades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.munisantanita.talleres.endpoint.edades.entity.Edad;
import pe.gob.munisantanita.talleres.endpoint.edades.repository.EdadesRepository;
import pe.gob.munisantanita.talleres.endpoint.niveles.entity.Nivel;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;

import java.util.List;

@Service
public class EdadesServiceImpl implements EdadesService {

    @Autowired
    private EdadesRepository repository;

    @Override
    public Edad save(Edad object) throws ResourceFieldsException {
        return null;
    }

    @Override
    public Edad update(Edad object) throws ResourceFieldsException {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        //
    }

    @Override
    public Edad findById(Long id) throws ResourceFieldsException {
        if(id == null) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria es requerido"}});
        return repository.findById(id).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria no existe"}} ));
    }

    @Override
    public List<Edad> findAll() {
        return repository.findAll();
    }
}
