package com.kevinguevara.datos;

import com.kevinguevara.domain.UsuarioDTO;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDao {
    public int insert(UsuarioDTO user) throws SQLException;

    public int delete(UsuarioDTO user) throws SQLException;

    public int udpate(UsuarioDTO user) throws SQLException;

    public List<UsuarioDTO> select() throws SQLException;
}
