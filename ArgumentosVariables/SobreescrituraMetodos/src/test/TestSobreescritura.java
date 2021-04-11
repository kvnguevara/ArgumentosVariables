package test;

import domain.*;

public class TestSobreescritura {
    public static void main(String[] args) {

        Empleado e = new Empleado("Juan",5201.33);
        imprimir(e);
        e = new Gerente("Kevin",250000,"Informatica");
        imprimir(e);
       /* //Ahora mostramos la informacion
        System.out.println("Gerente: "+g.obetenerDetalles());        //Empleado
        System.out.println("Empleado:"+e.obetenerDetalles());*/


    }
    public static  void imprimir(Empleado em){
        String detalles = em.obetenerDetalles();
        System.out.println("Empleado: "+detalles);
    }
}
