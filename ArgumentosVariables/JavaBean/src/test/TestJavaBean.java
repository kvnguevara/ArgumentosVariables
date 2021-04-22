package test;

import domain.Persona;

public class TestJavaBean {
    public static void main(String[] args) {
        Persona persona = new Persona(); // es lo que crearan los objetos con el constructor vacio.
        persona.setNombre("Kevin");
        persona.setApellido("Guevara");
        //Tenemos que hacer uso siempre de los metodos get y set
        //Para imprimir siempre el método que hemos creado toString o de manera individual
        System.out.println(persona.toString());
        //Imprimir de forma individual
        System.out.println("Persona: { nombre:"+persona.getNombre()+" apellidos: "+persona.getApellido()+"}");
    }
}
