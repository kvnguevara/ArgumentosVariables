import datos.PersonaDAO;
import domain.Persona;

import java.util.List;

public class TestManejoPersona {


    public static void main(String[] args) {
        //Vamos a comprabar si inserta bien
        PersonaDAO personaDAO = new PersonaDAO();
        Persona p_nueva = new Persona("Jose Carlos","Ibramovic","ibra@gmail.com","625287753");
        System.out.println("---------------INSERTAR----------------------");
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
//        listPersonas.forEach(System.out::println);

    }
}
