import java.sql.*;

public class TestMysqlJdbc {
    public static void main(String[] args) {
        //La url para indicar donde esta la bd
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC" +
                "&allowPublicKeyRetrieval=true";
        String username = "root";
        String passwd = "admin";
        try {
            //Se utiliza sobre todo para la conexion con bd en pagina web
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Hacemos la conexion a la base de datos, aportando la direc, el usuario y la contraseña
            Connection con = DriverManager.getConnection(url,username,passwd);
            //Creamos el Objeto para poder ejecutar sentencias
            Statement st = con.createStatement();
            String query = "SELECT * FROM persona";
            //Ejecutamos la sentencia atraves de Resultes
            ResultSet set = st.executeQuery(query);

            //ahora tenemos que mostrar el o los resultados, que hemos obtenido en nuestra sentencia
            while(set.next()){
                System.out.println("ID_Persona:"+set.getInt("id_persona")+" -"+"Nombre: "+set.getString("nombre")
                        +" - Apellidos:"+set.getString("apellido")+" - mail:"+set.getString("mail")+" - Telefono: " +
                        ""+set.getString("telefono"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
