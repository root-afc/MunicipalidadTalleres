package pe.gob.munisantanita.talleres.endpoint.talleres.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Seccion;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.Taller;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.TallerContenido;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.TallerEliminar;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.TallerFixed;
import pe.gob.munisantanita.talleres.endpoint.talleres.service.TalleresService;
import pe.gob.munisantanita.talleres.endpoint.talleres.service.TalleresServiceFixed;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;
import pe.gob.munisantanita.talleres.global.models.Response;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/talleres")
public class TallerController {

    @Autowired
    private TalleresService service;
    @Autowired
    private TalleresServiceFixed talleresServiceFixed;

    @GetMapping
    public Response<List<Taller>> findAll() {
        return new Response<List<Taller>>().setData(service.findAll());
    }


    @GetMapping("/{id}")
    public Response<Taller> findById(@Valid @PathVariable Long id) throws ResourceFieldsException {
        return new Response<Taller>().setData(service.findById(id));
    }

    @PostMapping
    public Response<Taller> save(@Valid @RequestBody Taller obj) throws ResourceFieldsException {
        return new Response<Taller>().setData(service.save(obj)).setMessage("La seccion se registro correctamente");
    }

    @DeleteMapping("/{id}")
    public Response<Taller> delete(@Valid @PathVariable Long id) {
        service.deleteById(id);
        return new Response<Taller>().setMessage("La seccion fue eliminado correctamente");
    }

    @PatchMapping
    public Response<Taller> update(@Valid @RequestBody Taller obj) throws ResourceFieldsException {
        return new Response<Taller>().setData(service.update(obj));
    }


    @GetMapping("/contenido/{id}/{idContenido}")
    public Response<List<TallerContenido>> finByIdTallerTipo(@PathVariable int id, @PathVariable int idContenido ){
        return new Response<List<TallerContenido>>().setData(service.finByIdTallerTipo(id, idContenido));
    }

    // NEW


    @GetMapping("/fewx")
    public ResponseEntity fewx() {
        return new ResponseEntity(talleresServiceFixed.listfixed(), HttpStatus.OK);
    }
    @GetMapping("/findx")
    public ResponseEntity findx() {
        return new ResponseEntity(talleresServiceFixed.all(), HttpStatus.OK);
    }

    @PostMapping("/byidx")
    public ResponseEntity byIdx(@RequestBody TallerEliminar tallerEliminar) {
        return new ResponseEntity(talleresServiceFixed.byId(tallerEliminar.getNidSeccion()), HttpStatus.OK);
    }

    @PostMapping("/updatex")
    public ResponseEntity updateTallerx(@RequestBody TallerFixed tallerFixed) {

        talleresServiceFixed.save(tallerFixed);
        return new ResponseEntity(tallerFixed, HttpStatus.OK);
    }

    @PostMapping("/eliminarx")
    public ResponseEntity eliminarx(@RequestBody TallerEliminar tallerEliminar) {
        talleresServiceFixed.eliminar(tallerEliminar.getNidSeccion());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/savex")
    public ResponseEntity savex(@Valid @RequestBody TallerFixed obj) {
        talleresServiceFixed.save(obj);
        return new ResponseEntity(obj, HttpStatus.OK);
    }

    // NEW

}
