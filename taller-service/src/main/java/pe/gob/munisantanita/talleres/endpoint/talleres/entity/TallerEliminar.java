package pe.gob.munisantanita.talleres.endpoint.talleres.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "secciones")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TallerEliminar {
    @Id
    private Integer nidSeccion;
}
