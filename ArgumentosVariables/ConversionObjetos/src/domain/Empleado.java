package domain;

public class Empleado {
    protected  String nombre;
    protected double sueldo;

    public Empleado(String nombre, double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
    //Este sera el metod que vamos a sobreescribir
    public String obetenerDetalles(){
        return "Nombre: "+this.nombre+" Sueldo: "+this.sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Empleado{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", sueldo=").append(sueldo);
        sb.append('}');
        return sb.toString();
    }
}
