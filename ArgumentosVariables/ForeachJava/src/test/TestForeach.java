package test;

import domain.Persona;

public class TestForeach {
    public static void main(String[] args) {
        /*El foreach, es el for mejorado, se utliza principalmente con array de objecto, lista
        * */
        //Ejemplo
        int edades[] = {25,35,85,45,32,33};

        //Foreach (variable:nombre del array)
        for (int edad:edades
             ) {
            System.out.println("Edad:"+edad);
            
        }
        Persona p[] = {new Persona("Kevin"),new Persona("Juan"),
                new Persona("Carlos"),new Persona("Lorena")};
        //Ejecutamos el foreach
        for (Persona persona:p
             ) {
            System.out.println(persona.toString());

        }
    }
}
