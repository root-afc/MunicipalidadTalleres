package pe.gob.munisantanita.talleres.endpoint.secciones.entity;


import lombok.Data;

import java.util.List;

//@Data
public class Filtro {


    private List<Integer> talleres;
    private List<Integer> categoria;
    private List<Integer> edades;
    private List<Integer> niveles;


    public List<Integer> getTalleres() {
        return talleres;
    }
    public void setTalleres(List<Integer> talleres) {
        this.talleres = talleres;
    }

    public List<Integer> getCategoria() {
        return categoria;
    }
    public void setCategoria(List<Integer> categoria) {
        this.categoria = categoria;
    }

    public List<Integer> getEdades() {
        return edades;
    }
    public void setEdades(List<Integer> edades) {
        this.edades = edades;
    }

    public List<Integer> getNiveles() {
        return niveles;
    }
    public void setNiveles(List<Integer> niveles) {
        this.niveles = niveles;
    }


}
