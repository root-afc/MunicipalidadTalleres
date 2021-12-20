package pe.gob.munisantanita.talleres.endpoint.secciones.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "secciones")
@Entity
public class SeccionFixed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String descripcion;
    private Integer taller_id;
    private Integer edad_id;
    private Integer temporada_id;
    private LocalDateTime fecha;
    private Integer estado;
    private String precio;
    private String calificacion;
    private Integer hora_id;
    private Integer dia_id;
    private LocalDate fecha_desde;
    private LocalDate fecha_hasta;
    private Integer lugar_id;
    private Integer minimo;
    private Integer maximo;
    // private String username;
    private Integer nidUserActualizacion;
    private Integer nidUserCreacion;
    private LocalDateTime dfchActualizacion;
}
