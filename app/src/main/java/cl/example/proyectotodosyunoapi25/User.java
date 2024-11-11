package cl.example.proyectotodosyunoapi25;

public class User {
    private String nombre;


    public User() {
        // Constructor vacío necesario para Firestore
    }

    public User(String nombre) {
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

