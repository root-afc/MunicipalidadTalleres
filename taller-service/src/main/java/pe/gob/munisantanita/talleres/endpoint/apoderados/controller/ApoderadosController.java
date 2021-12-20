package pe.gob.munisantanita.talleres.endpoint.apoderados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.gob.munisantanita.talleres.endpoint.apoderados.entity.Apoderado;
import pe.gob.munisantanita.talleres.endpoint.apoderados.service.ApoderadosService;
import pe.gob.munisantanita.talleres.endpoint.estudiante.entity.Estudiante;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;
import pe.gob.munisantanita.talleres.global.models.Response;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/apoderados")
public class ApoderadosController {

    @Autowired
    private ApoderadosService service;


    @GetMapping
    public Response<List<Apoderado>> findAll() {
        return new Response<List<Apoderado>>().setData(service.findAll());
    }

    @GetMapping("/{id}")
    public Response<Apoderado> findById(@Valid @PathVariable Long id) throws ResourceFieldsException {
        return new Response<Apoderado>().setData(service.findById(id));
    }

    @PostMapping
    public Response<Apoderado> save(@Valid @RequestBody Apoderado obj) throws ResourceFieldsException {
        return new Response<Apoderado>().setData(service.save(obj)).setMessage("La seccion se registro correctamente");
    }

    @DeleteMapping("/{id}")
    public Response<Apoderado> delete(@Valid @PathVariable Long id) {
        service.deleteById(id);
        return new Response<Apoderado>().setMessage("La seccion fue eliminado correctamente");
    }

    @PatchMapping
    public Response<Apoderado> update(@Valid @RequestBody Apoderado obj) throws ResourceFieldsException {
        return new Response<Apoderado>().setData(service.update(obj));
    }

    @GetMapping("/{estudiante_id}/estudiante")
    public Response<Apoderado> findByIdEstudiante(@Valid @PathVariable Long estudiante_id){
        return new Response<Apoderado>().setData(service.findByIdEstudiante(estudiante_id));
    }

    @GetMapping("/{dni}/buscar")
    public Response<Apoderado> findByDni(@Valid @PathVariable String dni) throws ResourceFieldsException {
        return new Response<Apoderado>().setData(service.findByDni(dni));
    }

}
