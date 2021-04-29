package com.kevinguevara.presentacion;

import com.kevinguevara.servicios.*;
import com.kevinguevara.usarios.Usuario;

import java.util.Scanner;

public class PresentacionUsuario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion ;
        String userName ;
        String passd;
        int idUsuario;
        IAGestionUsuario gestionUsuario= new GestionUsario();
        Usuario user = null;

        do {
            System.out.println("-------------MENU-------------------");
            System.out.println("1. Insertar Usuario");
            System.out.println("2. Actualizar Usario");
            System.out.println("3. Borrar Usario");
            System.out.println("4. Mostrar Usarios");
            System.out.println("0. Salir");
            System.out.println("Intrdozca una Opcion:");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Introduzca el Nombre de Usario:");
                    userName = sc.nextLine();
                    System.out.println("Introduzca el Password(Contrasena)");
                    passd = sc.nextLine();
                    user = new Usuario(userName,passd);
                    gestionUsuario.insertaUsario(user);
                    break;
                case 2:
                    System.out.println("Introduzca el Nombre de Usario:");
                    userName = sc.nextLine();
                    System.out.println("Introduzca el Password(Contrasena)");
                    passd = sc.nextLine();
                    user = new Usuario(userName,passd);
                    gestionUsuario.udpateUsario(user);
                    break;
                case 3:
                    System.out.println("Introduzca el Nombre de Usario:");
                    userName = sc.nextLine();
                    System.out.println("Introduzca el Password(Contrasena)");
                    passd = sc.nextLine();
                    System.out.println("Introduzca el IdUsuario:");
                    idUsuario= sc.nextInt();
                    user = new Usuario(idUsuario,userName,passd);
                    gestionUsuario.eliminarUsario(user);
                    break;
                case 4:
                    gestionUsuario.mostraUsarios();
                    break;
                default: System.out.println("Saliendo...");

            }
            //Pongo a null las variables
            userName = null;
            passd = null;
            idUsuario=0;

        }while(opcion!=0);

    }
}
