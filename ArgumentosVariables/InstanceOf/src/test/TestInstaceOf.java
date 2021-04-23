package test;

import domain.*;

public class TestInstaceOf {
    public static void main(String[] args) {

        Empleado e = new Empleado("Juan",5201.33);
        determinarTipo(e);
        e = new Gerente("Kevin",250000,"Informatica");
//        determinarTipo(e);

       /* //Ahora mostramos la informacion
        System.out.println("Gerente: "+g.obetenerDetalles());        //Empleado
        System.out.println("Empleado:"+e.obetenerDetalles());*/


    }
    public static  void determinarTipo(Empleado em){
        if (em instanceof Gerente){
            Gerente gerente = (Gerente) em;
            System.out.println("Es de tipo Generente y su departamento es :"+gerente.getDepartamento());
        }else if( em instanceof Empleado){
//            Gerente gerente = (Gerente) em;-->Daria un error de Ejecución !
            System.out.println("Es de tipo Empleado: "+em.getNombre());
        }else if(em instanceof Object){
            //Solo podriamos utilizar los metodos genericos de la clase Object.
            System.out.println("ES de tipo Object");

        }
    }
}
