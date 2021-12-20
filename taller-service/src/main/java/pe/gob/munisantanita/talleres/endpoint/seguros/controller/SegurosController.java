package pe.gob.munisantanita.talleres.endpoint.seguros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.gob.munisantanita.talleres.endpoint.estudiante.entity.Estudiante;
import pe.gob.munisantanita.talleres.endpoint.seguros.entity.Seguro;
import pe.gob.munisantanita.talleres.endpoint.seguros.service.SegurosService;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;
import pe.gob.munisantanita.talleres.global.models.Response;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/seguros")
public class SegurosController {

    @Autowired
    private SegurosService service;


    @GetMapping
    public Response<List<Seguro>> findAll() {
        return new Response<List<Seguro>>().setData(service.findAll());
    }

    @GetMapping("/{id}")
    public Response<Seguro> findById(@Valid @PathVariable Long id) throws ResourceFieldsException {
        return new Response<Seguro>().setData(service.findById(id));
    }

    @PostMapping
    public Response<Seguro> save(@Valid @RequestBody Seguro obj) throws ResourceFieldsException {
        return new Response<Seguro>().setData(service.save(obj)).setMessage("La seccion se registro correctamente");
    }

    @DeleteMapping("/{id}")
    public Response<Seguro> delete(@Valid @PathVariable Long id) {
        service.deleteById(id);
        return new Response<Seguro>().setMessage("La seccion fue eliminado correctamente");
    }

    @PatchMapping
    public Response<Seguro> update(@Valid @RequestBody Seguro obj) throws ResourceFieldsException {
        return new Response<Seguro>().setData(service.update(obj));
    }

}
