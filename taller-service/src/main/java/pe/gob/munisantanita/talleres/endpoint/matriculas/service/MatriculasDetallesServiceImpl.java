package pe.gob.munisantanita.talleres.endpoint.matriculas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.munisantanita.talleres.endpoint.matriculas.entity.Matricula;
import pe.gob.munisantanita.talleres.endpoint.matriculas.entity.MatriculaDetalle;
import pe.gob.munisantanita.talleres.endpoint.matriculas.repository.MatriculasDetallesRepository;
import pe.gob.munisantanita.talleres.endpoint.matriculas.repository.MatriculasRepository;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;

import java.util.List;

@Service
public class MatriculasDetallesServiceImpl implements MatriculasDetallesService {

    @Autowired
    private MatriculasDetallesRepository repository;


    @Override
    public MatriculaDetalle save(MatriculaDetalle object) {
       return repository.save(object);
    }

    @Override
    public MatriculaDetalle update(MatriculaDetalle object) throws ResourceFieldsException {
        if(object.getId() <= 0) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion es requerido"}});
        repository.findById(object.getId()).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion no existe"}} ));
        return repository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public MatriculaDetalle findById(Long id) throws ResourceFieldsException {
        if(id == null) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion es requerido"}});
        return repository.findById(id).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion no existe"}} ));
    }

    @Override
    public List<MatriculaDetalle> findAll() {
        return repository.findAll();
    }

}
