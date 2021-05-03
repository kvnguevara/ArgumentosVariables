package com.kevinguevara.datos;

import com.kevinguevara.usarios.Usuario;

import java.sql.SQLException;
import java.util.*;

public interface IUser {
    public int inserta(Usuario user) throws SQLException;
    public int delete(Usuario user) throws SQLException;
    public List<Usuario> selecionar() throws SQLException;
    public int actualizar(Usuario user) throws SQLException;
//    public void mostrar();
}
