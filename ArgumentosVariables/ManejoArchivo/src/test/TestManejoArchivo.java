package test;

import static manejoarchivo.ManejoArchivo.*;

public class TestManejoArchivo {
    public static void main(String[] args) {
        String nombreArchivo ="C:\\Users\\kevin\\Desktop\\Proyect\\Cursos\\Java\\Programacion\\ArgumentosVariables\\ManejoArchivoprueba.txt";
        //crearArchivo(nombreArchivo);
        //Ahora vamos agregar informacion a nuestro archivo!!

        escribirArchivo(nombreArchivo,"Esta es una linea del Texto");
        leerArchivo(nombreArchivo);


    }
}
