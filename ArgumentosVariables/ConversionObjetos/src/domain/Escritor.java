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
}
