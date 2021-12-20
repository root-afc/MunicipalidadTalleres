package pe.gob.munisantanita.talleres.endpoint.transacciones.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.munisantanita.talleres.endpoint.estudiante.entity.Estudiante;
import pe.gob.munisantanita.talleres.endpoint.matriculas.entity.Matricula;



@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Constancia {


    private Estudiante estudiante;
    private Matricula matricula;
    private String recibo_id;
    private String nro_recibo;



}
