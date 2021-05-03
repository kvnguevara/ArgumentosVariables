package com.kevinguevara.servicios;

import com.kevinguevara.datos.*;
import com.kevinguevara.usarios.Usuario;
import java.sql.*;
import java.util.*;


/*Clase donde hacemos uso de la interfeaace IUser, e implementamos las operaciones que queremos
* que se muestre en la gestión del programa al usario*/
public class GestionUsario implements IAGestionUsuario{
    private int registro;
    private final IUser datosUsario;

    public GestionUsario(Connection con){

        this.datosUsario = new UserPAO(con);
    }
    @Override
    public void insertaUsario(Usuario user) throws SQLException {

        registro= datosUsario.inserta(user);
        if (registro>0)
            System.out.println("Se ha inserta un Registro");
        else
            System.out.println("Hubo un error en la Insercion ");
    }

    @Override
    public void eliminarUsario(Usuario user) throws SQLException {
        registro = datosUsario.delete(user);
        if (registro>0)
            System.out.println("Se ha eliminado un Registro ");
        else System.out.println("Hubo un error en la Eliminacion del Registro");
    }

    @Override
    public void udpateUsario(Usuario user) throws SQLException {
        registro= datosUsario.actualizar(user);
        if (registro>0)
            System.out.println("Se ha Actualizado un Registro");
        else System.out.println("Hubo un error a la ahora de Eliminar el Registro");
    }

    @Override
    public void mostraUsarios() throws SQLException {
        List<Usuario> userList = new ArrayList<>();

        userList = datosUsario.selecionar();
        //Muestro la lista
        userList.forEach(System.out::println);

    }
}
