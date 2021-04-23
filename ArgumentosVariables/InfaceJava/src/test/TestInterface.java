package test;

import accesodatos.*;

public class TestInterface {
    public static void main(String[] args) {
        IAcessoDatos datos = new ImplementacionMysql();
        System.out.println("Imprimir datos con Mysql");
        /*//Vamos a utilizar polimorfismo para poder hacer el codigo más generico
        datos.listar();
        datos.actualizar();
        //Hacemos uso del polimorfismo en Java*/
        imprimir(datos);

        datos = new ImplemtacionOracle();
        System.out.println("Imprimimos los acceso de Oracle");
        /*datos.listar();
        datos.insertar();*/
        imprimir(datos);
    }
    //Metodo generico para mostrar(metodo listar)
    public static void imprimir(IAcessoDatos datos){
        datos.listar();
    }
}
