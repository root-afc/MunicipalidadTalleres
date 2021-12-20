package pe.gob.munisantanita.talleres.endpoint.estudiante.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Data
@Table(name = "apoderados")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ApoderadoEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dni;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;
    private String nombres;
    private String ape_paterno;
    private String ape_materno;
    private Date fecha_nacimiento;
    private String direccion;
    private String distrito_de_domicilio;
    private String telefono;
    private String movil;
    private String correo;

    private String departamento;
    private String provincia;
    private String distrito;

}
