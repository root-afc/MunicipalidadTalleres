package pe.gob.munisantanita.talleres.endpoint.ubigeo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.munisantanita.talleres.endpoint.categorias.entity.CategoriaFiltro;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Data
@Table(name = "ubigeo_distrito")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UbigeoDistrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nombre;
    private String provincia_id;
    private String departamento_id;


    /*@OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "provincia_id")
    private UbigeoProvincia provincia;*/

    /*@OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "departamento_id")
    private UbigeoDepartamento departamento;*/



}
