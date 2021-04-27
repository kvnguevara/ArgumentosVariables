package datos;
/*
* Está clase es la que se encargara para realizar las operaciones
* de Inserta, Actualizar, buscar y modificar, en la Tabla Persona en
* nuestra base de datos.*/

import domain.Persona;

import java.sql.*;
import java.util.*;

import static datos.Conexion.*;

public class PersonaDAO {
    private static final String SQL_SELECT = "SELECT id_persona,nombre,apellido,mail,telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre,apellido,mail,telefono) VALUES(?, ?, ?, ?)";
    public List<Persona> selecionar(){
        Connection con = null;
        PreparedStatement prst = null;
        ResultSet rst = null;
        Persona persona = null;
        List<Persona> listpersonas = new ArrayList<>();
        try {
            //Hacemos un llamado a la conexion, que tenemos en nuestra clase
            con = getConnection();
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
                close(rst);
                close(prst);
                close(con);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        return listpersonas;
    }
    public int insertar(Persona p){
        //Inicializo las variables
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int registro = 0;
        try {
            con = getConnection();
            pst = con.prepareStatement(SQL_INSERT);
            pst.setString(1,p.getNombre());
            pst.setString(2,p.getApellido());
            pst.setString(3,p.getMail());
            pst.setString(4,p.getTelefono());
            //executeUpdate nos sirve para eliminar, actualizar e insertar en la BD
            registro = pst.executeUpdate();
        } catch (SQLException throwables) {
            //throwables.printStackTrace(System.out);
            System.out.println(throwables.getMessage());
        }
        finally{
            try {
                //cerramos el preparateStament, conexion
                close(pst);
                close(con);
            } catch (SQLException throwables) {
                //throwables.printStackTrace(System.out);
                System.out.println(throwables.getMessage());
            }

        }
        //retornamos el registro, para saber si se ha insertado bien
        return registro;


    }
}
