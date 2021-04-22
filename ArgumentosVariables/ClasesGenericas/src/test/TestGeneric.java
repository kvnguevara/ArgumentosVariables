package test;

import generico.ClaseGenerica;

public class TestGeneric {
    public static void main(String[] args) {
        //unca clase de tipo entero
        ClaseGenerica<Integer> objetoInt = new ClaseGenerica<>(15);
        objetoInt.obtenerTipo();

        //Una clase de tipo String
        ClaseGenerica<String> objetoString = new ClaseGenerica<>("Hola Kevin");
        objetoString.obtenerTipo();
    }
}
