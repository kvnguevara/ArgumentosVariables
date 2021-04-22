package mx.com.gm.peliculas.servicios;

import mx.com.gm.peliculas.datos.AccesoDatosImplI;
import mx.com.gm.peliculas.datos.IAcessoDatos;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

import javax.swing.*;
import java.util.List;

public class CatalogoPeliculaImpl implements ICatalogoPeliculas {

    private final IAcessoDatos datos;

    public CatalogoPeliculaImpl() {
        //inicializa datos, con la clase que implementa los datos
        this.datos = new AccesoDatosImplI();
    }
    /*Metodo que agrega una pelicula
     * Lo primero que haremos es convertir el string en un objeto pelicula*/

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx accesoDatosEx) {
            accesoDatosEx.printStackTrace();
            System.out.println("Error en el Acceso a Datos");
        }

    }

    @Override
    public void listarPeliculas() {
        try {
            List<Pelicula> peliculas = this.datos.listar(NOMBRE_RECURSO);
            peliculas.forEach(pelicula -> {
                System.out.println(pelicula.getNombre());
            });
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void buscarPeliculas(String buscaPelicula) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscaPelicula);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de Acceso a Datos: " + ex.getMessage());
            ex.printStackTrace();
        }
        if (resultado.equals(null)) {
            System.out.println("No se encontro la Pelicula!!");
        } else
            System.out.println("Resultado: " + resultado);

    }
    /*Metodo que en caso de que exista, borramos y luego lo creamos
     * y en caso de que no exista, lo creamos*/

    @Override
    public void iniciarCatalogoPelicula() {

        try {
            boolean anexar = this.datos.existe(NOMBRE_RECURSO);
            if (this.datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO, anexar);
                System.out.println("Se ha creado el Catalogo de Peliculas!!");

            } else
                this.datos.crear(NOMBRE_RECURSO, anexar);
            System.out.println("Se ha crado el Catalogo de Peliculas!!");
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }

    }
}
