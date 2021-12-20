package pe.gob.munisantanita.talleres.endpoint.temporada.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.munisantanita.talleres.endpoint.temporada.entity.Temporada;
import pe.gob.munisantanita.talleres.endpoint.temporada.repository.TemporadaRepository;

import java.util.List;

@Service
public class TemporadaService {
    @Autowired
    TemporadaRepository temporadaRepository;
    public List<Temporada> temporadaList() {
        return temporadaRepository.findAll();
    }
}
