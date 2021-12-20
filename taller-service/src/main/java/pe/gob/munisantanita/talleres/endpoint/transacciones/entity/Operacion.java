package pe.gob.munisantanita.talleres.endpoint.transacciones.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import pe.gob.munisantanita.talleres.endpoint.apoderados.entity.Apoderado;
import pe.gob.munisantanita.talleres.endpoint.estudiante.entity.Estudiante;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Seccion;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operacion {

    private Autorizacion autorizacion;

    private Estudiante estudiante;
    private Apoderado apoderado;
    private List<Seccion> secciones;
    private RespuestaSiget recibo;


    public RespuestaSiget getRecibo() {
        return recibo;
    }

    public void setRecibo(RespuestaSiget recibo) {
        this.recibo = recibo;
    }

    public Autorizacion getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(Autorizacion autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Apoderado getApoderado() {
        return apoderado;
    }

    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }
}
