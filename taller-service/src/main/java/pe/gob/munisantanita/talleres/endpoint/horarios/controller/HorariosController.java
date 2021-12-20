package pe.gob.munisantanita.talleres.endpoint.horarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.munisantanita.talleres.endpoint.horarios.entity.Horario;
import pe.gob.munisantanita.talleres.endpoint.horarios.service.HorariosService;
import pe.gob.munisantanita.talleres.endpoint.niveles.entity.Nivel;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;
import pe.gob.munisantanita.talleres.global.models.Response;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorariosController {

    @Autowired
    private HorariosService service;

    @GetMapping
    public Response<List<Horario>> findAll() {
        return new Response<List<Horario>>().setData(service.findAll());
    }

    @GetMapping("/{id}")
    public Response<Horario> findById(@Valid @PathVariable Long id) throws ResourceFieldsException {
        return new Response<Horario>().setData(service.findById(id));
    }
}
