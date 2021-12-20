package pe.gob.munisantanita.talleres.endpoint.matriculas.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Seccion;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//@Data
@Table(name = "matriculas_detalles")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "seccion_id")
    private Seccion seccion;
    private long matricula_id;

    private double descuento;
    private double importe;


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public long getMatricula_id() {
        return matricula_id;
    }

    public void setMatricula_id(long matricula_id) {
        this.matricula_id = matricula_id;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
