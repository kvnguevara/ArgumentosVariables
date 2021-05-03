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

public class UserPAO implements IUser, Iconsultas {
    private static Connection con;
    private static PreparedStatement prst;
    private static ResultSet rst;
    private int registro;
    private Connection conexionT;

    public UserPAO() {
        con = null;
        prst = null;
        rst = null;
        registro = 0;
    }

    public UserPAO(Connection conexion) {
        this.conexionT = conexion;
        con = null;
        prst = null;
        rst = null;
        registro = 0;
    }

    @Override
    public int inserta(Usuario user) throws SQLException {

        try {
            //Preparo la conexion
            con = this.conexionT != null ? this.conexionT : getConnection();
            //Preparo la sentencia de Insertar
            prst = con.prepareStatement(SQL_INSERT);
            //Inyecto los datos en la sentencia sql
            prst.setString(1, user.getUser());
            prst.setString(2, user.getPassword());
            //Ejecuto la sentecia
            registro = prst.executeUpdate();

        }
        //Cierro conexiones
        finally {
//                close(rst);
            close(prst);
            if (this.conexionT == null) {
                close(con);
            }

        }
        //Retorno registo
        return registro;
    }

    @Override
    public int delete(Usuario user) throws SQLException {
        registro = 0;

        try {
            //Establezco conexion con la BD
            con = this.conexionT != null ? this.conexionT : getConnection();
            //Preparo la sentecia
            prst = con.prepareStatement(SQL_DELETE);
            //Inyecto los datos para la consulta
            prst.setInt(1, user.getIdUsuario());
            //Ejecuto la sentecia
            registro = prst.executeUpdate();

        } finally {
            //Cierro conexion, preparateStament
            close(prst);
            if (this.conexionT == null) {
                close(con);
            }
        }
        return registro;

    }

    @Override
    public List<Usuario> selecionar() throws SQLException {
        List<Usuario> usuarioList = new ArrayList<>();
        Usuario user = null;
        try {
            con = this.conexionT != null ? this.conexionT : getConnection();
            prst = con.prepareStatement(SQL_SELECT);
            rst = prst.executeQuery();
            //Recorro los registro y añado a la lista
            while (rst.next()) {
                user = new Usuario(rst.getInt("id_usuario"), rst.getString("user")
                        , rst.getString("password"));
                usuarioList.add(user);
            }
        }
        //Bloque que cierra las conexiones
        finally {

            close(rst);
            close(prst);
            if (this.conexionT == null) {
                close(con);
            }

        }
        return usuarioList;
    }

    @Override
    public int actualizar(Usuario user) throws SQLException {
        //Inicializo las variables
        registro = 0;
        try {
            con = this.conexionT != null ? this.conexionT :getConnection();
            prst = con.prepareStatement(SQL_UPDATE);
            prst.setString(1, user.getUser());
            prst.setString(2, user.getPassword());
            prst.setInt(3, user.getIdUsuario());
            registro = prst.executeUpdate();
            ;
        }
        finally {

                close(prst);
                if (this.conexionT == null) {
                    close(con);
                }

        }
        return registro;
    }

    /*@Override
    public void mostrar() {
        List<Usuario> userList = new ArrayList<>();
        userList = selecionar();
        //Muestro por pantalla la lista que me devuelve el metodo seleccionar.
        userList.forEach(System.out::println);

    }*/
}
