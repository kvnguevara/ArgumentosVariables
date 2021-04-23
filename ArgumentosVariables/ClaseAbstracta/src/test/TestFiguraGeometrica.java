package test;

import domain.*;
public class TestFiguraGeometrica {
    public static void main(String[] args) {
        //Vamos a utlizar el polimorfismo, es decir, reutilizar el codigo para hacer programas más genericos.
        FiguraGeometrica figura = new Rectangulo("Rectangulo");
        figura.dibujar(); //se ejecuta el método que tenemos en comun, entre las dos clases

    }
}
