package com.kevinguevara.conexion;

import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=" +
            "true&serverTimezone=UTC" + "&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASS = "admin";

    //Metodo que establece la conexion
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASS);

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
