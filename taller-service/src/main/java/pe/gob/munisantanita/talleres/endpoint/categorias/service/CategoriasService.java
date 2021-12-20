package pe.gob.munisantanita.talleres.endpoint.categorias.service;
import org.springframework.data.domain.Page;
import pe.gob.munisantanita.talleres.endpoint.categorias.entity.Categoria;
import pe.gob.munisantanita.talleres.global.services.IAbstractService;

import java.awt.print.Pageable;
import java.util.List;

public interface CategoriasService extends IAbstractService<Categoria, Long> {

    //Page<Categoria> findAllPagination();
}
