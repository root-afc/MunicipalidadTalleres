package pe.gob.munisantanita.talleres.endpoint.talleres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.TallerAll;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.TallerFixed;
import pe.gob.munisantanita.talleres.endpoint.talleres.repository.TallerRepositoryEliminar;
import pe.gob.munisantanita.talleres.endpoint.talleres.repository.TalleresRepositoryAll;
import pe.gob.munisantanita.talleres.endpoint.talleres.repository.TalleresRepositoryFixed;

import java.util.List;

@Service
public class TalleresServiceFixed {
    @Autowired
    TalleresRepositoryFixed talleresRepositoryFixed;
    @Autowired
    TalleresRepositoryAll talleresRepositoryAll;
    @Autowired
    TallerRepositoryEliminar tallerRepositoryEliminar;
    public void save(TallerFixed tallerFixed) {
        talleresRepositoryFixed.save(tallerFixed);
    }
    public List<TallerFixed> listfixed () {
        return talleresRepositoryFixed.findAll();
    }
    public List<TallerAll> all(){
        return talleresRepositoryAll.lista();
    }
    public void eliminar(Integer id) {
        tallerRepositoryEliminar.eliminarSeccion(id);
    }
    public List<TallerAll> byId(Integer id){
        return talleresRepositoryAll.byid(id);
    }
}
