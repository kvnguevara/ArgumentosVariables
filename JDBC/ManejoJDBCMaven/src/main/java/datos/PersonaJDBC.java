package datos;
/*
 * Está clase es la que se encargara para realizar las operaciones
 * de Inserta, Actualizar, buscar y modificar, en la Tabla PersonaDTO en
 * nuestra base de datos.*/

import domain.PersonaDTO;

import java.sql.*;
import java.util.*;

import static datos.Conexion.*;

public class PersonaJDBC {
    private Connection conecionTransacional;
    private static final String SQL_SELECT = "SELECT id_persona,nombre,apellido,mail,telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre,apellido,mail,telefono) VALUES(?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ? ";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?,apellido = ? ,mail = ? ,telefono = ? WHERE id_persona = ?";

    public PersonaJDBC() {

    }

    public PersonaJDBC(Connection conecionTransacional) {
        this.conecionTransacional = conecionTransacional;
    }

    public List<PersonaDTO> selecionar() throws SQLException {
        Connection con = null;
        PreparedStatement prst = null;
        ResultSet rst = null;
        PersonaDTO personaDTO = null;
        List<PersonaDTO> listpersonas = new ArrayList<>();
        try {
            //Hacemos un llamado a la conexion, que tenemos en nuestra clase
            con = this.conecionTransacional != null ? this.conecionTransacional : getConnection();
            //Preparamos la sentencia, con preparateStament
            prst = con.prepareStatement(SQL_SELECT);
            //Ejecutamos la sentencia SQL
            rst = prst.executeQuery();
            //Vamos recuperando cada columna y fila del resultado
            while (rst.next()) {
                personaDTO = new PersonaDTO(rst.getInt("id_persona"), rst.getString("nombre"), rst.getString("apellido")
                        , rst.getString("mail"), rst.getString("telefono"));
                listpersonas.add(personaDTO);

            }
        }
        /*Creamos el bloque de finally, para cerrar los objetos utilizados en la
         * conexion a la BD.
         * Se cierra en el orden inverson de la creacion.*/ finally {

            close(rst);
            close(prst);
            if (this.conecionTransacional == null) {
                close(con);
            }

        }

        return listpersonas;
    }

    public int insertar(PersonaDTO p) throws SQLException {
        //Inicializo las variables
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int registro = 0;
        try {
            con = this.conecionTransacional != null ? this.conecionTransacional : getConnection();
            pst = con.prepareStatement(SQL_INSERT);
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getApellido());
            pst.setString(3, p.getMail());
            pst.setString(4, p.getTelefono());
            //executeUpdate nos sirve para eliminar, actualizar e insertar en la BD
            registro = pst.executeUpdate();
        } finally {
            close(pst);
            if (this.conecionTransacional == null) {
                close(con);
            }

        }
        //retornamos el registro, para saber si se ha insertado bien
        return registro;
    }

    public int eliminar(int idPersona) throws SQLException {
        int registro = 0;
        //Declaracion de variables que vamos a utilizar
        Connection con = null;
        PreparedStatement prst = null;
        //Establecemos la conecion
        try {
            con = this.conecionTransacional != null ? this.conecionTransacional : getConnection();
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
        }
        //cierro el preparateStament y la conexion
        finally {
            close(prst);
            if (this.conecionTransacional == null) {
                close(con);
            }
        }
        return registro;

    }

    //Metodo para modificar datos en un BD
    public int actualizar(PersonaDTO p) throws SQLException {
        int registro = 0;
        Connection con = null;
        PreparedStatement prst = null;
        try {
            con = this.conecionTransacional != null ? this.conecionTransacional : getConnection();
            prst = con.prepareStatement(SQL_UPDATE);
            prst.setString(1, p.getNombre());
            prst.setString(2, p.getApellido());
            prst.setString(3, p.getMail());
            prst.setString(4, p.getTelefono());
            prst.setInt(5, p.getIdPersona());
            //Ejecuto la sentencia SQl
            registro = prst.executeUpdate();

        } finally {
            close(prst);
            if (this.conecionTransacional == null)
                close(con);
        }

        return registro;
    }

    public void mostrarLista() throws SQLException {
        List<PersonaDTO> listpersonas = selecionar();
        listpersonas.forEach(System.out::println);
    }

}
