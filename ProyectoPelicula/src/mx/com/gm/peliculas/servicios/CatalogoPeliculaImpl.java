package mx.com.gm.peliculas.servicios;

import mx.com.gm.peliculas.datos.AccesoDatosImplI;
import mx.com.gm.peliculas.datos.IAcessoDatos;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;

public class CatalogoPeliculaImpl implements ICatalogoPeliculas{

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
            datos.escribir(pelicula,NOMBRE_RECURSO,anexar);
        } catch (AccesoDatosEx accesoDatosEx) {
            accesoDatosEx.printStackTrace();
            System.out.println("Error en el Acceso a Datos");
        }

    }

    @Override
    public void listarPeliculas() {

    }

    @Override
    public void buscarPeliculas(String buscaPelicula) {

    }

    @Override
    public void iniciarCatalogoPelicula() {

    }
}
