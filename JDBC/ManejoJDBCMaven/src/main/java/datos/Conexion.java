package datos;

import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=" +
            "true&serverTimezone=UTC" + "&allowPublicKeyRetrieval=true";
    private static final String USSER = "root";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USSER, PASSWORD);

    }
    /*@Metodo que sobre escribimos para cerrar las conecciones y
    * los demás metodos
    * */
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }
    /*
    * Sobreescritura del metodo cerrar, ahora cerramos el PreparadStatement
    * */
    public static void close(PreparedStatement pst) throws SQLException {
        pst.close();

    }
    /*Sobre carga del metodo ahora se le pasa un elemento
    * Connection y así poder  cerrar la conexion
    * */

    public static void close(Connection con) throws SQLException {
        con.close();
    }
}
