package com.kevinguevara.datos;

import com.kevinguevara.domain.UsuarioDTO;

import java.sql.*;
import java.util.*;

import static com.kevinguevara.conexion.Conexion.*;

public class UsuarioDaoJDBC implements UsuarioDao, Iconsultas {
    private Connection conexionT;

    public UsuarioDaoJDBC() {
    }

    public UsuarioDaoJDBC(Connection conexionT) {
        this.conexionT = conexionT;
    }

    @Override
    public int insert(UsuarioDTO user) throws SQLException {
        Connection con = null;
        PreparedStatement prst = null;

        int registro = 0;
        try {
            //Pregunto si la conexion está inicializada
            con = conexionT != null ? this.conexionT : getConnection();
            prst = con.prepareStatement(SQL_INSERT_USER);
            prst.setString(1, user.getUserName());
            prst.setString(2, user.getPassword());
            registro = prst.executeUpdate();

        } finally {

            close(prst);
            if (this.conexionT == null) {
                close(con);
            }
        }

        return registro;
    }

    @Override
    public int delete(UsuarioDTO user) throws SQLException {
        Connection con = null;
        PreparedStatement prst = null;
        int registro = 0;
        try {
            con = this.conexionT != null ? this.conexionT : getConnection();
            prst = con.prepareStatement(SQL_DELETE_USER);
            prst.setInt(1, user.getIdUser());
            registro = prst.executeUpdate();

        } finally {
            close(prst);
            if (this.conexionT == null) {
                close(con);
            }

        }
        return registro;
    }

    @Override
    public int udpate(UsuarioDTO user) throws SQLException {
        int registro = 0;
        Connection con = null;
        PreparedStatement prst = null;
        try {
            con = this.conexionT != null ? this.conexionT : getConnection();
            prst = con.prepareStatement(SQL_DELETE_USER);
            registro = prst.executeUpdate();
        } finally {
            close(prst);
            if (this.conexionT == null) {
                close(con);
            }
        }
        return registro;
    }

    @Override
    public List<UsuarioDTO> select() throws SQLException {
        List<UsuarioDTO> listaUsa = new ArrayList<>();
        UsuarioDTO usuario;
        Connection con=null ;
        PreparedStatement prst= null;
        ResultSet rst= null;
        try {
            con = this.conexionT!= null? this.conexionT:getConnection();
            prst = con.prepareStatement(SQL_SELECT_USER);
            rst = prst.executeQuery();
            while (rst.next()){
                usuario = new UsuarioDTO(rst.getInt("id_usuario"),rst.getString("user"),
                        rst.getString("password") );
                listaUsa.add(usuario);

            }

        }finally {
            close(rst);
            close(prst);
            if (this.conexionT== null){
                close(con);
            }

        }
        return listaUsa;
    }
}
