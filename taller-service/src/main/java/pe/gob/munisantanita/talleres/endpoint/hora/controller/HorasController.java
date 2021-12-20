package pe.gob.munisantanita.talleres.endpoint.hora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.munisantanita.talleres.endpoint.hora.entity.Hora;
import pe.gob.munisantanita.talleres.endpoint.hora.service.HorasService;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;
import pe.gob.munisantanita.talleres.global.models.Response;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/horas")
public class HorasController {

    @Autowired
    private HorasService service;

    @GetMapping
    public Response<List<Hora>> findAll() {
        return new Response<List<Hora>>().setData(service.findAll());
    }

    @GetMapping("/{id}")
    public Response<Hora> findById(@Valid @PathVariable Long id) throws ResourceFieldsException {
        return new Response<Hora>().setData(service.findById(id));
    }

/*
    @PostMapping
    public Response<Categoria> save(@Valid @RequestBody Categoria obj) throws ResourceFieldsException {
        return new Response<Categoria>().setData(service.save(obj)).setMessage("La categoria se registro correctamente");
    }

    @DeleteMapping("/{id}")
    public Response<Categoria> delete(@Valid @PathVariable Long id) {
        service.deleteById(id);
        return new Response<Categoria>().setMessage("La categoria fue eliminado correctamente");
    }

    @PatchMapping
    public Response<Categoria> update(@Valid @RequestBody Categoria obj) throws ResourceFieldsException {
        return new Response<Categoria>().setData(service.update(obj));
    }
*/

}
