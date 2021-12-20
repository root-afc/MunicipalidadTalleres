package pe.gob.munisantanita.talleres.endpoint.horarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.munisantanita.talleres.endpoint.horarios.entity.Horario;
import pe.gob.munisantanita.talleres.endpoint.horarios.repository.HorariosRepository;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;

import java.util.List;

@Service
public class HorariosServiceImpl implements HorariosService {

    @Autowired
    private HorariosRepository repository;

    @Override
    public Horario save(Horario object) {
        return null;
    }

    @Override
    public Horario update(Horario object) throws ResourceFieldsException {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        //
    }

    @Override
    public Horario findById(Long id) throws ResourceFieldsException {
        if(id == null) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria es requerido"}});
        return repository.findById(id).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la categoria no existe"}} ));
    }

    @Override
    public List<Horario> findAll() {
        return repository.findAll();
    }
}
