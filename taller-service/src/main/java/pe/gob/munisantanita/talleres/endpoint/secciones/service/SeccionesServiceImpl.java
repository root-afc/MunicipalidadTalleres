package pe.gob.munisantanita.talleres.endpoint.secciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Filtro;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Seccion;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.TallerContenido;
import pe.gob.munisantanita.talleres.endpoint.secciones.repository.SeccionesRepository;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeccionesServiceImpl implements SeccionesService {

    @Autowired
    private SeccionesRepository repository;

    @Autowired
    private EntityManager em;

    @Override
    public void setSeccionById(Long id) {
        repository.setSeccionById(id);
    }

    @Override
    public Seccion save(Seccion object) {
       return repository.save(object);
    }

    @Override
    public Seccion update(Seccion object) throws ResourceFieldsException {
        if(object.getId() <= 0) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion es requerido"}});
        repository.findById(object.getId()).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion no existe"}} ));
        return repository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Seccion findById(Long id) throws ResourceFieldsException {
        if(id == null) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion es requerido"}});
        return repository.findById(id).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion no existe"}} ));
    }

    @Override
    public List<Seccion> findAll() {
        return repository.findAll();
    }


    public List<Seccion> filter(Filtro filtro) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Seccion> criteriaQ = cb.createQuery(Seccion.class);
        Root<Seccion> root = criteriaQ.from(Seccion.class);

        //criteriaQ.select(root);

        List<Predicate> predicates = new ArrayList<>();

        if(filtro.getCategoria() != null && filtro.getCategoria().size() > 0)
            predicates.add(  root.get("taller").get("categoria").in(filtro.getCategoria())   );

        if(filtro.getTalleres() != null && filtro.getTalleres().size() > 0)
            predicates.add(  root.get("taller").in(filtro.getTalleres())   );

        if(filtro.getEdades() != null && filtro.getEdades().size() > 0)
            predicates.add(  root.get("edad").in(filtro.getEdades())  );

        if(filtro.getNiveles() != null && filtro.getNiveles().size() > 0)
            predicates.add( root.get("nivel").in(filtro.getNiveles())  );

        predicates.add( root.get("estado").in("1")  );
        criteriaQ.select(root)
                .where(predicates.toArray(new Predicate[]{})).orderBy(cb.desc(root.get("maximo")));

        List<Seccion> result =  em.createQuery(criteriaQ).getResultList();

        return result;
    }

    @Override
    public List<Seccion> findByIdCategoria(int id) {
        return repository.findByIdCategoria(id);
    }


}
