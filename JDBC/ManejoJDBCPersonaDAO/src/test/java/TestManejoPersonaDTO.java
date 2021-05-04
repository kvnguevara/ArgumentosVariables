import com.kevinguevara.conexion.Conexion;
import com.kevinguevara.datos.PersonaDao;
import com.kevinguevara.datos.PersonaDaoJDBC;
import com.kevinguevara.domain.PersonaDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestManejoPersonaDTO {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = Conexion.getConnection();
            if (con.getAutoCommit())
            {
                con.setAutoCommit(false);
            }
            PersonaDao personaDao = new PersonaDaoJDBC(con);
           List<PersonaDTO> listaPersonas = personaDao.select();
           listaPersonas.forEach(x-> System.out.println(x));
            con.commit();
        } catch (SQLException throwables) {
            //Muestro el error de los metodos
            System.out.println("Mensaje: "+throwables.getMessage());
            //throwables.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e) {
                //e.printStackTrace();
                System.out.println("Se hizo rollback");
                System.out.println(e.getSQLState());
            }
        }

    }
}
