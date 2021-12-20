package pe.gob.munisantanita.talleres.endpoint.categorias.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.gob.munisantanita.talleres.endpoint.categorias.entity.Categoria;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CategoriasRepository extends JpaRepository<Categoria, Long> {

    @Query("SELECT C FROM Categoria AS C WHERE C.estado = 1 ")
    List<Categoria> findAll();

    /*default List<Categoria> findAll() {
        Page<Categoria> all = findAll(new PageRequest(0, 10));
        return (List<Categoria>) all;
    }*/
}
