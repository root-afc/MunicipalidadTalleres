package pe.gob.munisantanita.talleres.endpoint.ubigeo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.gob.munisantanita.talleres.endpoint.ubigeo.entity.UbigeoDepartamento;
import pe.gob.munisantanita.talleres.endpoint.ubigeo.entity.UbigeoDistrito;
import pe.gob.munisantanita.talleres.endpoint.ubigeo.entity.UbigeoProvincia;
import pe.gob.munisantanita.talleres.endpoint.ubigeo.service.UbigeoService;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;
import pe.gob.munisantanita.talleres.global.models.Response;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ubigeo")
public class UbigeoController {

    @Autowired
    private UbigeoService service;


    @GetMapping
    public Response<List<UbigeoDepartamento>> findAll() {
        return new Response<List<UbigeoDepartamento>>().setData(service.findAll());
    }

    @GetMapping("/{id}")
    public Response<UbigeoDepartamento> findById(@Valid @PathVariable Long id) throws ResourceFieldsException {
        return new Response<UbigeoDepartamento>().setData(service.findById(id));
    }

    @GetMapping("/{id}/provincias")
    public Response<List<UbigeoProvincia>> findByIdDepartamento(@Valid @PathVariable String id) throws ResourceFieldsException {
        return new Response<List<UbigeoProvincia>>().setData(service.findByIdDepartamento(id));
    }

    @GetMapping("/{id}/distritos")
    public Response<List<UbigeoDistrito>> findByIdProvincia(@Valid @PathVariable String id) throws ResourceFieldsException {
        return new Response<List<UbigeoDistrito>>().setData(service.findByIdProvincia(id));
    }

/*
    @PostMapping
    public Response<UbigeoDepartamento> save(@Valid @RequestBody UbigeoDepartamento obj) throws ResourceFieldsException {
        return new Response<UbigeoDepartamento>().setData(service.save(obj)).setMessage("La seccion se registro correctamente");
    }

    @DeleteMapping("/{id}")
    public Response<UbigeoDepartamento> delete(@Valid @PathVariable Long id) {
        service.deleteById(id);
        return new Response<UbigeoDepartamento>().setMessage("La seccion fue eliminado correctamente");
    }

    @PatchMapping
    public Response<UbigeoDepartamento> update(@Valid @RequestBody UbigeoDepartamento obj) throws ResourceFieldsException {
        return new Response<UbigeoDepartamento>().setData(service.update(obj));
    }*/

}
