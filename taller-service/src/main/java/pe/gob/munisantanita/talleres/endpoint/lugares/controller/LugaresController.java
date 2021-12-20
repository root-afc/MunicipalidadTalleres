package pe.gob.munisantanita.talleres.endpoint.lugares.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.gob.munisantanita.talleres.endpoint.lugares.entity.Lugar;
import pe.gob.munisantanita.talleres.endpoint.lugares.service.LugaresService;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;
import pe.gob.munisantanita.talleres.global.models.Response;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lugares")
public class LugaresController {

    @Autowired
    private LugaresService service;


    @GetMapping
    public Response<List<Lugar>> findAll() {
        return new Response<List<Lugar>>().setData(service.findAll());
    }

    @GetMapping("/{id}")
    public Response<Lugar> findById(@Valid @PathVariable Long id) throws ResourceFieldsException {
        return new Response<Lugar>().setData(service.findById(id));
    }

    @PostMapping
    public Response<Lugar> save(@Valid @RequestBody Lugar obj) throws ResourceFieldsException {
        return new Response<Lugar>().setData(service.save(obj)).setMessage("La seccion se registro correctamente");
    }

    @DeleteMapping("/{id}")
    public Response<Lugar> delete(@Valid @PathVariable Long id) {
        service.deleteById(id);
        return new Response<Lugar>().setMessage("La seccion fue eliminado correctamente");
    }
    @PatchMapping
    public Response<Lugar> update(@Valid @RequestBody Lugar obj) throws ResourceFieldsException {
        return new Response<Lugar>().setData(service.update(obj));
    }

}
