package pe.gob.munisantanita.talleres.endpoint.transacciones.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransaccionSiget {

    private String nro_doc_identidad;

    private String nombres;
    private String ape_paterno;
    private String ape_materno;
    private Double monto_a_cobrar;
    private Double monto_cobrado;
    private Double monto_descuento;
    private List<Concepto> concepto;


    public String getNro_doc_identidad() {
        return nro_doc_identidad;
    }

    public void setNro_doc_identidad(String nro_doc_identidad) {
        this.nro_doc_identidad = nro_doc_identidad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApe_paterno() {
        return ape_paterno;
    }

    public void setApe_paterno(String ape_paterno) {
        this.ape_paterno = ape_paterno;
    }

    public String getApe_materno() {
        return ape_materno;
    }

    public void setApe_materno(String ape_materno) {
        this.ape_materno = ape_materno;
    }

    public Double getMonto_a_cobrar() {
        return monto_a_cobrar;
    }

    public void setMonto_a_cobrar(Double monto_a_cobrar) {
        this.monto_a_cobrar = monto_a_cobrar;
    }

    public Double getMonto_cobrado() {
        return monto_cobrado;
    }

    public void setMonto_cobrado(Double monto_cobrado) {
        this.monto_cobrado = monto_cobrado;
    }

    public Double getMonto_descuento() {
        return monto_descuento;
    }

    public void setMonto_descuento(Double monto_descuento) {
        this.monto_descuento = monto_descuento;
    }

    public List<Concepto> getConcepto() {
        return concepto;
    }

    public void setConcepto(List<Concepto> concepto) {
        this.concepto = concepto;
    }
}
