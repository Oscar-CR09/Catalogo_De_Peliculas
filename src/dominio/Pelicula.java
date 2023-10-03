package dominio;

import java.util.Objects;

public class Pelicula {
    private String nombre;
    public Pelicula(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pelicula(String nombre){
        this.nombre = nombre;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pelicula pelicula = (Pelicula) o;

        return Objects.equals(nombre, pelicula.nombre);
    }

    @Override
    public int hashCode() {
        return nombre != null ? nombre.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    public static void main(String[] args) {
        var pelicula1 = new Pelicula("Batman");
        var pelicula2 = new Pelicula("sperman");

        System.out.println(pelicula1);
        System.out.println(pelicula2);
    }
}
