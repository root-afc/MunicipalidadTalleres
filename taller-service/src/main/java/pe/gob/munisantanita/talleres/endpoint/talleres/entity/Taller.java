package pe.gob.munisantanita.talleres.endpoint.talleres.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.munisantanita.talleres.endpoint.categorias.entity.Categoria;
import pe.gob.munisantanita.talleres.endpoint.categorias.entity.CategoriaFiltro;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Seccion;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//@Data
@Table(name = "talleres")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Taller {

    // http://localhost:8081/api/taller-service/categorias
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String imagen;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "categoria_id")
    private CategoriaFiltro categoria;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public CategoriaFiltro getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaFiltro categoria) {
        this.categoria = categoria;
    }
}
