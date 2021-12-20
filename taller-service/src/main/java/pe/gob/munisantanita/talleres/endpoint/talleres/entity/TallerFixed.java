package pe.gob.munisantanita.talleres.endpoint.talleres.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.munisantanita.talleres.endpoint.categorias.entity.CategoriaFiltro;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "talleres")
@Entity
public class TallerFixed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer categoria_id;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "categoria_id", insertable = false, updatable = false)
    private CategoriaFiltro categoria;
}
