package test;

import enumeracion.Continentes;
import enumeracion.Dias;

public class TestEnumeraciones {
    public static void main(String[] args) {
       /* System.out.println("Dia 1:"+Dias.LUNES);*/
        System.out.println("Continente nº 4:"+Continentes.AMERICA);
        System.out.println("Nº Paises en el 4ºto continente: "+Continentes.AMERICA.getPaises());
        System.out.println("Continente nº 1:"+Continentes.AFRICA);
        System.out.println("Nº Paises en el 4ºto continente: "+Continentes.AFRICA   .getPaises());
    }
    public static  void indicarDiaSemana(Dias d){
        switch (d){
            case LUNES -> System.out.println("Primer Dia");
            case MARTES -> System.out.println("Segundo Dia");

        }

    }
}
