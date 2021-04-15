package manejoarchivo;

import java.io.*;

public class ManejoArchivo {

    public static void crearArchivo(String nombreArchivo){
        File file = new File(nombreArchivo);
        try {

            PrintWriter pw = new PrintWriter(file);
            System.out.println("Archivo Creado");
            pw.close(); //Cerrar el archivo.
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
    public static void escribirArchivo(String nombreArchivo,String contenido){
        File file = new File(nombreArchivo);

        try {
            if (file.exists()){
                PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo,true));
                pw.println(contenido);
                System.out.println("Se ha escrito al en el archivo");
                pw.close();
            }else{
                crearArchivo(nombreArchivo);
                escribirArchivo(nombreArchivo,contenido);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
    public static void leerArchivo(String nombreArchivo) {
        File file = new File(nombreArchivo);
        if (file.exists()) {
            //creacion del lector de archivo, se hace con el BufferReader.
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String linea;
                int i = 0;
                while ((linea = br.readLine()) != null) {
                    System.out.println(i + "." + linea);
                    i++;
                }
                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }else System.out.println("El archivo no existe");
    }
}
