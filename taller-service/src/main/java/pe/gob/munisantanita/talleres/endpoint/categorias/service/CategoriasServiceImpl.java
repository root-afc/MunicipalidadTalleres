package pe.gob.munisantanita.talleres.endpoint.categorias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pe.gob.munisantanita.talleres.endpoint.categorias.entity.Categoria;
import pe.gob.munisantanita.talleres.endpoint.categorias.repository.CategoriasRepository;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;

import java.util.List;

@Service
public class CategoriasServiceImpl implements CategoriasService {

    @Autowired
    private CategoriasRepository repository;

    @Override
    public Categoria save(Categoria object) {
       return repository.save(object);
    }

    @Override
    public Categoria update(Categoria object) throws ResourceFieldsException {
        if(object.getId() <= 0) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria es requerido"}});
        repository.findById(object.getId()).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion no existe"}} ));
        return repository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Categoria findById(Long id) throws ResourceFieldsException {
        if(id <= 0) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria es requerido"}});
        return repository.findById(id).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria no existe"}} ));
    }

    @Override
    public List<Categoria> findAll() {
        return repository.findAll();
    }
}
