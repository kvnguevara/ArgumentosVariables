package domain;

public class Persona {
    private final int idPersona;
    private static int contadorPersona;
    /*Se ejecuta antes de los constructores, solo se ejecuto las static*/
    static {
        System.out.println("Ejecucion bloque estatico");
        ++Persona.contadorPersona;
    }
    {
        System.out.println("Bloque no estatico(Dinamico)");
        this.idPersona = Persona.contadorPersona++;
    }
    public Persona(){
        System.out.println("Ejecucion de Constructor");
    }

    public int getIdPersona() {
        return idPersona;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Persona{");
        sb.append("idPersona=").append(idPersona);
        sb.append('}');
        return sb.toString();
    }
}
