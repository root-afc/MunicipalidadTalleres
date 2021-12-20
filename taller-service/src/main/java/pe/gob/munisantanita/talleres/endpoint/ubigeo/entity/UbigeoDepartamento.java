package pe.gob.munisantanita.talleres.endpoint.ubigeo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Data
@Table(name = "ubigeo_departamento")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UbigeoDepartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nombre;
}
