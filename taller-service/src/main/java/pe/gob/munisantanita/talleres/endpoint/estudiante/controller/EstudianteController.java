package pe.gob.munisantanita.talleres.endpoint.estudiante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.gob.munisantanita.talleres.endpoint.estudiante.entity.Estudiante;
import pe.gob.munisantanita.talleres.endpoint.estudiante.service.EstudiantesService;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;
import pe.gob.munisantanita.talleres.global.models.Response;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudiantesService service;


    @GetMapping
    public Response<List<Estudiante>> findAll() {
        return new Response<List<Estudiante>>().setData(service.findAll());
    }

    @GetMapping("/{id}")
    public Response<Estudiante> findById(@Valid @PathVariable Long id) throws ResourceFieldsException {
        return new Response<Estudiante>().setData(service.findById(id));
    }

    @PostMapping
    public Response<Estudiante> save(@Valid @RequestBody Estudiante obj) throws ResourceFieldsException {
        return new Response<Estudiante>().setData(service.save(obj)).setMessage("La seccion se registro correctamente");
        /*Estudiante estudiante =  service.findByDni(obj.getDni());
        System.out.println("Estu =>" + estudiante);
        if(estudiante == null) return new Response<Estudiante>().setData(service.save(obj)).setMessage("La seccion se registro correctamente");
        else return new Response<Estudiante>().setData(estudiante);*/
    }

    @DeleteMapping("/{id}")
    public Response<Estudiante> delete(@Valid @PathVariable Long id) {
        service.deleteById(id);
        return new Response<Estudiante>().setMessage("La seccion fue eliminado correctamente");
    }

    @PatchMapping
    public Response<Estudiante> update(@Valid @RequestBody Estudiante obj) throws ResourceFieldsException {
        return new Response<Estudiante>().setData(service.update(obj));
    }

    @GetMapping("/{dni}/buscar")
    public Response<Estudiante> findByDni(@Valid @PathVariable String dni) throws ResourceFieldsException {
        return new Response<Estudiante>().setData(service.findByDni(dni));
    }
}
