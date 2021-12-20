package pe.gob.munisantanita.talleres.endpoint.temporada.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.Taller;

import javax.persistence.*;
import java.time.LocalDateTime;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Data
@Table(name = "temporadas")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private LocalDateTime fecha_desde;
    private LocalDateTime fecha_hasta;
    private int estado;

}
