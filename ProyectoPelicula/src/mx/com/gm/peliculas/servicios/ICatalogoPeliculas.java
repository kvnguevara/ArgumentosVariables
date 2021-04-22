package mx.com.gm.peliculas.servicios;
/*Esta interface, tendrá los acceso al usuario, es decir, tendra el menu
 * y las operaciones que hara nuestro programa*/

public interface ICatalogoPeliculas {
    String NOMBRE_RECURSO = "peliculas.txt";

    public void agregarPelicula(String nombrePelicula);

    public void listarPeliculas();

    public void buscarPeliculas(String buscaPelicula);

    public void iniciarCatalogoPelicula();
}
