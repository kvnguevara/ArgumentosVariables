package mx.com.gm.peliculas.excepciones;

import mx.com.gm.peliculas.domain.Pelicula;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscrituraDatosEx  extends AccesoDatosEx{

    //constructor sobrecargado
    public EscrituraDatosEx(String mensaje){
        super(mensaje);

    }

    public void crearArchivo(){

    }

    //MEtodos para que escriba la pelicula en el Txt
    public void escribirArchivo(String nombreArchivo, Pelicula pelicula)  {
        File file = new File(nombreArchivo);
        if (file.exists()){
            try {
                PrintWriter pw = new PrintWriter(new FileWriter(file),true);
                pw.println(nombreArchivo);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            crearArchivo();
            escribirArchivo(nombreArchivo,pelicula);
        }
    }

}
