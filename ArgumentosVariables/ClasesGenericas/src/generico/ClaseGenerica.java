package generico;

public class ClaseGenerica<T> {
   private  T objeto;

    public ClaseGenerica(T objeto) {
        this.objeto = objeto;
    }
    public  void obtenerTipo(){
        System.out.println("El tipo de T es: "+objeto.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ClaseGenerica{");
        sb.append("objeto=").append(objeto);
        sb.append('}');
        return sb.toString();
    }
}
