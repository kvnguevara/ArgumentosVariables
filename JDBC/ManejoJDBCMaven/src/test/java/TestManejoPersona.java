import datos.PersonaDAO;
import domain.Persona;

import java.util.List;

public class TestManejoPersona {


    public static void main(String[] args) {
        //Vamos a comprabar si inserta bien
        PersonaDAO personaDAO = new PersonaDAO();
        Persona p_nueva = new Persona("Jose Carlos","Ibramovic","ibra@gmail.com","625287753");
        if (personaDAO.insertar(p_nueva)>0){
            System.out.println("Se ha insertado un nuevo registro");
        }else System.out.println("Se ha produccido un Error a la hora de insertar");
        List<Persona> listPersonas = personaDAO.selecionar();
        //listPersonas.forEach(System.out::println); //1 primera formma de imprimir en Arraylis
        //listPersonas.forEach(p -> System.out.println(p.toString()));
        listPersonas.forEach(persona -> {
            System.out.println(persona.toString());
        });
        p_nueva = new Persona(1,"Kevin Armando","Guevara","kvnguevaracarrasco@gmail.com",
                "625287943");
        //int id_persona = 1;
        System.out.println("--------------------------------------");
        personaDAO.actualizar(p_nueva);
        listPersonas=personaDAO.selecionar();
        listPersonas.forEach(System.out::println);
        System.out.println("--------------------------------------");
        personaDAO.eliminar(6);
        listPersonas  = personaDAO.selecionar();
        listPersonas.forEach(System.out::println);

    }
}
