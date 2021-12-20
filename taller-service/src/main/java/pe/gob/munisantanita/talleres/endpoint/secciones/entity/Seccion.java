package pe.gob.munisantanita.talleres.endpoint.secciones.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pe.gob.munisantanita.talleres.endpoint.dias.entity.Dia;
import pe.gob.munisantanita.talleres.endpoint.edades.entity.Edad;
import pe.gob.munisantanita.talleres.endpoint.hora.entity.Hora;
import pe.gob.munisantanita.talleres.endpoint.lugares.entity.Lugar;
import pe.gob.munisantanita.talleres.endpoint.niveles.entity.Nivel;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.Taller;
import pe.gob.munisantanita.talleres.endpoint.temporada.entity.Temporada;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//@Data
@Table(name = "secciones")
@Entity
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String descripcion;


    @OneToOne( cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "taller_id")
    private Taller taller = null;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "edad_id")
    private Edad edad;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "temporada_id")
    private Temporada temporada;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "hora_id")
    private Hora hora;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "dia_id")
    private Dia dia;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "lugar_id")
    private Lugar lugar;

    private LocalDateTime fecha_desde;
    private LocalDateTime fecha_hasta;

    private double precio;
    private double calificacion;

    private int minimo;
    private int maximo;
    private int inscritos;

    private String imagen;
    private String portada;

    private LocalDateTime fecha;

    private int estado;
    //private int virtual;


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }

    public Edad getEdad() {
        return edad;
    }

    public void setEdad(Edad edad) {
        this.edad = edad;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public LocalDateTime getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(LocalDateTime fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public LocalDateTime getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(LocalDateTime fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getInscritos() {
        return inscritos;
    }

    public void setInscritos(int inscritos) {
        this.inscritos = inscritos;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
