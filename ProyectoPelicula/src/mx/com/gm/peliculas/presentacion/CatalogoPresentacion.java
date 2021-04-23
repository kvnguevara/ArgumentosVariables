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
        String nombrePelicula = null;


        do {
            System.out.println("---------------MENU------------------");
            System.out.println("1. Iniciar el catalogo de Peliculas.");
            System.out.println("2. Agregar Peliculas.");
            System.out.println("3.Listar Peliculas.");
            System.out.println("4. Buscar Peliculas.");
            System.out.println("0. Salir.");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion){
                case 1: catalogoPeliculas.iniciarCatalogoPelicula(); break;
                case 2:
                    System.out.println("Introduzca el nombre de la Pelicula:");
                    nombrePelicula = sc.nextLine();
                    catalogoPeliculas.agregarPelicula(nombrePelicula);
                    break;
                case 3: catalogoPeliculas.listarPeliculas();  break;
                case 4:
                    System.out.println("Introduzca una Pelicula a Buscar: ");
                    nombrePelicula = sc.nextLine();
                    catalogoPeliculas.buscarPeliculas(nombrePelicula);
                    break;
                case 0:
                    System.out.println("Un placer...."); break;
                default:
                    System.out.println("Opcion incorrecta!!");

            }

        }while(opcion != 0);


    }
}
