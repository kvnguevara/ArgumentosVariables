package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class AccesoDatosImpl implements AcessoDatos{
    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File f = new File(nombreArchivo);
       return f.exists();
    }

    /*Como puede que este metodo nos de un error, estamos implementando las excepciones que
    * hemos creado.
    * Y como el Buffered tiene que ir en try catch, allí es donde mandamos el mensaje que se mostraria al usuario
    *tanto al leer como
    * */

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        File f = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String linea = br.readLine();
            while (linea!= null){
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = br.readLine();

            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw  new LecturaDatosEx("Excepcion al listar Peliculas: "+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar Peliculas: "+e.getMessage());
        }

        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
            File f = new File(nombreArchivo);
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(f), true);
            pw.println(pelicula.toString());
            pw.close();
            System.out.println("Se ha escrito :"+pelicula.toString());
        } catch (IOException e) {
            e.printStackTrace();
            throw new EscrituraDatosEx("Error en la escritura:"+e.getMessage());
        }

    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        return null;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {

    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {

    }
}
