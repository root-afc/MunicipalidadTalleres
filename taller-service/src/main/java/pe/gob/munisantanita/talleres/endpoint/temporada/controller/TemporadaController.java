package pe.gob.munisantanita.talleres.endpoint.temporada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.munisantanita.talleres.endpoint.temporada.service.TemporadaService;

@RestController
@RequestMapping("/temporadas")
public class TemporadaController {
    @Autowired
    TemporadaService temporadaService;
    @GetMapping
    public ResponseEntity All(){
        return new ResponseEntity(temporadaService.temporadaList(), HttpStatus.OK);
    };
}
