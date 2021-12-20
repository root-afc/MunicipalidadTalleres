package pe.gob.munisantanita.talleres.endpoint.edades.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.Taller;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//@Data
@Table(name = "edades")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Edad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int estado;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
