package pe.gob.munisantanita.talleres.endpoint.talleres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Filtro;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Seccion;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.Taller;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.TallerContenido;
import pe.gob.munisantanita.talleres.endpoint.talleres.repository.TalleresRepository;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class TalleresServiceImpl implements TalleresService {

    @Autowired
    private TalleresRepository repository;


    @Override
    public Taller save(Taller object) {
       return repository.save(object);
    }

    @Override
    public Taller update(Taller object) throws ResourceFieldsException {
        if(object.getId() <= 0) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion es requerido"}});
        repository.findById(object.getId()).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion no existe"}} ));
        return repository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Taller findById(Long id) throws ResourceFieldsException {
        if(id == null) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion es requerido"}});
        return repository.findById(id).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion no existe"}} ));
    }

    @Override
    public List<Taller> findAll() {
        return repository.findAll();
    }

    @Override
    public List<TallerContenido> finByIdTallerTipo(int id, int idContenido) {
        return repository.finByIdTallerTipo(id, idContenido);
    }





}
