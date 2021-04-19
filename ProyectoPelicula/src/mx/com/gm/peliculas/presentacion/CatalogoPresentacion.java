package mx.com.gm.peliculas.presentacion;
/*En está clase es donde vamos a presentar la aplicacion al usuario
* Aquí es donde ira el menú*/

import mx.com.gm.peliculas.servicios.*;
//solo vamos a trabajar con la capa de negocios, y no con la capa de datos.
// ya que asi no se relacionan y así hay más acoplamiento

import java.util.Scanner;

public class CatalogoPresentacion {
    public static void main(String[] args) {
        int opcion = -1;
        Scanner sc = new Scanner(System.in);
        ICatalogoPeliculas catalogoPeliculas = new CatalogoPeliculaImpl();

        do {
            System.out.println("---------------MENU------------------");
            System.out.println("1. Iniciar el catalogo de Peliculas.");
            System.out.println("2. Iniciar el catalogo de Peliculas.");
            System.out.println("3. Iniciar el catalogo de Peliculas.");
            System.out.println("4. Iniciar el catalogo de Peliculas.");
            System.out.println("0. Salir.");



        }while(opcion == 0);
    }
}
