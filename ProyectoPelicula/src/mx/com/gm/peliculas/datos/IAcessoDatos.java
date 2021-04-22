package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

import java.util.List;

public interface IAcessoDatos {

    public boolean existe(String nombreArchivo) throws AccesoDatosEx;

    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx; //hacemos uso de la clase hija de Excepciones

    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;

    public void crear(String nombreArchivo,boolean anexar) throws AccesoDatosEx;

    public void borrar(String nombreArchivo) throws AccesoDatosEx;

}
