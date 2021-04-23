package test;

public class TestAutoboxinUnboxing {
    public static void main(String[] args) {
//        clases envolventes de tipo primitivos
        /*
        * int -- Integer
        * long Long
        * float Float
        * double--Double
        * */
        Integer entero = 10;
        System.out.println("Entero: " + entero);
        System.out.println("Entero pero String: " +entero.toString());
        System.out.println("Entero en doble: " +entero.doubleValue());

        /*unboxing es hacer lo contrario, pasar de un objeto a tipo primitivo*/
        int entero2 =  entero;
        System.out.println("Entero2: "+entero2);
    }
}
