package datos;
/*
* Está clase es la que se encargara para realizar las operaciones
* de Inserta, Actualizar, buscar y modificar, en la Tabla Persona en
* nuestra base de datos.*/

import domain.Persona;

import java.sql.*;
import java.util.*;

public class PersonaDAO {
    private static final String SQL_SELECT = "SELECT id_persona,nombre,apellido,mail,telefono FROM persona";
    public List<Persona> selecionar(){
        Connection con = null;
        PreparedStatement prst = null;
        ResultSet rst = null;
        Persona persona = null;
        List<Persona> listpersonas = new ArrayList<>();
        try {
            //Hacemos un llamado a la conexion, que tenemos en nuestra clase
            con = Conexion.getConnection();
            //Preparamos la sentencia, con preparateStament
            prst = con.prepareStatement(SQL_SELECT);
            //Ejecutamos la sentencia SQL
            rst = prst.executeQuery();
            //Vamos recuperando cada columna y fila del resultado
            while(rst.next()){
                persona = new Persona(rst.getInt("id_persona"),rst.getString("nombre"),rst.getString("apellido")
                ,rst.getString("mail"),rst.getString("telefono"));
                listpersonas.add(persona);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }
        /*Creamos el bloque de finally, para cerrar los objetos utilizados en la
        * conexion a la BD.
        * Se cierra en el orden inverson de la creacion.*/
        finally{
            try {
                Conexion.close(rst);
                Conexion.close(prst);
                Conexion.close(con);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        return listpersonas;
    }
}
