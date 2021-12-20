package pe.gob.munisantanita.talleres.endpoint.niveles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.gob.munisantanita.talleres.endpoint.categorias.entity.Categoria;
import pe.gob.munisantanita.talleres.endpoint.niveles.entity.Nivel;
import pe.gob.munisantanita.talleres.endpoint.niveles.service.NivelesService;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;
import pe.gob.munisantanita.talleres.global.models.Response;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/niveles")
public class NivelesController {

    @Autowired
    private NivelesService service;

    @GetMapping
    public Response<List<Nivel>> findAll() {
        return new Response<List<Nivel>>().setData(service.findAll());
    }

    @GetMapping("/{id}")
    public Response<Nivel> findById(@Valid @PathVariable Long id) throws ResourceFieldsException {
        return new Response<Nivel>().setData(service.findById(id));
    }

    /*@PostMapping
    public Response<Nivel> save(@Valid @RequestBody Nivel obj) throws ResourceFieldsException {
        return new Response<Nivel>().setData(service.save(obj)).setMessage("La categoria se registro correctamente");
    }*/

    /*@DeleteMapping("/{id}")
    public Response<Nivel> delete(@Valid @PathVariable Long id) {
        service.deleteById(id);
        return new Response<Nivel>().setMessage("La categoria fue eliminado correctamente");
    }*/

    /*@PatchMapping
    public Response<Nivel> update(@Valid @RequestBody Nivel obj) throws ResourceFieldsException {
        return new Response<Nivel>().setData(service.update(obj));
    }*/


}
