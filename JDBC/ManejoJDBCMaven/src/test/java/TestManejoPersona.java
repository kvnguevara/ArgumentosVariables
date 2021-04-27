import datos.PersonaDAO;
import domain.Persona;

import java.util.List;

public class TestManejoPersona {


    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        List<Persona> listPersonas = personaDAO.selecionar();
        //listPersonas.forEach(System.out::println); //1 primera formma de imprimir en Arraylis
        //listPersonas.forEach(p -> System.out.println(p.toString()));
        listPersonas.forEach(persona -> {
            System.out.println(persona.toString());
        });

    }
}
