package pe.gob.munisantanita.talleres.endpoint.categorias.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.Taller;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Data
@Table(name = "categorias")
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany
    @JoinColumn(name="categoria_id", insertable = false, updatable = false)
    private List<Taller> talleres;

    private int estado;
}
