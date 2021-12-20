package pe.gob.munisantanita.talleres.endpoint.grupoSanguineos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.munisantanita.talleres.endpoint.grupoSanguineos.entity.GrupoSanguineo;
import pe.gob.munisantanita.talleres.endpoint.grupoSanguineos.repository.GrupoSanguineosRepository;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;

import java.util.List;

@Service
public class GrupoSanguineosServiceImpl implements GrupoSanguineosService {

    @Autowired
    private GrupoSanguineosRepository repository;

    @Override
    public GrupoSanguineo save(GrupoSanguineo object) {
        return repository.save(object);
    }

    @Override
    public GrupoSanguineo update(GrupoSanguineo object) throws ResourceFieldsException {
        if(object.getId() <= 0) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria es requerido"}});
        repository.findById(object.getId()).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion no existe"}} ));
        return repository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public GrupoSanguineo findById(Long id) throws ResourceFieldsException {
        if(id <= 0) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria es requerido"}});
        return repository.findById(id).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria no existe"}} ));
    }

    @Override
    public List<GrupoSanguineo> findAll() {
        return repository.findAll();
    }

}
