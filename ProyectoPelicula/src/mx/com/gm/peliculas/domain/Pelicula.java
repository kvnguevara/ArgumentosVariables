package mx.com.gm.peliculas.domain;

import java.io.Serializable;

public class Pelicula implements Serializable {
    private String nombre;
    //Contructor

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }

    public Pelicula() {
    }
    //Metodos get y set


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(nombre);
        return sb.toString();
    }
}
