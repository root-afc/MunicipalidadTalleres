package pe.gob.munisantanita.talleres.endpoint.talleres.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Data
@Table(name = "talleres_contenido")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TallerContenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@JsonIgnore
    private int taller_id;
    private int indice;
    private String descripcion;
    private int tipo;

}
