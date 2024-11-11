package cl.example.proyectotodosyunoapi25;

import com.google.firebase.Timestamp;

public class ModelAviso {
    private String descripcion;
    private Timestamp fechaPublicacion; // Cambiado a Timestamp
    private String usuarioId;

    public ModelAviso() {
        // Constructor vacío requerido para Firestore
    }

    public ModelAviso(String descripcion, Timestamp fechaPublicacion, String usuarioId) {
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
        this.usuarioId = usuarioId;
    }

    // Getters y Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Timestamp fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
}
