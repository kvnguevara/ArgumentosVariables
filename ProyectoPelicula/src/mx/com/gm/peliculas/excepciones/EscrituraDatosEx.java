package mx.com.gm.peliculas.excepciones;

import mx.com.gm.peliculas.domain.Pelicula;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscrituraDatosEx(){

    //MEtodos para que escriba en el archivo
    public void escribirArchivo(String nombreArchivo, Pelicula pelicula)  {
        File file = new File(nombreArchivo);
        if (file.exists()){
            try {
                PrintWriter pw = new PrintWriter(new FileWriter(file));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{

        }
    }

}
