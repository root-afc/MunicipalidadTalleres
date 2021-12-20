package pe.gob.munisantanita.talleres.endpoint.grupoSanguineos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.gob.munisantanita.talleres.endpoint.apoderados.entity.Apoderado;
import pe.gob.munisantanita.talleres.endpoint.grupoSanguineos.entity.GrupoSanguineo;
import pe.gob.munisantanita.talleres.endpoint.grupoSanguineos.service.GrupoSanguineosService;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;
import pe.gob.munisantanita.talleres.global.models.Response;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sanguineos")
public class GrupoSanguineosController {

    @Autowired
    private GrupoSanguineosService service;


    @GetMapping
    public Response<List<GrupoSanguineo>> findAll() {
        return new Response<List<GrupoSanguineo>>().setData(service.findAll());
    }

    @GetMapping("/{id}")
    public Response<GrupoSanguineo> findById(@Valid @PathVariable Long id) throws ResourceFieldsException {
        return new Response<GrupoSanguineo>().setData(service.findById(id));
    }

    @PostMapping
    public Response<GrupoSanguineo> save(@Valid @RequestBody GrupoSanguineo obj) throws ResourceFieldsException {
        return new Response<GrupoSanguineo>().setData(service.save(obj)).setMessage("La seccion se registro correctamente");
    }

    @DeleteMapping("/{id}")
    public Response<GrupoSanguineo> delete(@Valid @PathVariable Long id) {
        service.deleteById(id);
        return new Response<GrupoSanguineo>().setMessage("La seccion fue eliminado correctamente");
    }

    @PatchMapping
    public Response<GrupoSanguineo> update(@Valid @RequestBody GrupoSanguineo obj) throws ResourceFieldsException {
        return new Response<GrupoSanguineo>().setData(service.update(obj));
    }

}
