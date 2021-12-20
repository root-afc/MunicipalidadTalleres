package pe.gob.munisantanita.talleres.endpoint.ubigeo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.munisantanita.talleres.endpoint.ubigeo.entity.UbigeoDepartamento;
import pe.gob.munisantanita.talleres.endpoint.ubigeo.entity.UbigeoDistrito;
import pe.gob.munisantanita.talleres.endpoint.ubigeo.entity.UbigeoProvincia;
import pe.gob.munisantanita.talleres.endpoint.ubigeo.repository.UbigeoRepository;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;

import java.util.List;


@Service
public class UbigeoServiceImpl implements UbigeoService {

    @Autowired
    private UbigeoRepository repository;

    @Override
    public UbigeoDepartamento save(UbigeoDepartamento object) {
        return repository.save(object);
    }

    @Override
    public UbigeoDepartamento update(UbigeoDepartamento object) throws ResourceFieldsException {
        return null;
        /*if(object.getId() != null) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria es requerido"}});
        repository.findById(object.getId()).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion no existe"}} ));
        return repository.save(object);*/
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UbigeoDepartamento findById(Long id) throws ResourceFieldsException {
        if(id <= 0) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria es requerido"}});
        return repository.findById(id).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria no existe"}} ));
    }

    @Override
    public List<UbigeoDepartamento> findAll() {
        return repository.findAll();
    }


    @Override
    public List<UbigeoProvincia> findByIdDepartamento(String id){
        return  repository.findByIdDepartamento(id);
    }
    @Override
    public List<UbigeoDistrito> findByIdProvincia(String id){
        return  repository.findByIdProvincia(id);
    }


}
