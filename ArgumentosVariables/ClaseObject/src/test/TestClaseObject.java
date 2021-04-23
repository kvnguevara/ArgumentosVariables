package test;

import domain.*;

public class TestClaseObject {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Juan",5000);
        Empleado empleado1 = new Empleado("Juan",5000);

        //Si tienen la misma referencia en memoria
        if (empleado.equals(empleado1)){
            System.out.println("Los objetos son iguales en contenido");
        }else System.out.println("No tienen la misma referencia de Memoria");

        //Metodo hascode()
        if(empleado.hashCode()==empleado1.hashCode()){
            System.out.println("Tienen el mismo hasCode");

        }else {
            System.out.println("No tienen el mismo hasCode");
        }


        }

}
