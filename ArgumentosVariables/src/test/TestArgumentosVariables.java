package test;

public class TestArgumentosVariables {
    public static void main(String[] args) {
        System.out.println("Primera llamada de Imprimir:");
        imprimirNumeros(2,3,5);
        System.out.println("Segunda llamada de Imprimir: ");
        imprimirNumeros(55,85,66,89);

        System.out.println("Varios Parametos");
        variosParametros("Kevin",5,66,85,7);

    }
    private static  void variosParametros(String nombre,int...numeros){
        System.out.println("Nombre: "+nombre);
        imprimirNumeros(numeros);

    }
    private static  void imprimirNumeros(int...numeros){
        for (int i = 0; i < numeros.length; i++){
            System.out.println("Elementos: "+numeros[i]);
        }

    }

}
