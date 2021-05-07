package com.kevinguevara.conexion;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class Conexion {
    private static final  String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=" +
            "true&serverTimezone=UTC" + "&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASS = "admin";
    private static  BasicDataSource bds;

    public static DataSource getDataSource(){
        if(bds == null) {
            bds = new BasicDataSource();
            //bds.setDriverClassName(DRIVER_NAME);
            bds.setUrl(URL);
            bds.setUsername(USER);
            bds.setPassword(PASS);
            //Definimos el tamaño del pool de conexiones
            bds.setInitialSize(5);
            //Tenemos que tener cuidado con el tamaño de conexiones que tendra nuestro programa
            //Si es muy grande nuestra app, se puede bloquear.
        }return bds;
    }

    //Metodo que establece la conexion
    public static Connection getConnection() throws SQLException {
        //Lo que tenemos que hacer es agregar el metodo getDataSource()
        return getDataSource().getConnection();

    }
    /*Metodos para cerrar las conexiones */
    public static void close(Connection con) throws SQLException {
        con.close();
    }
    public static  void close(PreparedStatement pst) throws SQLException {
        pst.close();
    }
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }



}
