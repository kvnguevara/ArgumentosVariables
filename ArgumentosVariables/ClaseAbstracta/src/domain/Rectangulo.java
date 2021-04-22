package domain;

public class Rectangulo  extends FiguraGeometrica{


    public Rectangulo(String tipoFigura) {
        super(tipoFigura);
    }
    /*
    * this.getClass().getSimpleName()
    * sabemos el nombre de la clase en Java*/
    @Override
    public void dibujar(){
        System.out.println("Se imprime un: "+this.getClass().getSimpleName());


    }
}
