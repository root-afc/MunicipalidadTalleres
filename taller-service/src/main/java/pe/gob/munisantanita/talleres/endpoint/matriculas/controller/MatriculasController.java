package pe.gob.munisantanita.talleres.endpoint.matriculas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.gob.munisantanita.talleres.endpoint.matriculas.entity.Matricula;
import pe.gob.munisantanita.talleres.endpoint.matriculas.entity.MatriculaDetalle;
import pe.gob.munisantanita.talleres.endpoint.matriculas.service.MatriculasDetallesService;
import pe.gob.munisantanita.talleres.endpoint.matriculas.service.MatriculasService;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;
import pe.gob.munisantanita.talleres.global.models.Response;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/matriculas")
public class MatriculasController {

    @Autowired
    private MatriculasService service;

    @Autowired
    private MatriculasDetallesService serviceDetalles;


    @GetMapping
    public Response<List<Matricula>> findAll() {
        return new Response<List<Matricula>>().setData(service.findAll());
    }

    /*@GetMapping("/{id}")
    public Response<Matricula> findById(@Valid @PathVariable Long id) throws ResourceFieldsException {
        return new Response<Matricula>().setData(service.findById(id));
    }*/

    @PostMapping
    public Response<Matricula> save(@Valid @RequestBody Matricula obj) throws ResourceFieldsException {
        return new Response<Matricula>().setData(service.save(obj)).setMessage("La seccion se registro correctamente");
    }

    @DeleteMapping("/{id}")
    public Response<Matricula> delete(@Valid @PathVariable Long id) {
        service.deleteById(id);
        return new Response<Matricula>().setMessage("La seccion fue eliminado correctamente");
    }

    @PatchMapping
    public Response<Matricula> update(@Valid @RequestBody Matricula obj) throws ResourceFieldsException {
        return new Response<Matricula>().setData(service.update(obj));
    }

    @GetMapping("/{id}/{dni}")
    public Response<Matricula> findByIdAndDni(@Valid @PathVariable Long id, @PathVariable String dni) throws ResourceFieldsException {
        return new Response<Matricula>().setData(service.findByIdAndDni(id, dni));
    }

    @PostMapping("/detalle")
    public Response<MatriculaDetalle> saveMatriculaDetalle(@Valid @RequestBody MatriculaDetalle obj) throws ResourceFieldsException {
        return new Response<MatriculaDetalle>().setData(serviceDetalles.save(obj)).setMessage("La seccion se registro correctamente");
    }

}
