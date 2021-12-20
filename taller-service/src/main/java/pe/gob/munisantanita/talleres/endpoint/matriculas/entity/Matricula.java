package pe.gob.munisantanita.talleres.endpoint.matriculas.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import pe.gob.munisantanita.talleres.endpoint.dias.entity.Dia;
import pe.gob.munisantanita.talleres.endpoint.edades.entity.Edad;
import pe.gob.munisantanita.talleres.endpoint.estudiante.entity.Estudiante;
import pe.gob.munisantanita.talleres.endpoint.hora.entity.Hora;
import pe.gob.munisantanita.talleres.endpoint.lugares.entity.Lugar;
import pe.gob.munisantanita.talleres.endpoint.niveles.entity.Nivel;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.Taller;
import pe.gob.munisantanita.talleres.endpoint.temporada.entity.Temporada;
import pe.gob.munisantanita.talleres.endpoint.transacciones.entity.Transaccion;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//@Data
@Table(name = "matriculas")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String recibo_id;
    private String nro_recibo;
    //private long transaccion_id;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "transaccion_id")
    private Transaccion transaccion;

    private double importe;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;
    private Date fecha;
    private int estado;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "matricula_id")
    private List<MatriculaDetalle> detalles;


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getRecibo_id() {
        return recibo_id;
    }

    public void setRecibo_id(String recibo_id) {
        this.recibo_id = recibo_id;
    }

    public String getNro_recibo() {
        return nro_recibo;
    }

    public void setNro_recibo(String nro_recibo) {
        this.nro_recibo = nro_recibo;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<MatriculaDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<MatriculaDetalle> detalles) {
        this.detalles = detalles;
    }
}
