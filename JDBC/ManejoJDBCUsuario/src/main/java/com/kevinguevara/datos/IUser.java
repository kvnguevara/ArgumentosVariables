package com.kevinguevara.datos;

import com.kevinguevara.usarios.Usuario;

import java.util.*;

public interface IUser {
    public int inserta(Usuario user);
    public int delete(Usuario user);
    public List<Usuario> selecionar();
    public int actualizar(Usuario user);
    public void mostrar();
}
