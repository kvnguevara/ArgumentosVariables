import com.kevinguevara.datos.UsuarioDao;
import com.kevinguevara.datos.UsuarioDaoJDBC;
import com.kevinguevara.domain.UsuarioDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.kevinguevara.conexion.Conexion.getConnection;

public class TestMamnejoUsuarioDTO {
    public static void main(String[] args) {
        //Inicializo las variables
        List<UsuarioDTO> listUsario = new ArrayList<>();
        Connection conexion = null;
        UsuarioDao usarioDao;
        try {
            conexion = getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            usarioDao = new UsuarioDaoJDBC(conexion);
            //Mostrar
            listUsario = usarioDao.select();
            //Muestro la lista de usario
            listUsario.forEach(x -> System.out.println(x));
            //Si todo va bien hago el auto commit

            conexion.commit();

        } catch (SQLException throwables) {
//            throwables.printStackTrace();
            System.out.println("Error: " + throwables.getSQLState() + "\n Mensaje: " + throwables.getMessage() + "\n");
            try {
                conexion.rollback();
            } catch (SQLException e) {
//                e.printStackTrace();
                System.out.println("Mensaje: " + e.getMessage());
            }
        }
    }
}
