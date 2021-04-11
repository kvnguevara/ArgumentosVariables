package accesodatos;

public class ImplementacionMysql implements IAcessoDatos{

    //implementamos los métodos de la interface!

    @Override
    public void insertar() {
        System.out.println("Insertar des Mysql");

    }

    @Override
    public void eliminar() {
        System.out.println("Eliminar des Mysql");

    }

    @Override
    public void listar() {
        System.out.println("Listar desde Mysql");

    }

    @Override
    public void actualizar() {
        System.out.println("Actualizar desde Mysql");

    }
}
