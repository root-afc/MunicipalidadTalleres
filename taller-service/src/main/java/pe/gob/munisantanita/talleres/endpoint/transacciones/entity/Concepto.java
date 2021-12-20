package pe.gob.munisantanita.talleres.endpoint.transacciones.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//@Data
@AllArgsConstructor
@NoArgsConstructor
public class Concepto {
    private int tupa_id;
    private double monto_pago;
    private int cantidad;


    public int getTupa_id() {
        return tupa_id;
    }

    public void setTupa_id(int tupa_id) {
        this.tupa_id = tupa_id;
    }

    public double getMonto_pago() {
        return monto_pago;
    }

    public void setMonto_pago(double monto_pago) {
        this.monto_pago = monto_pago;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
