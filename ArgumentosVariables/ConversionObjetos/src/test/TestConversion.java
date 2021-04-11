package test;

import domain.*;

public class TestConversion {
    public static void main(String[] args) {
        Empleado empleado;
        empleado = new Escritor("Kevin",35400,TipoEscritura.CLASICO);
//        System.out.println(empleado);

        System.out.println(empleado.obetenerDetalles());

//        Downcasting
        ((Escritor)empleado).getTipoEscritura(); //Este metodo solo está disponible de la clase Escritor.

        Escritor escritor = (Escritor) empleado;
        escritor.getTipoEscritura();


        }

}
