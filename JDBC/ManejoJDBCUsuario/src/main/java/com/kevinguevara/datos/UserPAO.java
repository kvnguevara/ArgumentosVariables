package com.kevinguevara.datos;
/*Está clase es la encargada de realizar los métodos para insertar, actualizar
* Borrar y mostrar , ya que implementa la interface de usario
* Tenemos que realizar la inserta
* Delete
* Update
* Mostrar
* */

import com.kevinguevara.usarios.Usuario;
import java.sql.*;
import java.util.*;
import static com.kevinguevara.conexion.Conexion.*;

public class UserPAO implements IUser, Iconsultas{
    private static  Connection con;
    private static PreparedStatement prst ;
    private static ResultSet rst;
    private int registro;

    public UserPAO() {
        con = null;
        prst = null;
        rst = null;
        registro = 0;
    }

    @Override
    public int inserta(Usuario user) {

        try {
            //Preparo la conexion
            con = getConnection();
            //Preparo la sentencia de Insertar
            prst = con.prepareStatement(SQL_INSERT);
            //Inyecto los datos en la sentencia sql
            prst.setString(1,user.getUser());
            prst.setString(2,user.getPassword());
            //Ejecuto la sentecia
            registro = prst.executeUpdate();

        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            //Formato al Futurro erro
            System.err.format("Estado: %s\n%s"+throwables.getSQLState(),throwables.getMessage());
        }
        //Cierro conexiones
        finally {
            try {
//                close(rst);
                close(prst);
                close(con);
            } catch (SQLException throwables) {
                //throwables.printStackTrace();
                System.err.format("%s\n%s"+throwables.getSQLState(),throwables.getMessage());
            }
        }
        //Retorno registo
        return registro;
    }

    @Override
    public int delete(Usuario user) {
        registro =0;

        try {
            //Establezco conexion con la BD
            con = getConnection();
            //Preparo la sentecia
            prst = con.prepareStatement(SQL_DELETE);
            //Inyecto los datos para la consulta
            prst.setInt(1,user.getIdUsuario());
            //Ejecuto la sentecia
            registro = prst.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.format("Estado: %s \n %s"+throwables.getSQLState(),throwables.getMessage());
        }
        finally {
            //Cierro conexion, preparateStament
            try {
                close(prst);
                close(con);
            } catch (SQLException throwables) {
//                throwables.printStackTrace();
                System.err.format("Estado--> %s\n%s"+throwables.getSQLState(),throwables.getMessage());
            }

        }
        return registro;
    }

    @Override
    public List<Usuario> selecionar() {
        List<Usuario> usuarioList = new ArrayList<>();
        Usuario user = null;
        try {
            con = getConnection();
            prst = con.prepareStatement(SQL_SELECT);
            rst = prst.executeQuery();
            //Recorro los registro y añado a la lista
            while (rst.next()){
                user = new Usuario(rst.getInt("id_usuario"),rst.getString("user"),rst.getString("password"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int actualizar(Usuario user) {
        return 0;
    }

    @Override
    public void mostrar() {

    }
}
