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
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ? ";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?,apellido = ? ,mail = ? ,telefono = ? WHERE id_persona = ?";

    public List<Persona> selecionar() {
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
            while (rst.next()) {
                persona = new Persona(rst.getInt("id_persona"), rst.getString("nombre"), rst.getString("apellido")
                        , rst.getString("mail"), rst.getString("telefono"));
                listpersonas.add(persona);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }
        /*Creamos el bloque de finally, para cerrar los objetos utilizados en la
         * conexion a la BD.
         * Se cierra en el orden inverson de la creacion.*/ finally {
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

    public int insertar(Persona p) {
        //Inicializo las variables
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int registro = 0;
        try {
            con = getConnection();
            pst = con.prepareStatement(SQL_INSERT);
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getApellido());
            pst.setString(3, p.getMail());
            pst.setString(4, p.getTelefono());
            //executeUpdate nos sirve para eliminar, actualizar e insertar en la BD
            registro = pst.executeUpdate();
        } catch (SQLException throwables) {
            //throwables.printStackTrace(System.out);
            //System.out.println(throwables.getMessage());
            System.err.format("SQL State: %s\n%s", throwables.getSQLState(), throwables.getMessage());
        } finally {
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

    public int eliminar(int idPersona) {
        int registro = 0;
        //Declaracion de variables que vamos a utilizar
        Connection con = null;
        PreparedStatement prst = null;
        //Establecemos la conecion
        try {
            con = getConnection();
            if (idPersona < 1) {
                registro = 0;
            } else {
                //preparo la consulta
                prst = con.prepareStatement(SQL_DELETE);
                //Agrero los datos a borrar(id_persona), en la BD
                prst.setInt(1, idPersona);
                //ejecuto la sentencia SQL, con los datos(id_persona)
                registro = prst.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //cierro el preparateStament y la conexion
        finally {
            try {
                close(prst);
                close(con);
            } catch (SQLException throwables) {
                System.err.format("%s \n %s", throwables.getSQLState(), throwables.getMessage());
            }
        }
        return registro;

    }

    //Metodo para modificar datos en un BD
    public int actualizar(Persona p) {
        int registro = 0;
        Connection con = null;
        PreparedStatement prst = null;
        try {
            con = getConnection();
            prst = con.prepareStatement(SQL_UPDATE);
            prst.setString(1, p.getNombre());
            prst.setString(2, p.getApellido());
            prst.setString(3, p.getMail());
            prst.setString(4, p.getTelefono());
            prst.setInt(5, p.getIdPersona());
            //Ejecuto la sentencia SQl
            registro = prst.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                close(prst);
                close(con);
            } catch (SQLException throwables) {
                System.err.format("SQL-STATE:%s\n %s", throwables.getSQLState(), throwables.getMessage());
            }
        }

        return registro;
    }
    public void mostrarLista() {
        List<Persona> listpersonas = selecionar();
        listpersonas.forEach(System.out::println);
    }

}
