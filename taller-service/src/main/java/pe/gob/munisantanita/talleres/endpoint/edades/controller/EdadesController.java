package pe.gob.munisantanita.talleres.endpoint.edades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.munisantanita.talleres.endpoint.edades.entity.Edad;
import pe.gob.munisantanita.talleres.endpoint.edades.service.EdadesService;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;
import pe.gob.munisantanita.talleres.global.models.Response;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/edades")
public class EdadesController {

    @Autowired
    private EdadesService service;

    @GetMapping
    public Response<List<Edad>> findAll() {
        return new Response<List<Edad>>().setData(service.findAll());
    }

    @GetMapping("/{id}")
    public Response<Edad> findById(@Valid @PathVariable Long id) throws ResourceFieldsException {
        return new Response<Edad>().setData(service.findById(id));
    }

}
