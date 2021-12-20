package pe.gob.munisantanita.talleres.endpoint.transacciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.gob.munisantanita.talleres.endpoint.matriculas.entity.Matricula;
import pe.gob.munisantanita.talleres.endpoint.matriculas.repository.MatriculasRepository;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Seccion;
import pe.gob.munisantanita.talleres.endpoint.secciones.repository.SeccionesRepository;
import pe.gob.munisantanita.talleres.endpoint.transacciones.entity.Operacion;

import pe.gob.munisantanita.talleres.endpoint.transacciones.entity.Transaccion;
import pe.gob.munisantanita.talleres.endpoint.transacciones.service.TransaccionesService;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;
import pe.gob.munisantanita.talleres.global.models.Response;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transacciones")
public class TransaccionesController {


    @Autowired
    TransaccionesService transaccionesService;

    @Autowired
    private MatriculasRepository matriculasRepository;



    @Autowired
    private SeccionesRepository seccionesRepository;

    @GetMapping
    public Response<List<Transaccion>> findAll() {
        return new Response<List<Transaccion>>().setData(transaccionesService.findAll());
    }

    @PostMapping
    public Response<Transaccion> save(@Valid @RequestBody Transaccion obj) throws ResourceFieldsException {
        return new Response<Transaccion>().setData(transaccionesService.save(obj)).setMessage("La transaccion se registro correctamente");
    }

    @PatchMapping
    public Response<Transaccion> update(@Valid @RequestBody Transaccion obj) throws ResourceFieldsException {
        return new Response<Transaccion>().setData(transaccionesService.update(obj));
    }

    @PostMapping("/authorization")
    public Response<Object> constancia(@Valid @RequestBody Operacion operacion) {
        return new Response<Object>().setData(transaccionesService.constancia(operacion)).setMessage("Detalles de la operación");
    }


    @GetMapping("/prueba")
    public Response<Matricula> mail() throws ResourceFieldsException  {

        Seccion s = seccionesRepository.findById((long) 1).orElse(null);
        if(s != null){
            s.setInscritos(s.getInscritos() + 1);
            seccionesRepository.save(s);
        }

        //seccionesRepository.setSeccionById((long) 1);

        //(int) ((Math.random() * (100 - 1)) + 1);
        return new Response<Matricula>().setData(null).setMessage("Detalles de la operación: "+ (int)
                ((Math.random() * (100 - 1)) + 1));
    }

}
