package com.kevinguevara.presentacion;

import com.kevinguevara.conexion.Conexion;
import com.kevinguevara.servicios.*;
import com.kevinguevara.usarios.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class PresentacionUsuario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        String userName;
        String passd;
        int idUsuario;
        IAGestionUsuario gestionUsuario = null;
        Usuario user = null;
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
                gestionUsuario = new GestionUsario(conexion);
            }


            do {
                System.out.println("-------------MENU-------------------");
                System.out.println("1. Insertar Usuario");
                System.out.println("2. Actualizar Usario");
                System.out.println("3. Borrar Usario");
                System.out.println("4. Mostrar Usarios");
                System.out.println("0. Salir");
                System.out.println("Intrdozca una Opcion:");
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Introduzca el Nombre de Usario:");
                        userName = sc.nextLine();
                        System.out.println();
                        System.out.print("Introduzca el Password(Contrasena)");
                        passd = sc.nextLine();
                        user = new Usuario(userName, passd);
                        gestionUsuario.insertaUsario(user);
                        conexion.commit();
                        break;
                    case 2:
                        System.out.println("Introduzca el IdUsuario:");
                        idUsuario = Integer.parseInt(sc.nextLine());
                        System.out.println("Introduzca el Nombre de Usario:");
                        userName = sc.nextLine();
                        System.out.println("Introduzca el Password(Contrasena)");
                        passd = sc.nextLine();
                        user = new Usuario(idUsuario, userName, passd);
                        gestionUsuario.udpateUsario(user);
                        conexion.commit();
                        break;
                    case 3:
                        System.out.println("Introduzca el IdUsuario:");
                        idUsuario = Integer.parseInt(sc.nextLine());
                        System.out.println("Introduzca el Nombre de Usario:");
                        userName = sc.nextLine();
                        System.out.println("Introduzca el Password(Contrasena)");
                        passd = sc.nextLine();

                        user = new Usuario(idUsuario, userName, passd);
                        gestionUsuario.eliminarUsario(user);
                        conexion.commit();
                        break;
                    case 4:
                        gestionUsuario.mostraUsarios();
                        break;
                    default:
                        System.out.println("Saliendo...");

                }
            /*//Pongo a null las variables
            userName = null;
            passd = null;
            idUsuario=0;*/


            } while (opcion != 0);
        } catch (SQLException throwables) {
            System.out.println("Error:\n" + throwables.getMessage());
            try {
                conexion.rollback();
                System.out.println("No se ha realizado ninguna operacion en la BD");
            } catch (SQLException e) {
                System.out.println("Mensaje:" + e.getMessage());
            }
        }

    }
}
