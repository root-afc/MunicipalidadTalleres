package pe.gob.munisantanita.talleres.endpoint.transacciones.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//@Data
@Table(name = "transacciones")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long estudiante_id; // ♥
    private double monto_total; // ♥
    private String tipo_tarjeta; // ♥
    private String transaccion_id;  // SEGUNDO PASO
    private String purchase_number; // ♥
    @JsonIgnore
    private String respuesta_json;  // SEGUNDO PASO
    private String respuesta_json_siget;  // SEGUNDO PASO
    private Date fecha; // ♥
    private String estado; // pendiente / Pagado / ERROR
    private String card; // Numero de la tarjeta enmascarada
    private String currency; // Tipo de moneda


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(Long estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(double monto_total) {
        this.monto_total = monto_total;
    }

    public String getTipo_tarjeta() {
        return tipo_tarjeta;
    }

    public void setTipo_tarjeta(String tipo_tarjeta) {
        this.tipo_tarjeta = tipo_tarjeta;
    }

    public String getTransaccion_id() {
        return transaccion_id;
    }

    public void setTransaccion_id(String transaccion_id) {
        this.transaccion_id = transaccion_id;
    }

    public String getPurchaseNumber() {
        return purchase_number;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchase_number = purchaseNumber;
    }

    public String getRespuesta_json() {
        return respuesta_json;
    }

    public void setRespuesta_json(String respuesta_json) {
        this.respuesta_json = respuesta_json;
    }

    public String getRespuesta_json_siget() {
        return respuesta_json_siget;
    }

    public void setRespuesta_json_siget(String respuesta_json_siget) {
        this.respuesta_json_siget = respuesta_json_siget;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
