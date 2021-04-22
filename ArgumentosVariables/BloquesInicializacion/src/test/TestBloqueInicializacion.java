package test;

import domain.Persona;

public class TestBloqueInicializacion {
    public static void main(String[] args) {
        Persona persona = new Persona();
        System.out.println("IDPersona: "+persona);
        System.out.println("------------------------");
        /*Solo se ejecuta el bloque no estatico o dinamica, ya que solo se ejecuta una vez
        * el bloque estatico esto se debe a que el bloque estatico, ya estñá cargado en Memoria*/
        Persona persona1 = new Persona();
        System.out.println(persona1);
    }
}
