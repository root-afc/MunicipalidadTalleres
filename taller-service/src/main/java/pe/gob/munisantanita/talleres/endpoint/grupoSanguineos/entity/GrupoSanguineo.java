package pe.gob.munisantanita.talleres.endpoint.grupoSanguineos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import pe.gob.munisantanita.talleres.endpoint.estudiante.entity.Estudiante;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//@Data
@Table(name = "grupo_sanguineo")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GrupoSanguineo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

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
}
