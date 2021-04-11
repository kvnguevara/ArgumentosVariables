package domain;

public class Escritor extends Empleado{
    final TipoEscritura tipoEscritura;
    public Escritor(String nombre,double sueldo, TipoEscritura tipoEscritura){
        super(nombre, sueldo);
        this.tipoEscritura = tipoEscritura;
    }

    @Override
    public String obetenerDetalles() {
        return super.obetenerDetalles()+" Tipo de Escritura: "+tipoEscritura.getDescripcion();
    }
    //Creacion de metodo get de Tipo de escritura


    public TipoEscritura getTipoEscritura() {
        return tipoEscritura;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Escritor{");
        sb.append("tipoEscritura=").append(tipoEscritura);
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
