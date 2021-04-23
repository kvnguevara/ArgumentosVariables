package accesodatos;

public interface IAcessoDatos {
    //atributos serán constantes.
    int MAX_REGISTRO = 10;
    public void insertar();
    public void eliminar();
    public void listar();
    public void actualizar();

}
