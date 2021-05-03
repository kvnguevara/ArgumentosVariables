import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;

import java.sql.*;
import java.util.List;

public class TestManejoPersona {


    public static void main(String[] args) {
        //Vamos a comprabar si inserta bien
        Connection conexion = null;
        try {

            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            PersonaDAO nuevaPersona = new PersonaDAO(conexion);
            //VAmos hacer un Update de algun registro de la BD
            Persona cambioPersona = new Persona(1,"KevinGG","Guevara","kevinguevaracarrasco@gmail.com"
            ,"625287943");
            nuevaPersona.actualizar(cambioPersona);
            //Las transacciones tienen que usarse con las que modifican la BD
            //Como es update, insert, delete
             Persona p= new Persona("KarlaGG","Gonzalez","karlagg@gmail.com","6332544");
            //Insertamos en la BD
            nuevaPersona.insertar(p);
            //Una vez terminada las sentencias, hacemos el commit para modificar la BD
            conexion.commit();
        } catch (SQLException throwables) {
            System.out.println("Error:"+throwables.getSQLState()+"Informacion:"+throwables.getMessage());
            //Si hay un error hacemos el rollback
            System.out.println("Hubo un error");
            try {
                conexion.rollback();
                System.out.println("Volviendo atrás");
            } catch (SQLException e) {
                System.out.println("Error: "+throwables.getMessage()+"Estado: "+e.getSQLState());
            }
        }
        /*PersonaDAO personaDAO = new PersonaDAO();
        Persona p_nueva = new Persona("Jose Carlos","Ibramovic","ibra@gmail.com","625287753");
        *//*System.out.println("---------------INSERTAR----------------------");
        if (personaDAO.insertar(p_nueva)>0){
            System.out.println("Se ha insertado un nuevo registro");
        }else System.out.println("Se ha produccido un Error a la hora de insertar");

        personaDAO.mostrarLista();
        System.out.println("-----------------------------------------------");
//        List<Persona> listPersonas = personaDAO.selecionar();
        //listPersonas.forEach(System.out::println); //1 primera formma de imprimir en Arraylis
        //listPersonas.forEach(p -> System.out.println(p.toString()));
//        listPersonas.forEach(persona -> {
//            System.out.println(persona.toString());
//        });
        System.out.println("---------------MODIFICAR----------------------");

        p_nueva = new Persona(8,"Kevin Armando","Guevara","kvnguevaracarrasco@gmail.com",
                "625287943");
        //int id_persona = 1;
        personaDAO.actualizar(p_nueva);
//        listPersonas=personaDAO.selecionar();
//        listPersonas.forEach(System.out::println);
        personaDAO.mostrarLista();
        System.out.println("----------------------------------------------");
//        personaDAO.eliminar(1);
//        listPersonas  = personaDAO.selecionar();
//        listPersonas.forEach(System.out::println);*/
        /*Vamos a modificar la clase para usar la transaccion en la base de datos
        * JDBC, nos permite realizar dicha transacion con el metodo commit
        * es decir, que todos las sentencias de update, insert y borrar
        * no modifca la BD, hasta que sea haga el commit
        * */


    }
}
