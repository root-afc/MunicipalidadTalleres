package pe.gob.munisantanita.talleres.endpoint.secciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.SeccionFixed;
import pe.gob.munisantanita.talleres.endpoint.secciones.repository.SeccionFixedRepository;

@Service
public class SeccionFixedService {
    @Autowired
    SeccionFixedRepository seccionFixedRepository;
    public void save (SeccionFixed seccionFixed) {
        seccionFixedRepository.save(seccionFixed);
    }
    public void update (SeccionFixed seccionFixed) {
        seccionFixedRepository.save(seccionFixed);
    }

    public SeccionFixed findById (Long id) {
        return seccionFixedRepository.findById(id).orElse(null);
    }
}
