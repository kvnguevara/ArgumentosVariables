package com.kevinguevara.servicios;

import com.kevinguevara.usarios.Usuario;

import java.util.List;

public interface IAGestionUsuario {
    public void insertaUsario(Usuario user);
    public void eliminarUsario(Usuario user);
    public void udpateUsario(Usuario user);
    public void mostraUsarios();
}
