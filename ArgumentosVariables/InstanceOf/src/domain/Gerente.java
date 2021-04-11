package domain;

public class Gerente extends Empleado{
    private String departamento;

    public Gerente(String nombre, double sueldo, String departamento){
        super(nombre, sueldo);
        this.departamento = departamento;

    }
    //Metodos gett y sett

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    //Metodo sobreescrito dede obtenerDetalles

    @Override
    public String obetenerDetalles() {
        return super.obetenerDetalles()+", Departamento :"+this.departamento;
    }
}
