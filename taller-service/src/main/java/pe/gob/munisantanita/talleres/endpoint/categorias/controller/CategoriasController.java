package pe.gob.munisantanita.talleres.endpoint.categorias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import pe.gob.munisantanita.talleres.endpoint.categorias.entity.Categoria;
import pe.gob.munisantanita.talleres.endpoint.categorias.service.CategoriasService;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;
import pe.gob.munisantanita.talleres.global.models.Response;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private CategoriasService service;

    @GetMapping
    public Response<List<Categoria>> findAll() {
        return new Response<List<Categoria>>().setData(service.findAll());
    }

    @GetMapping("/{id}")
    public Response<Categoria> findById(@Valid @PathVariable Long id) throws ResourceFieldsException {
        return new Response<Categoria>().setData(service.findById(id));
    }

}
