package test;

import domain.Gerente;

public class TestSobreescritura {
    public static void main(String[] args) {
        Gerente g = new Gerente("Kevin",250000,"Informatica");
        //Ahora mostramos la informacion
        System.out.println("Gerente: "+g.obetenerDetalles());
    }
}
