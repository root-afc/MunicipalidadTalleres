package pe.gob.munisantanita.talleres.endpoint.talleres.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "talleres")
@Entity
public class TallerAll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nidSeccion;
    private Long nidTaller;
    private String snombreTaller;
    private Integer categoria_id;
    private String imagen;
    private String descripcion;
    private Integer edad_id;
    private Integer temporada_id;
    private LocalDateTime fecha;
    private Double precio;
    private Integer calificacion;
    private Integer hora_id;
    private Integer dia_id;
    private LocalDate dfechaSeccionDesde;
    private LocalDate dfechaSeccionHasta;
    private Integer lugar_id;
    private Integer minimo;
    private Integer maximo;
    private Integer inscritos;
    private String snombreEdades;
    private LocalDateTime dfechaTemporadaDesde;
    private LocalDateTime dfechaTemporadaHasta;
    private String snombreHoras;
    private String snombreDias;
    private String snombreLugares;
    private String snombreCategoria;
    private String username;
    private Integer nidUserActualizacion;
    private Integer nidUserCreacion;
    private LocalDateTime dfchActualizacion;
}
