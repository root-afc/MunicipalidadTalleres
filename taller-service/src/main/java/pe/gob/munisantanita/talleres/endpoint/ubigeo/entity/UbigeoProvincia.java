package pe.gob.munisantanita.talleres.endpoint.ubigeo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Data
@Table(name = "ubigeo_provincia")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UbigeoProvincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nombre;
    private String departamento_id;

    /*@OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "departamento_id")
    private UbigeoDepartamento departamento;*/

}
