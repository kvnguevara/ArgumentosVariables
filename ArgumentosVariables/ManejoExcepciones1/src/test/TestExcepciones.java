package test;

import excepciones.OperacionExcepcion;

import static aritmetica.Aritmetica.division;

public class TestExcepciones {
    public static void main(String[] args) {
        int resultado = 0;
        try {
            resultado = division(10,0);

        }catch (OperacionExcepcion e){
            System.out.println("Ocurrio un error de tipo OperacionExcepcion");
        }
        catch (Exception e){
            System.out.println("Ocurrio un error de tio Excepcion");
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Se reviso la divison entre 0");
        }
        System.out.println("Resultado: "+ resultado);
    }
}
