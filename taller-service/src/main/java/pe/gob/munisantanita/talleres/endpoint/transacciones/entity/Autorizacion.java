package pe.gob.munisantanita.talleres.endpoint.transacciones.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autorizacion {
    private String antifraud;
    private String captureType;
    private String channel;
    private String countable;

    private Orden order;
    private String recurrence;
    private String sponsored;
    private String transactionToken;
}
