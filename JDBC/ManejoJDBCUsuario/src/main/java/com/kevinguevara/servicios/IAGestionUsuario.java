package com.kevinguevara.servicios;

import com.kevinguevara.usarios.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IAGestionUsuario {
    public void insertaUsario(Usuario user) throws SQLException;
    public void eliminarUsario(Usuario user) throws SQLException;
    public void udpateUsario(Usuario user) throws SQLException;
    public void mostraUsarios() throws SQLException;
}
