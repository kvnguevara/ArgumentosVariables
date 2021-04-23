package test;

import java.util.*;

public class TestApiColecciones {
    public static void main(String[] args) {
        List miLista = new ArrayList(); // creacion de lista, pero tenemos que hacerlo con Arraylist
        //Agregar un objeto
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        miLista.add("Sabado");
        miLista.add("Domingo");

        //Foreach
        System.out.println("Mostrar por Foreach");
       /* for (Object e :miLista
             ) {
            System.out.println(e);

        }
        System.out.println("Mostrar por funcion Lmbda");
        //Para mostrar la lista funciones lambda
        miLista.forEach(elemento->{
            System.out.println("Dia:"+elemento);
        });/**/
        imprimir(miLista);

        //Por set
        Set miSet = new HashSet();
        miSet.add("Lunes");
        miSet.add("Martes");
        miSet.add("Domingo");
        miSet.add("Miercoles");
        miSet.add("Jueves");
        miSet.add("Viernes");
        miSet.add("Sabado");
        miSet.add("Domingo");

        System.out.println("Mostrar el Set");
        imprimir(miSet);

        Map miMapa = new HashMap(); // creacion del Objeto Map
        //agregar un valor a Map
        miMapa.put("Valor1","Kevin");
        miMapa.put("Valor2","Carla");
        miMapa.put("Valor3","Rosario");
        miMapa.put("Valor4","Juan");
        miMapa.put("Valor5","Diego");

        //Acceder directamente de los elementos de Map
        String elemento = (String) miMapa.get("Valor3");
        System.out.println(elemento);
        //Para imprimir el Map
        imprimir(miMapa.keySet());
        //Valores asociados a las llaves
        imprimir(miMapa.values());



    }

    public  static void imprimir(Collection c){

        c.forEach(elemento->{
            System.out.println("Dia: "+elemento);
        });
    }
}
