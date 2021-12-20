package pe.gob.munisantanita.talleres.endpoint.inscripciones.entity;


public class InscripcionPorSecciones {

    private Long id;
    private String Categoria;
    private String Taller;
    private String Edad;
    private String Hora;
    private String Dia;
    private String Precio;
    private String Maximo;
    private String Total_Inscritos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getTaller() {
        return Taller;
    }

    public void setTaller(String taller) {
        Taller = taller;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String dia) {
        Dia = dia;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getMaximo() {
        return Maximo;
    }

    public void setMaximo(String maximo) {
        Maximo = maximo;
    }

    public String getTotal_Inscritos() {
        return Total_Inscritos;
    }

    public void setTotal_Inscritos(String total_Inscritos) {
        Total_Inscritos = total_Inscritos;
    }
}


