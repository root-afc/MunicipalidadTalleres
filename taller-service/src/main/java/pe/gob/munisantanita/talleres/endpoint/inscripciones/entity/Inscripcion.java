package pe.gob.munisantanita.talleres.endpoint.inscripciones.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pe.gob.munisantanita.talleres.endpoint.estudiante.entity.Estudiante;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Seccion;

import javax.persistence.*;

//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//@Data
//@Table(name = "seguros")
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
public class Inscripcion {

    private Long id;
    private String taller;
    private String categoria;
    private String edad;
    private String hora;
    private String dia;
    private String e_id;
    private String e_nombre;
    private String e_ape_paterno;
    private String e_ape_materno;
    private String e_dni;
    private String e_movil;
    private String e_correo;
    private String e_fecha_nacimiento;
    private String fecha;
    private String m_id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public String getE_nombre() {
        return e_nombre;
    }

    public void setE_nombre(String e_nombre) {
        this.e_nombre = e_nombre;
    }

    public String getE_ape_paterno() {
        return e_ape_paterno;
    }

    public void setE_ape_paterno(String e_ape_paterno) {
        this.e_ape_paterno = e_ape_paterno;
    }

    public String getE_ape_materno() {
        return e_ape_materno;
    }

    public void setE_ape_materno(String e_ape_materno) {
        this.e_ape_materno = e_ape_materno;
    }

    public String getE_dni() {
        return e_dni;
    }

    public void setE_dni(String e_dni) {
        this.e_dni = e_dni;
    }

    public String getE_movil() {
        return e_movil;
    }

    public void setE_movil(String e_movil) {
        this.e_movil = e_movil;
    }

    public String getE_correo() {
        return e_correo;
    }

    public void setE_correo(String e_correo) {
        this.e_correo = e_correo;
    }

    public String getE_fecha_nacimiento() {
        return e_fecha_nacimiento;
    }

    public void setE_fecha_nacimiento(String e_fecha_nacimiento) {
        this.e_fecha_nacimiento = e_fecha_nacimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }
}


