package com.kevinguevara.datos;

public interface Iconsultas {
    static final String SQL_SELECT = "SELECT * FROM usuario";
    static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";
    static final String SQL_UPDATE = "UPDATE usuario SET  user = ?,password = ?  WHERE id_usuario = ?";
    static final String SQL_INSERT = "INSERT INTO usuario (user,password) VALUES(?,?)";
}
