package cl.example.proyectotodosyunoapi25;

public class Avisos {
    private String fecha;
    private String descripcion;
    private int nivel;

    public Avisos(String fecha, String descripcion, int nivel) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.nivel = nivel;
    }

    // Métodos getters y setters
    public String getFecha() { return fecha; }
    public String getDescripcion() { return descripcion; }
    public int getNivel() { return nivel; }
}

